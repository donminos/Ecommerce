package com.sysio.ecommerce.admin.web.beans;

import com.sysio.ecommerce.data.entity.Categorias;
import com.sysio.ecommerce.data.entity.Marca;
import com.sysio.ecommerce.data.entity.Productos;
import com.sysio.ecommerce.data.session.CategoriasSessionRemote;
import com.sysio.ecommerce.data.session.MarcaSessionRemote;
import com.sysio.ecommerce.data.session.ProductosSessionRemote;
import java.util.ArrayList;
import java.util.LinkedList;
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
@Named(value = "agregarProductosBean")
@RequestScoped
public class AgregarProductosBean {

    @EJB
    private MarcaSessionRemote marcaSession;
    @EJB
    private CategoriasSessionRemote categoriasSession;
    @EJB
    private ProductosSessionRemote productosSession;

    @Getter
    @Setter
    private Productos producto;

    @Getter
    @Setter
    private List<String> subproducto;

    @Getter
    @Setter
    private Integer marca;

    @Getter
    @Setter
    private List<String> categorias;

    public AgregarProductosBean() {
        producto = new Productos();
    }

    public List<Productos> getListProductos() {
        List<Productos> prods;
        prods = productosSession.findAllFetch();
        return prods;
    }

    public List<Marca> getListMarcas() {
        return marcaSession.findAll();
    }

    public void createProducto() {
        List<Productos> listProd = new LinkedList();
        for (String produc : subproducto) {
            listProd.add(productosSession.find(Integer.parseInt(produc)));
        }
        List<Categorias> listCat = new LinkedList();
        for (String categoria : categorias) {
            listCat.add(categoriasSession.find(Integer.parseInt(categoria)));
        }
        producto.setIdMarca(marcaSession.find(marca));
        producto.setProductosList(listProd);
        producto.setCategoriasList(listCat);
        productosSession.AgregarProducto(producto);

        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage("Completo", "El registro del producto se agrego satisfactoriamente"));
    }

    public List<Productos> getListSubProductos(Integer id) {
        Productos prod = productosSession.find(id);
        List<Productos> sublista = productosSession.findAll();
        sublista.remove(prod);
        return sublista;
    }

    public List<Categorias> getListCategorias() {
        return categoriasSession.findAll();
    }

    public String getConcatenarCategorias(List<Categorias> categoriasincluidas) {
        String categoriasconcat = "";
        for (Categorias cat : categoriasincluidas) {
            categoriasconcat += cat.getNombre() + ",";
        }
        categoriasconcat = categoriasconcat.substring(0, categoriasconcat.length() - 1);
        return categoriasconcat;
    }
}
