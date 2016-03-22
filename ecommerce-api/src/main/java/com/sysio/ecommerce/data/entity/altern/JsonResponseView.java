package com.sysio.ecommerce.data.entity.altern;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
public class JsonResponseView implements Serializable{
    public JsonResponseView(){
        response=new HashMap();
        response.put("success", true);
    }
    private Map<Object, Object> response;

    public Map<Object, Object> getResponse() {
        return response;
    }

    public void setResponse(Map<Object, Object> response) {
        this.response = response;
    }
    
}
