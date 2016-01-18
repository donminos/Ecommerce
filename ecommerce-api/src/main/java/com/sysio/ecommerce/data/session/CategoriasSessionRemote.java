/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.session;

import com.sysio.ecommerce.data.entity.Categorias;
import com.sysio.ecommerce.data.entity.Productos;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Remote
public interface CategoriasSessionRemote {
    public void create(Categorias categorias);

    public void edit(Categorias categorias);

    public void remove(Categorias categorias);

    public Categorias find(Object id);

    public List<Categorias> findAll();

    public List<Categorias> findRange(int[] range);

    public int count();
    
    public List<Categorias> categoriasForProducto(Productos producto);
}
