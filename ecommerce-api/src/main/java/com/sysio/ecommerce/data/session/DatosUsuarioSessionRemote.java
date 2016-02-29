/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.session;

import com.sysio.ecommerce.data.entity.DatosUsuario;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Remote
public interface DatosUsuarioSessionRemote {
    public void create(DatosUsuario datosUsuario);

    public void edit(DatosUsuario datosUsuario);

    public void remove(DatosUsuario datosUsuario);

    public DatosUsuario find(Object id);

    public List<DatosUsuario> findAll();

    public List<DatosUsuario> findRange(int[] range);

    public int count();
}
