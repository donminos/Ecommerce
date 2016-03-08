
package com.sysio.ecommerce.data.session;

import com.google.common.base.Charsets;
import com.sysio.ecommerce.data.entity.UsuarioRol;
import com.google.common.hash.Hashing;
import com.sysio.ecommerce.data.facade.UsuarioRolFacadeLocal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Stateless
public class UsuarioRolSession implements UsuarioRolSessionRemote {
    @EJB
    private UsuarioRolFacadeLocal usuarioRolFacade;

    @Override
    public void create(UsuarioRol usuarioRol) {
        usuarioRolFacade.create(usuarioRol);
    }

    @Override
    public void edit(UsuarioRol usuarioRol) {
        usuarioRolFacade.edit(usuarioRol);
    }

    @Override
    public void remove(UsuarioRol usuarioRol) {
        usuarioRolFacade.remove(usuarioRol);
    }

    @Override
    public UsuarioRol find(Object id) {
        return usuarioRolFacade.find(id);
    }

    @Override
    public List<UsuarioRol> findAll() {
        return usuarioRolFacade.findAll();
    }

    @Override
    public List<UsuarioRol> findRange(int[] range) {
        return usuarioRolFacade.findRange(range);
    }

    @Override
    public int count() {
        return usuarioRolFacade.count();
    }

    @Override
    public BigInteger createUserCliente(UsuarioRol user) {
        user.getUsuarios().setContrasena((Hashing.sha256().hashString(user.getUsuarios().getContrasena(), Charsets.UTF_8).toString()));        
        return usuarioRolFacade.createUserCliente(user);
    }

}
