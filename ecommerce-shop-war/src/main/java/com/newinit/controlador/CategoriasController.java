
package com.newinit.controlador;

import com.newinit.controlador.vista.JsonResponseView;
import com.newinit.servicios.CategoriasServices;
import com.sysio.ecommerce.data.entity.Categorias;
import com.sysio.ecommerce.data.session.CategoriasSessionRemote;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Log
@RestController
@RequestMapping("/public/categorias")
public class CategoriasController {
    
    @Autowired
    CategoriasServices categoriasservices;
    
    @RequestMapping(value = "/findAll.do", method = RequestMethod.GET, produces = "application/json")
    public JsonResponseView findAll() {
        JsonResponseView json=new JsonResponseView();
        json.getResponse().put("Categorias", categoriasservices.findAll());
        return json;
    }
    @RequestMapping(value = "/findId.do>{id}", method = RequestMethod.GET, produces = "application/json")
    public JsonResponseView findId(@PathVariable("id") Integer id){
        JsonResponseView json=new JsonResponseView();
        json.getResponse().put("Categoria", categoriasservices.findId(id));
        return json;
    }
}
