package com.sysio.shop.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import lombok.extern.java.Log;
import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Carlos Cesar Rosas
 */
@Log
@RestController
@RequestMapping("/public/images")
public class ImagesController {

    private Properties prop;

    public ImagesController() {
        try {
            String propFileName = "file.properties";
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            prop = new Properties();
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
        } catch (IOException ex) {
        }
    }

    @RequestMapping(value = "/getimage", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] images(@RequestParam("image") String image) throws IOException {
        File file = new File(prop.getProperty("file.directorio.producto.imagenes") + image);
        InputStream in = FileUtils.openInputStream(file);
        try {
            return IOUtils.toByteArray(in);
        } finally {
            IOUtils.closeQuietly(in);
        }

    }

}
