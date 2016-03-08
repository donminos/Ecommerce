package com.sysio.ecommerce.admin.web.beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Named(value = "indexBean")
@RequestScoped
public class IndexBean {
    HttpServletRequest request;
    public IndexBean() {
        FacesContext context = FacesContext.getCurrentInstance();
        request = (HttpServletRequest) context.getExternalContext().getRequest();
    }
    
    @Setter @Getter private String usuario;
    @Setter @Getter private String contrasena;

    public String login() {
        try {
            System.out.println(usuario);
            System.out.println(contrasena);
            request.login(usuario, contrasena);
            System.out.println(request.getUserPrincipal().getName());
            System.out.println(request.isUserInRole("Administrador"));
            System.out.println(request.isUserInRole("Cliente"));
        } catch (ServletException ex) {
            Logger.getLogger(IndexBean.class.getName()).log(Level.SEVERE, null, ex);
            request.getSession().invalidate();
        }
        return "control/panelControl?faces-redirect=true";
    }

    public void logout() {
        request.getSession().invalidate();
    }

}
