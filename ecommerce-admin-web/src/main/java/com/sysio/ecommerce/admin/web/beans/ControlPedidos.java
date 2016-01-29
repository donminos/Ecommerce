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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
        status=1;
    }
    
    public List<Pedidos> getLstPedidos(){
        return pedidosSession.findAll(); 
    }
    
    public List<Estatus> getLstStatus(){
        return estatusSession.findAll();
    }
    
    public void changeStatus(Pedidos pedido){
        pedido.setIdStatus(estatusSession.find(this.status));
        pedidosSession.edit(pedido);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Completo",  "El pedido ha pasado a "+pedido.getIdStatus().getEstatus()));
    }
    
}
