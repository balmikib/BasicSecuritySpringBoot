package com.cg.authservice.service.impl;

import com.cg.authservice.model.User;
import com.cg.authservice.repository.UserRepository;
import com.cg.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Helps to create a user
     *
     * @param user User
     * @return Boolean
     */
    @Override
    public Boolean createUser(final User user) {
        return null != (userRepository.save(user));
    }
}
