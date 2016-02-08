package com.sysio.ecommerce.admin.web.beans;

import com.sysio.ecommerce.data.entity.Categorias;
import com.sysio.ecommerce.data.session.CategoriasSessionRemote;
import java.io.Serializable;
import java.util.ArrayList;
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
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Named(value = "agregarCategoriasBean")
@RequestScoped
public class AgregarCategoriasBean implements Serializable {

    @EJB
    private CategoriasSessionRemote categoriasSession;

    @Setter
    @Getter
    private Categorias categoria;

    @Setter
    @Getter
    private List<String> subcategoria;

    public AgregarCategoriasBean() {
        categoria = new Categorias();
    }

    public void createCategoria() {
        if (categoria.getIdCategoria() == null) {
            List<Categorias> subcatsObj = new ArrayList();
            for (String cats : subcategoria) {
                subcatsObj.add(categoriasSession.find(Integer.valueOf(cats)));
            }
            categoria.setCategoriasList1(subcatsObj);
            categoriasSession.createSubCategoria(categoria);
        } else {
            List<Categorias> subcatsObj = new ArrayList();
            for (String cats : subcategoria) {
                subcatsObj.add(categoriasSession.find(Integer.valueOf(cats)));
            }
            categoria.setCategoriasList1(subcatsObj);
            categoriasSession.editSubCategoria(categoria);
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Completo", "Se ha aplicado el cambio"));

    }

    public List<Categorias> getLstCategorias() {
        return categoriasSession.findAllFetch();
    }

    public List<Categorias> getLstSubCategorias() {

        List<Categorias> cats = categoriasSession.findAll();
        if (categoria != null) {
            cats.remove(categoria);
        }
        return cats;
    }

    public void chargeCategoria(Categorias catlst) {
        this.categoria = catlst;
    }

    public void removeCategoria(Categorias categoria, Categorias catprincipal) {
        List<Categorias> subcategory = new ArrayList();
        subcategory.add(categoria);
        catprincipal.setCategoriasList1(subcategory);
        categoriasSession.removeSubCategoria(catprincipal);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Se ha removido la subcategoria");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void removeCategoria(Categorias categoria) {
        try {
            categoriasSession.removeCategoria(categoria);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Se ha removido la categoria");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (javax.ejb.EJBTransactionRolledbackException ex) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La categoria tiene productos ligados");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

}
