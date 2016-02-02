package com.sysio.ecommerce.admin.web.beans;

import com.sysio.ecommerce.data.entity.Productos;
import com.sysio.ecommerce.data.session.ProductosSessionRemote;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Named(value = "panelControl")
@RequestScoped
public class PanelControl implements Serializable {
    @EJB
    private ProductosSessionRemote productosSession;

    @Getter
    @Setter
    private LineChartModel lineModel;

    public PanelControl() {
        lineModel = initLinearModel();
        lineModel.setTitle("Ventas Totales");
        lineModel.setLegendPosition("e");
        Axis yAxis = lineModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
    }
    
    public List<Productos> getLstProductos(){
        return productosSession.findAll();
    }
    
    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
 
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Producto 1");
 
        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);
 
        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Producto 2");
 
        series2.set(1, 6);
        series2.set(2, 3);
        series2.set(3, 2);
        series2.set(4, 7);
        series2.set(5, 9);
 
        model.addSeries(series1);
        model.addSeries(series2);
         
        return model;
    }

}
