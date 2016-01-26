/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.admin.web.beans;

import com.sysio.ecommerce.data.entity.Marca;
import com.sysio.ecommerce.data.session.MarcaSessionRemote;
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
@Named(value = "agregarMarcasBean")
@RequestScoped
public class AgregarMarcasBean {

    @EJB
    private MarcaSessionRemote marcaSession;

    @Getter
    @Setter
    private Marca marca;

    public AgregarMarcasBean() {
        marca=new Marca();
    }

    public List<Marca> getLstMarcas() {
        return marcaSession.findAll();
    }
    
    public void createMarca(){
        if(marca.getIdMarca()==null){
            marcaSession.create(marca);
        }else{
            marcaSession.edit(marca);
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Completo",  "El registro de la Marca agrego satisfactoriamente") );
    }
    
    public void modMarca(Marca marca){
        this.marca=marca;
    }

}
