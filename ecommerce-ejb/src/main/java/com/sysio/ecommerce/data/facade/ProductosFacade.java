/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.facade;

import com.sysio.ecommerce.data.entity.Categorias;
import com.sysio.ecommerce.data.entity.Productos;
import java.math.BigInteger;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Stateless
public class ProductosFacade extends AbstractFacade<Productos> implements ProductosFacadeLocal {

    @PersistenceContext(unitName = "ecommerce-ejb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductosFacade() {
        super(Productos.class);
    }
    @Override
    public List<Productos> findAllFetch(){
        Query query = em.createQuery("SELECT distinct p FROM Productos p JOIN FETCH p.categoriasList",Productos.class);
        List<Productos> productos=query.getResultList();
        return productos;
    }

    @Override
    public void AgregarProducto(Productos producto) {

        try {
            Query query = em.createNativeQuery("INSERT INTO Productos (Descripcion,Costo,Cantidad,Nombre,Detalle,Marca) values(?,?,?,?,?,?)");
            query.setParameter(1, producto.getDescripcion());
            query.setParameter(2, producto.getCosto());
            query.setParameter(3, producto.getCantidad());
            query.setParameter(4, producto.getNombre());
            query.setParameter(5, producto.getDetalle());
            query.setParameter(6, producto.getMarca());
            query.executeUpdate();
            producto.setIdProducto(((BigInteger) em.createNativeQuery("SELECT LAST_INSERT_ID()").getSingleResult()).intValue() ); //opcion SELECT LAST_INSERT_ID() ó SELECT @@IDENTITY
            for (Categorias cat : producto.getCategoriasList()) {
                query = em.createNativeQuery("INSERT INTO CategoriaProductos (idProducto,idCategoria) values(?,?)");
                query.setParameter(1, producto.getIdProducto());
                query.setParameter(2, cat.getIdCategoria());
                query.executeUpdate();
            }
            for (Productos prod : producto.getProductosList()) {
                query = em.createNativeQuery("INSERT INTO Subproductos (idProducto,idSubproducto) values(?,?)");
                query.setParameter(1, producto.getIdProducto());
                query.setParameter(2, prod.getIdProducto());
                query.executeUpdate();
            }
        }catch (Exception ex) {
            Logger.getLogger(ProductosFacade.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
