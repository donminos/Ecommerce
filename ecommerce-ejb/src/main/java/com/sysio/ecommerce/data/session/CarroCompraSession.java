package com.sysio.ecommerce.data.session;

import com.sysio.ecommerce.data.entity.Productos;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Stateful
public class CarroCompraSession implements CarroCompraSessionRemote {

    public CarroCompraSession() {
        carro = new ArrayList();
    }
    @Getter
    @Setter
    List<Productos> carro;

    @Override
    public List<Productos> agregarLstProductos(Productos producto) {
        //carro.add(producto);
        return this.carro;
    }
}
