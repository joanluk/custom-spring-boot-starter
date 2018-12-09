package org.emaginalabs.security.jwt.repository;


import org.emaginalabs.security.jwt.repository.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

