/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.session;

import com.sysio.ecommerce.data.entity.Pedidos;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Remote
public interface PedidosSessionRemote {

    public void create(Pedidos pedidos);

    public void edit(Pedidos pedidos);

    public void remove(Pedidos pedidos);

    public Pedidos find(Object id);

    public List<Pedidos> findAll();

    public List<Pedidos> findRange(int[] range);

    public int count();

    public List<Pedidos> findAllStatus(Integer status);
    
    public List<Pedidos> findAllFetch();
    
}
