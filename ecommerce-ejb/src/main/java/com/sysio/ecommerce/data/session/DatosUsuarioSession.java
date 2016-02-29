package com.sysio.ecommerce.data.session;

import com.sysio.ecommerce.data.entity.DatosUsuario;
import com.sysio.ecommerce.data.facade.DatosUsuarioFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Stateless
public class DatosUsuarioSession implements DatosUsuarioSessionRemote {
    @EJB
    private DatosUsuarioFacadeLocal datosUsuarioFacade;

    @Override
    public void create(DatosUsuario datosUsuario) {
        datosUsuarioFacade.create(datosUsuario);
    }

    @Override
    public void edit(DatosUsuario datosUsuario) {
        datosUsuarioFacade.edit(datosUsuario);
    }

    @Override
    public void remove(DatosUsuario datosUsuario) {
        datosUsuarioFacade.remove(datosUsuario);
    }

    @Override
    public DatosUsuario find(Object id) {
        return datosUsuarioFacade.find(id);
    }

    @Override
    public List<DatosUsuario> findAll() {
        return datosUsuarioFacade.findAll();
    }

    @Override
    public List<DatosUsuario> findRange(int[] range) {
        return datosUsuarioFacade.findRange(range);
    }

    @Override
    public int count() {
        return datosUsuarioFacade.count();
    }

}
