package com.newinit.controlador;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Carlos Cesar Rosas
 */
@RestController
@RequestMapping("/public/images")
public class ImagesController {

    @Value("${direccion}")
    private String direccion;

    @RequestMapping(value = "/getimage", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] images(@RequestParam("image") String image) throws IOException {
        try {
            File file = new File(direccion + image);
            InputStream in = FileUtils.openInputStream(file);
            try {
                return IOUtils.toByteArray(in);
            } finally {
                IOUtils.closeQuietly(in);
            }
        } catch (Exception ex) {
            File file = new File(direccion + "404.jpg");
            InputStream in = FileUtils.openInputStream(file);
            return IOUtils.toByteArray(in);
        }
    }

}
