package com.newinit.controlador;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ceasar
 */
@RestController
public class GeneralController {

    @Autowired
    private ServletContext servletContext;

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public void index(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        //System.out.println(servletContext.getContextPath());
        response.setHeader("Location", servletContext.getContextPath()+"/index.jsp");
    }
}
