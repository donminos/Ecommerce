/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysio.shop.services;

import java.util.HashSet;
import java.util.Set;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Carlos Cesar Rosas<face_less@hotmail.com>
 */
@Service("userDetailsService")
@Transactional(readOnly = true)
public class UsuarioServiceSecurity implements UserDetailsService{
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        String us = null, pwd = null;
        Set<GrantedAuthority> granted = new HashSet<GrantedAuthority>();
        granted.add(new SimpleGrantedAuthority("ROLE_USER"));

        UserDetails user = new User("usuario", "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3", true, true, true, true, granted);
        return user;
    }
}
