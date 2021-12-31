package com.cg.authservice.service.impl;

import com.cg.authservice.model.User;
import com.cg.authservice.repository.UserRepository;
import com.cg.authservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;

    /**
     * helps to validate the user using userName and password
     *
     * @param userName userName
     * @param password password
     * @return Boolean
     */
    @Override
    public Boolean authenticateUser(String userName, String password) {
        Optional<User> user = userRepository.findByUserName(userName);
        return user.isPresent() && password.equals(user.get().getPassword());
    }
}
