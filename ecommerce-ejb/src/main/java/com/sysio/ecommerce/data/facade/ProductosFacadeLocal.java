/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.facade;

import com.sysio.ecommerce.data.entity.Productos;
import com.sysio.ecommerce.data.entity.altern.Filtros;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Local
public interface ProductosFacadeLocal {

    void create(Productos productos);

    void edit(Productos productos);

    void remove(Productos productos);

    Productos find(Object id);

    List<Productos> findAll();

    List<Productos> findRange(int[] range);

    int count();
    
    void AgregarProducto(Productos producto);
    
    List<Productos> findAllFetch(Filtros filtro);
    
    List<Productos> findAllFetch();
    
    List<Productos> findAllSubFetch(Productos producto);
    
    void AgregarSubProducto(Productos productoprim, Productos productosec);
    
    void AgregarSubProducto(Productos productoprim, List<Productos> productosec);
    
    void EditarProducto(Productos producto);
}
