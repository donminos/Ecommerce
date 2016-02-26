package com.sysio.ecommerce.data.entity.altern;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
public class JsonResponseView implements Serializable{
    private Map<Object, Object> response;

    public Map<Object, Object> getResponse() {
        return response;
    }

    public void setResponse(Map<Object, Object> response) {
        this.response = response;
    }
    
}
