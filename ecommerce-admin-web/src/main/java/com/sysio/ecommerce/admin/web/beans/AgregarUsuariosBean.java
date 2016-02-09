package com.sysio.ecommerce.admin.web.beans;

import com.sysio.ecommerce.data.entity.DatosUsuario;
import com.sysio.ecommerce.data.entity.Roles;
import com.sysio.ecommerce.data.entity.Usuarios;
import com.sysio.ecommerce.data.session.RolesSessionRemote;
import com.sysio.ecommerce.data.session.UsuarioRolSessionRemote;
import com.sysio.ecommerce.data.session.UsuariosSessionRemote;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Named(value = "agregarUsuariosBean")
@RequestScoped
public class AgregarUsuariosBean {
    @EJB
    private RolesSessionRemote rolesSession;
    @EJB
    private UsuariosSessionRemote usuariosSession;
    @EJB
    private UsuarioRolSessionRemote usuarioRolSession;
    

    @Setter
    @Getter
    Usuarios usuario;

    @Setter
    @Getter
    DatosUsuario datosusuario;

    @Setter
    @Getter
    List<Roles> LstRoles;

    @Setter
    @Getter
    List<Usuarios> LstUsuario;

    public AgregarUsuariosBean() {
    }
    
    @PostConstruct
    public void init(){
        this.LstRoles=rolesSession.findAll();
    }

}
