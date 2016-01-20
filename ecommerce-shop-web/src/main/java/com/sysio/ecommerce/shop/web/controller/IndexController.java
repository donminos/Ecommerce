package com.sysio.ecommerce.shop.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@RestController
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response) {
        /*response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        response.setHeader("Location", "index.html");*/
        return "redirect:index.html";
    }

}
