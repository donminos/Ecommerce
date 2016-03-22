package com.sysio.ecommerce.shop.web.controller;

import com.sysio.ecommerce.data.entity.DatosUsuario;
import com.sysio.ecommerce.data.entity.UsuarioRol;
import com.sysio.ecommerce.data.entity.Usuarios;
import com.sysio.ecommerce.data.entity.altern.JsonResponseView;
import com.sysio.ecommerce.data.entity.altern.UsuariosDatosJsonView;
import com.sysio.ecommerce.data.session.UsuarioRolSessionRemote;
import com.sysio.ecommerce.data.session.UsuariosSessionRemote;
import com.sysio.ecommerce.data.transfer.DataToDatosUsuariosTransfer;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@RestController
public class UsuariosController {

    UsuariosSessionRemote usuariosSession = lookupUsuariosSessionRemote();

    UsuarioRolSessionRemote usuarioRolSession = lookupUsuarioRolSessionRemote();

    @RequestMapping(value = "/private/user/name.do", method = RequestMethod.GET, produces = "application/json")
    public Usuarios findName(Principal principal, HttpServletRequest request) throws Exception {
        if(!request.isUserInRole("Cliente")){
            request.getSession().invalidate();
        }
        Usuarios user = usuariosSession.findUserForEmail(principal.getName());
        user.getDatosUsuario().setUsuarios(null);
        user.getUsuarioRol().setUsuarios(null);
        user.setContrasena(null);
        user.getUsuarioRol().getIdRol().setUsuarioRolList(null);
        user.setPedidosList(null);
        return user;
    }

    @RequestMapping(value = "/private/user/logout.do", method = RequestMethod.GET, produces = "application/json")
    public void logout(Principal principal, HttpServletRequest request) throws Exception {
        request.getSession().invalidate();
    }

    @RequestMapping(value = "/public/user/agregarUsuario.do", method = RequestMethod.POST, produces = "application/json")
    public Usuarios agregarCarro(HttpServletRequest request, @RequestBody(required = true) UsuariosDatosJsonView datos) {
        UsuarioRol userrol = new UsuarioRol();
        DatosUsuario data = new DataToDatosUsuariosTransfer().transferData(datos);
        Usuarios usuario = new Usuarios();
        usuario.setUsuario(datos.getCorreo());
        usuario.setContrasena(datos.getPassword());
        usuario.setDatosUsuario(data);
        userrol.setUsuarios(usuario);
        usuarioRolSession.createUserCliente(userrol);
        return usuario;
    }

    @RequestMapping(value = "/public/user/login.do", method = RequestMethod.POST)
    public JsonResponseView login(HttpServletRequest request,Principal principal) {
        JsonResponseView json=new JsonResponseView();
        if(request.isUserInRole("Cliente") && principal.getName()!=null){
            return json;
        }else{
            json.getResponse().put("success", false);
            return json;
        }
    }

    private UsuarioRolSessionRemote lookupUsuarioRolSessionRemote() {
        try {
            Context c = new InitialContext();
            return (UsuarioRolSessionRemote) c.lookup("java:global/ecommerce-ejb/UsuarioRolSession!com.sysio.ecommerce.data.session.UsuarioRolSessionRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private UsuariosSessionRemote lookupUsuariosSessionRemote() {
        try {
            Context c = new InitialContext();
            return (UsuariosSessionRemote) c.lookup("java:global/ecommerce-ejb/UsuariosSession!com.sysio.ecommerce.data.session.UsuariosSessionRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
