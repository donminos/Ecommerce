
package com.sysio.ecommerce.data.session;

import com.sysio.ecommerce.data.entity.Usuarios;
import com.sysio.ecommerce.data.facade.UsuariosFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Stateless
public class UsuariosSession implements UsuariosSessionRemote {
    @EJB
    private UsuariosFacadeLocal usuariosFacade;

    @Override
    public void create(Usuarios usuarios) {
        usuariosFacade.create(usuarios);
    }

    @Override
    public void edit(Usuarios usuarios) {
        usuariosFacade.edit(usuarios);
    }

    @Override
    public void remove(Usuarios usuarios) {
        usuariosFacade.remove(usuarios);
    }

    @Override
    public Usuarios find(Object id) {
        return usuariosFacade.find(id);
    }

    @Override
    public List<Usuarios> findAll() {
        return usuariosFacade.findAll();
    }

    @Override
    public List<Usuarios> findRange(int[] range) {
        return usuariosFacade.findRange(range);
    }

    @Override
    public int count() {
        return usuariosFacade.count();
    }

    @Override
    public Usuarios findUserForEmail(String email) {
        Usuarios user=usuariosFacade.findUserForEmail(email);
        return user;
    }   

}
