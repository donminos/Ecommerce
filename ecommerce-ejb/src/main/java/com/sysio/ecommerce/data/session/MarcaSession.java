
package com.sysio.ecommerce.data.session;

import com.sysio.ecommerce.data.entity.Marca;
import com.sysio.ecommerce.data.facade.MarcaFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Stateless
public class MarcaSession implements MarcaSessionRemote {
    @EJB
    private MarcaFacadeLocal marcaFacade;

    @Override
    public void create(Marca marca) {
        marcaFacade.create(marca);
    }

    @Override
    public void edit(Marca marca) {
        marcaFacade.edit(marca);
    }

    @Override
    public void remove(Marca marca) {
        marcaFacade.remove(marca);
    }

    @Override
    public Marca find(Object id) {
        return marcaFacade.find(id);
    }

    @Override
    public List<Marca> findAll() {
        return marcaFacade.findAll();
    }

    @Override
    public List<Marca> findRange(int[] range) {
        return marcaFacade.findRange(range);
    }

    @Override
    public int count() {
        return marcaFacade.count();
    }
}
