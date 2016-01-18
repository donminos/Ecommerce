/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.session;

import com.sysio.ecommerce.data.entity.Productos;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Remote
public interface ProductosSessionRemote {
    public void create(Productos productos);

    public void edit(Productos productos);

    public void remove(Productos productos);

    public Productos find(Object id);

    public List<Productos> findAll();

    public List<Productos> findRange(int[] range);

    public int count();
    
    public void AgregarProducto(Productos producto);
    
    public List<Productos> findAllFetch();
    
    public List<Productos> findAllSubFetch(Productos producto);
    
    public void AgregarSubProducto(Productos productoprim, Productos productosec);
}
