package com.leancoder.ecommerce.model.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leancoder.ecommerce.model.dao.IUsuarioDao;
import com.leancoder.ecommerce.model.entity.Users;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService{
    
    @Autowired
    IUsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users usuario = usuarioDao.findByUsername(username);

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(usuario.getRole().getAuthority()));
        
        if (username == null || username == "" || authorities.isEmpty()) {
            throw new UsernameNotFoundException("Error al loguear: Credenciales invalidas, usuario sin rol asignado o cuenta no verificada.");
        }

        return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, authorities);

    }

}
