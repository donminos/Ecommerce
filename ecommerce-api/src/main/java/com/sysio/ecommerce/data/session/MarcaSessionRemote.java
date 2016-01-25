/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.session;

import com.sysio.ecommerce.data.entity.Marca;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Remote
public interface MarcaSessionRemote {

    public void create(Marca marca);

    public void edit(Marca marca);

    public void remove(Marca marca);

    public Marca find(Object id);

    public List<Marca> findAll();

    public List<Marca> findRange(int[] range);

    public int count();
}
