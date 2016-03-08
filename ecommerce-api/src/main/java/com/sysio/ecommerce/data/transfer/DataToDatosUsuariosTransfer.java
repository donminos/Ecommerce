/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.transfer;

import com.sysio.ecommerce.data.entity.DatosUsuario;
import com.sysio.ecommerce.data.entity.altern.UsuariosDatosJsonView;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
public class DataToDatosUsuariosTransfer {
    public DatosUsuario transferData(UsuariosDatosJsonView json){
        DatosUsuario data=new DatosUsuario();
        data.setNombre(json.getNombre());
        data.setApellidoMaterno(json.getApp());
        data.setApellidoPaterno(json.getApm());
        data.setCalle(json.getCalle());
        data.setCiudad(json.getCiudad());
        data.setColonia(json.getColonia());
        data.setCp(json.getCp());
        data.setEstado(json.getEstado());
        data.setDelegacion(json.getMunicipio());
        data.setNumeroExt(json.getNumext());
        data.setNumeroInt(json.getNumint());
        data.setRfc(json.getRfc());
        data.setTelefonoCelular(json.getTelcel());
        data.setTelefonoOtro(json.getTelfig());
        return data;
    }
}
