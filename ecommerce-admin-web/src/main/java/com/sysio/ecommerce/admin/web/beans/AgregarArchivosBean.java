/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.admin.web.beans;

import com.google.common.io.Files;
import com.sysio.ecommerce.admin.web.beans.exceptions.ExceptionsBeans;
import com.sysio.ecommerce.admin.web.beans.exceptions.ExceptionsBeans.Errors;
import com.sysio.ecommerce.data.entity.Imagenes;
import com.sysio.ecommerce.data.session.ImagenesSessionRemote;
import com.sysio.ecommerce.data.session.ProductosSessionRemote;
import com.sysio.ecommerce.libs.RandomName;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Properties;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Log
@Named(value = "agregarArchivosBean")
@ViewScoped
public class AgregarArchivosBean implements Serializable {

    @EJB
    private ProductosSessionRemote productosSession;
    @EJB
    private ImagenesSessionRemote imagenesSession;

    public AgregarArchivosBean() {

        String propFileName = "file.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        try {
            prop = new Properties();
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
        } catch (Exception ex) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    private Properties prop;

    private UploadedFile file;

    @Setter
    @Getter
    private Integer idProducto;

    @Setter
    @Getter
    private StreamedContent image;

    public void handleFileUpload(FileUploadEvent event) {
        try {
            String name = "";

            file = event.getFile();
            //file.write(file.getFileName());
            InputStream input = file.getInputstream();
            name = RandomName.randomIdentifier(file.getContentType());
            byte[] buffer = new byte[input.available()];
            input.read(buffer);
            File targetFile = new File(prop.getProperty("file.directorio.producto.imagenes") + name);
            Files.write(buffer, targetFile);

            if (file.getFileName().length() > 45) {
                throw new ExceptionsBeans(Errors.Longitud45);
            }

            Imagenes image = new Imagenes();
            image.setIdProducto(productosSession.find(idProducto));
            image.setPath(name);
            image.setNombre(file.getFileName());
            imagenesSession.create(image);

            FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception ex) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public List<Imagenes> getListImages() {
        List<Imagenes> imagenes = imagenesSession.findAllId(idProducto);
        return imagenes;
    }

    public void eliminarImagen(Imagenes image) {
        try {
            File targetFile = new File(prop.getProperty("file.directorio.producto.imagenes") + image.getPath());
            if(targetFile.exists()){
                targetFile.delete();
            }
            imagenesSession.remove(image);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Se ha eliminado la imagen del sistema");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception ex) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

}
