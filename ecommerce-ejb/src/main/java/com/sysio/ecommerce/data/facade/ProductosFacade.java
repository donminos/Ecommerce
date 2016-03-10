/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.facade;

import com.sysio.ecommerce.data.entity.Categorias;
import com.sysio.ecommerce.data.entity.Productos;
import com.sysio.ecommerce.data.entity.altern.Filtros;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lombok.extern.java.Log;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Log
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
    public List<Productos> findAllFetch() {
        Query query = em.createQuery("SELECT distinct p FROM Productos p JOIN FETCH p.idMarca JOIN FETCH p.categoriasList LEFT JOIN FETCH p.productosList WHERE p.activo=1", Productos.class);
        List<Productos> productos = query.getResultList();
        return productos;
    }

    @Override
    public List<Productos> findAllFetch(Filtros filtro) {
        String sql = "SELECT distinct p FROM Productos p JOIN FETCH p.idMarca m JOIN FETCH p.categoriasList c LEFT JOIN FETCH c.categoriasList c1 LEFT JOIN FETCH c1.categoriasList c2 LEFT JOIN FETCH p.productosList p1 WHERE p.activo=1";
        if (filtro != null) {
            if (filtro.getCategoria()!=null) {
                sql += " AND c.idCategoria=:cat OR c1.idCategoria=:cat OR c2.idCategoria=:cat";
            } else if (filtro.getMarca()!=null) {
                sql += " AND m.idMarca=:mar";
            } else if (filtro.getPalabraClave()!=null) {
                sql += " AND p.nombre LIKE :pro OR UPPER(p.descripcion) LIKE :pro OR p.detalle LIKE :pro";
            }
        }
        Query query = em.createQuery(sql, Productos.class);
        if (filtro != null) {
            if (filtro.getCategoria()!=null) {
                query.setParameter("cat", filtro.getCategoria());
            } else if (filtro.getMarca()!=null) {
                query.setParameter("mar", filtro.getMarca());
            } else if (filtro.getPalabraClave()!=null) {
                query.setParameter("pro", "%"+filtro.getPalabraClave()+"%");
            }
        }
        List<Productos> productos = query.getResultList();
        return productos;
    }

    @Override
    public List<Productos> findAllSubFetch(Productos producto) {
        List<Productos> prods = new ArrayList();
        try {
            Query query = em.createQuery("SELECT distinct p FROM Productos p " +/*JOIN FETCH p.productosList1*/ " WHERE p.idProducto = :prod", Productos.class);
            query.setParameter("prod", producto.getIdProducto());
            Productos productos = (Productos) query.getSingleResult();

            for (Productos prod : productos.getProductosList()) {
                prods.add(prod);
            }

        } catch (Exception ex) {
            log.severe(ex.getMessage());
        }
        return prods;
    }

    @Override
    public void AgregarSubProducto(Productos productoprim, Productos productosec) {
        Query query = em.createNativeQuery("INSERT INTO Subproductos (idProducto,idSubproducto) values(?,?)");
        query.setParameter(1, productoprim.getIdProducto());
        query.setParameter(2, productosec.getIdProducto());
        query.executeUpdate();
    }

    @Override
    public void AgregarSubProducto(Productos productoprim, List<Productos> productosec) {
        for (Productos subprod : productosec) {
            Query query = em.createNativeQuery("INSERT INTO Subproductos (idProducto,idSubproducto) values(?,?)");
            query.setParameter(1, productoprim.getIdProducto());
            query.setParameter(2, subprod.getIdProducto());
            query.executeUpdate();
        }
    }

    @Override
    public void AgregarProducto(Productos producto) {
        try {
            producto.setActivo((short) 1);
            em.persist(producto);
            em.flush();
            producto.setIdProducto(((BigInteger) em.createNativeQuery("SELECT LAST_INSERT_ID()").getSingleResult()).intValue()); //opcion SELECT LAST_INSERT_ID() ó SELECT @@IDENTITY
            for (Categorias cat : producto.getCategoriasList()) {
                Query query = em.createNativeQuery("INSERT INTO CategoriaProductos (idProducto,idCategoria) values(?,?)");
                query.setParameter(1, producto.getIdProducto());
                query.setParameter(2, cat.getIdCategoria());
                query.executeUpdate();
            }
            for (Productos prod : producto.getProductosList()) {
                Query query = em.createNativeQuery("INSERT INTO Subproductos (idProducto,idSubproducto) values(?,?)");
                query.setParameter(1, producto.getIdProducto());
                query.setParameter(2, prod.getIdProducto());
                query.executeUpdate();
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductosFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void EditarProducto(Productos producto) {
        producto.setActivo((short) 1);
        em.merge(producto);
        try {
            if (!producto.getCategoriasList().isEmpty()) {
                Query query = em.createNativeQuery("DELETE FROM CategoriaProductos WHERE idProducto=?");
                query.setParameter(1, producto.getIdProducto());
                query.executeUpdate();
                for (Categorias cat : producto.getCategoriasList()) {
                    query = em.createNativeQuery("INSERT INTO CategoriaProductos (idProducto,idCategoria) values(?,?)");
                    query.setParameter(1, producto.getIdProducto());
                    query.setParameter(2, cat.getIdCategoria());
                    query.executeUpdate();
                }
            }
            if (!producto.getProductosList().isEmpty()) {
                Query query = em.createNativeQuery("DELETE FROM Subproductos WHERE idProducto=?");
                query.setParameter(1, producto.getIdProducto());
                query.executeUpdate();
                for (Productos prod : producto.getProductosList()) {
                    query = em.createNativeQuery("INSERT INTO Subproductos (idProducto,idSubproducto) values(?,?)");
                    query.setParameter(1, producto.getIdProducto());
                    query.setParameter(2, prod.getIdProducto());
                    query.executeUpdate();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductosFacade.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
