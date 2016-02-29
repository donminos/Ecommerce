/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.facade;

import com.sysio.ecommerce.data.entity.DatosUsuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Local
public interface DatosUsuarioFacadeLocal {

    void create(DatosUsuario datosUsuario);

    void edit(DatosUsuario datosUsuario);

    void remove(DatosUsuario datosUsuario);

    DatosUsuario find(Object id);

    List<DatosUsuario> findAll();

    List<DatosUsuario> findRange(int[] range);

    int count();
}
