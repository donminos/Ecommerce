package com.sysio.ecommerce.shop.web.controller;

import com.sysio.ecommerce.data.entity.DatosUsuario;
import com.sysio.ecommerce.data.entity.Roles;
import com.sysio.ecommerce.data.entity.UsuarioRol;
import com.sysio.ecommerce.data.entity.Usuarios;
import com.sysio.ecommerce.data.entity.altern.UsuariosDatosJsonView;
import com.sysio.ecommerce.data.session.DatosUsuarioSessionRemote;
import com.sysio.ecommerce.data.session.UsuarioRolSessionRemote;
import com.sysio.ecommerce.data.session.UsuariosSessionRemote;
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
    UsuarioRolSessionRemote usuarioRolSession = lookupUsuarioRolSessionRemote();

    UsuariosSessionRemote usuariosSession = lookupUsuariosSessionRemote();

    DatosUsuarioSessionRemote datosUsuarioSession = lookupDatosUsuarioSessionRemote();

    @RequestMapping(value = "/private/user/name.do", method = RequestMethod.GET, produces = "application/json")
    public Usuarios findName(Principal principal, HttpServletRequest request) throws Exception {
        Usuarios user = usuariosSession.findForEmail(principal.getName());
        user.getDatosUsuario().setUsuarios(null);
        user.getUsuarioRol().setUsuarios(null);
        user.setContrasena(null);
        user.getUsuarioRol().getIdRol().setUsuarioRolList(null);
        user.setPedidosList(null);
        System.out.println(request.isUserInRole("Administrador"));
        System.out.println(request.isUserInRole("Cliente"));
        return user;
    }

    @RequestMapping(value = "/private/user/logout.do", method = RequestMethod.GET, produces = "application/json")
    public void logout(Principal principal, HttpServletRequest request) throws Exception {
        request.getSession().invalidate();
    }

    @RequestMapping(value = "/public/user/agregarUsuario.do", method = RequestMethod.POST, produces = "application/json")
    public Usuarios agregarCarro(HttpServletRequest request, @RequestBody(required = true) UsuariosDatosJsonView datos) {
        UsuarioRol userrol=new UsuarioRol();
        DatosUsuario data = new DatosUsuario(datos);
        Usuarios usuario = new Usuarios();
        usuario.setUsuario(datos.getCorreo());
        usuario.setContrasena(datos.getPassword());
        usuario.setDatosUsuario(data);
        userrol.setUsuarios(usuario);
        usuarioRolSession.createUserCliente(userrol);
        return usuario;
    }

    private DatosUsuarioSessionRemote lookupDatosUsuarioSessionRemote() {
        try {
            Context c = new InitialContext();
            return (DatosUsuarioSessionRemote) c.lookup("java:global/ecommerce-ejb/DatosUsuarioSession!com.sysio.ecommerce.data.session.DatosUsuarioSessionRemote");
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

    private UsuarioRolSessionRemote lookupUsuarioRolSessionRemote() {
        try {
            Context c = new InitialContext();
            return (UsuarioRolSessionRemote) c.lookup("java:global/ecommerce-ejb/UsuarioRolSession!com.sysio.ecommerce.data.session.UsuarioRolSessionRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
