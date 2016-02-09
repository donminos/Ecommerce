/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.session;

import com.sysio.ecommerce.data.entity.UsuarioRol;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Remote
public interface UsuarioRolSessionRemote {

    public void create(UsuarioRol usuarioRol);

    public void edit(UsuarioRol usuarioRol);

    public void remove(UsuarioRol usuarioRol);

    public UsuarioRol find(Object id);

    public List<UsuarioRol> findAll();

    public List<UsuarioRol> findRange(int[] range);

    public int count();
}
