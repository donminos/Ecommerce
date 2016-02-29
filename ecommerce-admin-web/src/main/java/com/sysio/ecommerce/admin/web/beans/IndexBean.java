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

    public void login() {
        try {
            request.login("", "");
        } catch (ServletException ex) {
            Logger.getLogger(IndexBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void logout() {

    }

}
