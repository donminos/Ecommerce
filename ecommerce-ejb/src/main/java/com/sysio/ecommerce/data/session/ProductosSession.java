/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.session;

import com.sysio.ecommerce.data.entity.Productos;
import com.sysio.ecommerce.data.facade.ProductosFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Stateless
public class ProductosSession implements ProductosSessionRemote {
    @EJB
    private ProductosFacadeLocal productosFacade;

    @Override
    public void create(Productos productos) {
        productosFacade.create(productos);
    }

    @Override
    public void edit(Productos productos) {
        productosFacade.edit(productos);
    }

    @Override
    public void remove(Productos productos) {
        productosFacade.remove(productos);
    }

    @Override
    public Productos find(Object id) {
        return productosFacade.find(id);
    }

    @Override
    public List<Productos> findAll() {
        return productosFacade.findAll();
    }

    @Override
    public List<Productos> findRange(int[] range) {
        return productosFacade.findRange(range);
    }

    @Override
    public int count() {
        return productosFacade.count();
    }

    @Override
    public void AgregarProducto(Productos producto) {
        productosFacade.AgregarProducto(producto);
    }

    @Override
    public List<Productos> findAllFetch() {
        return productosFacade.findAllFetch();
    }

    @Override
    public List<Productos> findAllSubFetch(Productos producto) {
        List<Productos> lst=productosFacade.findAllSubFetch(producto);
        return lst;
    }

    @Override
    public void AgregarSubProducto(Productos productoprim, Productos productosec) {
        productosFacade.AgregarSubProducto(productoprim, productosec);
    }

    @Override
    public void AgregarSubProducto(Productos productoprim, List<Productos> productosec) {
        productosFacade.AgregarSubProducto(productoprim, productosec);
    }
        
}
