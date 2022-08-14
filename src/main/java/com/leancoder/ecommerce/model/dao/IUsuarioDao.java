package com.leancoder.ecommerce.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leancoder.ecommerce.model.entity.Users;

@Repository
public interface IUsuarioDao extends CrudRepository<Users, Long>{
    
     // Metodo HIBERNATE para buscar por el username:
     public Users findByUsername(String username);

     // Metodo HIBERNATE para buscar por el email del usuario:
     public Users findByEmail(String email);

}
