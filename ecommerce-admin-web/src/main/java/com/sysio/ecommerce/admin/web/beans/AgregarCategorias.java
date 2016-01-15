/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.admin.web.beans;

import com.sysio.ecommerce.data.entity.Categorias;
import com.sysio.ecommerce.data.session.CategoriasSessionRemote;
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
@Named(value = "agregarCategorias")
@RequestScoped
public class AgregarCategorias {

    @EJB
    private CategoriasSessionRemote categoriasSession;
    
    @Setter @Getter Categorias categoria;

    public AgregarCategorias() {
        categoria=new Categorias();
    }
    
    public List<Categorias> lstCategorias(){
        return categoriasSession.findAll();
    }
    
    public void handlerCrear(){
        categoriasSession.create(categoria);
    }
    
}
