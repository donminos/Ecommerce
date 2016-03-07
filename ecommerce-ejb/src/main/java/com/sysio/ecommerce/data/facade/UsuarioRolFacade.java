/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.ecommerce.data.facade;

import com.sysio.ecommerce.data.entity.UsuarioRol;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Stateless
public class UsuarioRolFacade extends AbstractFacade<UsuarioRol> implements UsuarioRolFacadeLocal {

    @PersistenceContext(unitName = "ecommerce-ejb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioRolFacade() {
        super(UsuarioRol.class);
    }

    @Override
    public BigInteger createUserCliente(UsuarioRol user) {
        Query query = em.createNativeQuery("INSERT INTO Usuarios (Usuario, Contrasena) VALUES (?, ?)");
        query.setParameter(1, user.getUsuarios().getUsuario());
        query.setParameter(2, user.getUsuarios().getContrasena());
        query.executeUpdate();        
        query = em.createNativeQuery("SELECT @@identity AS id");
        BigInteger id = (BigInteger) query.getSingleResult();
        query = em.createNativeQuery("INSERT INTO DatosUsuario (idUsuario, Nombre, ApellidoPaterno, ApellidoMaterno, CP, Estado, Ciudad, Delegacion, Colonia, TelefonoCelular, TelefonoOtro, NumeroInt, NumeroExt, RFC, Calle) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        query.setParameter(1, id);
        query.setParameter(2, user.getUsuarios().getDatosUsuario().getNombre());
        query.setParameter(3, user.getUsuarios().getDatosUsuario().getApellidoPaterno());
        query.setParameter(4, user.getUsuarios().getDatosUsuario().getApellidoMaterno());
        query.setParameter(5, user.getUsuarios().getDatosUsuario().getCp());
        query.setParameter(6, user.getUsuarios().getDatosUsuario().getEstado());
        query.setParameter(7, user.getUsuarios().getDatosUsuario().getCiudad());
        query.setParameter(8, user.getUsuarios().getDatosUsuario().getDelegacion());
        query.setParameter(9, user.getUsuarios().getDatosUsuario().getColonia());
        query.setParameter(10, user.getUsuarios().getDatosUsuario().getTelefonoCelular());
        query.setParameter(11, user.getUsuarios().getDatosUsuario().getTelefonoOtro());
        query.setParameter(12, user.getUsuarios().getDatosUsuario().getNumeroInt());
        query.setParameter(13, user.getUsuarios().getDatosUsuario().getNumeroExt());
        query.setParameter(14, user.getUsuarios().getDatosUsuario().getRfc());
        query.setParameter(15, user.getUsuarios().getDatosUsuario().getCalle());
        query.executeUpdate();
        query = em.createNativeQuery("INSERT INTO UsuarioRol (idUsuario, idRol) VALUES (?, '2');");
        query.setParameter(1, id);
        query.executeUpdate();
        return id;
    }

}
