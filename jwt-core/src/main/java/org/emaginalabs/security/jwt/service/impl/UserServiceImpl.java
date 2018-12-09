package org.emaginalabs.security.jwt.service.impl;


import org.emaginalabs.security.jwt.repository.model.User;
import org.emaginalabs.security.jwt.repository.UserRepository;
import org.emaginalabs.security.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User findByUsername( String username ) throws UsernameNotFoundException {
        return userRepository.findByUsername( username );

    }

    public User findById( Long id ) throws AccessDeniedException {
        Optional<User> u = userRepository.findById( id );
        return u.isPresent() ? u.get() : null;
    }

    public List<User> findAll() throws AccessDeniedException {
        return userRepository.findAll();
    }
}
