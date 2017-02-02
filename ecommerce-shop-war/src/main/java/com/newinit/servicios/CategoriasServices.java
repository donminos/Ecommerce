package com.newinit.servicios;

import com.sysio.ecommerce.data.entity.Categorias;
import com.sysio.ecommerce.data.session.CategoriasSessionRemote;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author ceasar
 */
@Service("CategoriasServices")
public class CategoriasServices {

    CategoriasSessionRemote categoriasSession = lookupCategoriasSessionRemote();

    public List<Categorias> findAll() {
        List<Categorias> cats = categoriasSession.findAllFetch();
        for (int i = 0; i < cats.size(); i++) {
            cats.get(i).setProductosList(new ArrayList());
            cats.get(i).setCategoriasList(new ArrayList());
            for (int j = 0; j < cats.get(i).getCategoriasList1().size(); j++) {
                cats.remove(cats.get(i).getCategoriasList1().get(j));
                cats.get(i).getCategoriasList1().get(j).setProductosList(new ArrayList());
                cats.get(i).getCategoriasList1().get(j).setCategoriasList(new ArrayList());
                for (int k = 0; k < cats.get(i).getCategoriasList1().get(j).getCategoriasList1().size(); k++) {
                    cats.remove(cats.get(i).getCategoriasList1().get(j).getCategoriasList1().get(k));
                    cats.get(i).getCategoriasList1().get(j).getCategoriasList1().get(k).setProductosList(new ArrayList());
                    cats.get(i).getCategoriasList1().get(j).getCategoriasList1().get(k).setCategoriasList(new ArrayList());
                }
            }
        }
        return cats;
    }

    public Categorias findId(Integer id) {
        Categorias cat = categoriasSession.find(id);
        cat.setCategoriasList(new ArrayList());
        cat.setCategoriasList1(new ArrayList());
        cat.setProductosList(new ArrayList());
        return cat;
    }

    private CategoriasSessionRemote lookupCategoriasSessionRemote() {
        try {
            Context c = new InitialContext();
            return (CategoriasSessionRemote) c.lookup("java:global/ecommerce-ejb-1.0/CategoriasSession!com.sysio.ecommerce.data.session.CategoriasSessionRemote");
        } catch (NamingException ne) {
            throw new RuntimeException(ne);
        }
    }
}
