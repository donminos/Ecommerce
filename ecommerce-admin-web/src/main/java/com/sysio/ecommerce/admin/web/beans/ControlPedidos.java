/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.admin.web.beans;

import com.sysio.ecommerce.data.entity.Estatus;
import com.sysio.ecommerce.data.entity.Pedidos;
import com.sysio.ecommerce.data.session.EstatusSessionRemote;
import com.sysio.ecommerce.data.session.PedidosSessionRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Named(value = "controlPedidos")
@RequestScoped
public class ControlPedidos {

    @EJB
    private EstatusSessionRemote estatusSession;

    @EJB
    private PedidosSessionRemote pedidosSession;
    
    @Getter @Setter Integer status;
    
    public ControlPedidos() {
    }
    
    public List<Pedidos> getLstPedidos(){
        return pedidosSession.findAll(); 
    }
    
    public List<Estatus> getLstStatus(){
        return estatusSession.findAll();
    }
    
}
