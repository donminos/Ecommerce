/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.facade;

import com.sysio.ecommerce.data.entity.Pedidos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Local
public interface PedidosFacadeLocal {

    void create(Pedidos pedidos);

    void edit(Pedidos pedidos);

    void remove(Pedidos pedidos);

    Pedidos find(Object id);

    List<Pedidos> findAll();

    List<Pedidos> findRange(int[] range);

    int count();
    
    List<Pedidos> findAllStatus(Integer status);
    
}
