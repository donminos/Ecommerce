package com.sysio.ecommerce.admin.web.beans.exceptions;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
public class ExceptionsBeans extends Exception {

    public enum Errors {

        Longitud45("Longitud maxima 45 caracteres");

        private final String sms;
        Errors(String sms) {         
        this.sms  = sms;
    }
}
public ExceptionsBeans(Errors message){
        super(message.sms);
    }
}
