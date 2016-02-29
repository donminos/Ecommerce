/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.session;

import com.sysio.ecommerce.data.entity.Usuarios;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Remote
public interface UsuariosSessionRemote {

    public void create(Usuarios usuarios);

    public void edit(Usuarios usuarios);

    public void remove(Usuarios usuarios);

    public Usuarios find(Object id);

    public List<Usuarios> findAll();

    public List<Usuarios> findRange(int[] range);

    public int count();
    
    public Usuarios findForEmail(String email);
}
