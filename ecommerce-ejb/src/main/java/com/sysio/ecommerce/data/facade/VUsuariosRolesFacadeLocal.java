/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.facade;

import com.sysio.ecommerce.data.entity.VUsuariosRoles;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Local
public interface VUsuariosRolesFacadeLocal {

    void create(VUsuariosRoles vUsuariosRoles);

    void edit(VUsuariosRoles vUsuariosRoles);

    void remove(VUsuariosRoles vUsuariosRoles);

    VUsuariosRoles find(Object id);

    List<VUsuariosRoles> findAll();

    List<VUsuariosRoles> findRange(int[] range);

    int count();
    
}
