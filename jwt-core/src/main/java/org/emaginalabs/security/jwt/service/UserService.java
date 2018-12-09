package org.emaginalabs.security.jwt.service;



import org.emaginalabs.security.jwt.repository.model.User;

import java.util.List;


public interface UserService {
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll();
}
