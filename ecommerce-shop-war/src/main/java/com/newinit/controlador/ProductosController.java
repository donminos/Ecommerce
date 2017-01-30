package com.newinit.controlador;

import com.newinit.controlador.vista.JsonResponseView;
import com.newinit.servicios.ProductosServices;
import com.sysio.ecommerce.data.entity.altern.Filtros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@RestController
@RequestMapping("/public/productos")
public class ProductosController {

    @Autowired
    ProductosServices productosservices;

    @RequestMapping(value = "/findAll.do", method = RequestMethod.POST , produces = "application/json")
    public JsonResponseView findAll(@RequestBody Filtros filtro) {
        JsonResponseView json=new JsonResponseView();
        json.getResponse().put("Productos", productosservices.findAll(filtro));
        return json;
    }

    @RequestMapping(value = "/findId.do>{id}", method = RequestMethod.GET, produces = "application/json")
    public JsonResponseView findId(@PathVariable("id") Integer id) {
        JsonResponseView json=new JsonResponseView();
        json.getResponse().put("Producto", productosservices.findId(id));
        return json;
    }


}
