package com.cg.authservice.service;

import com.cg.authservice.model.User;

public interface UserService {
    /**
     * Helps to create a user
     *
     * @param user User
     * @return Boolean
     */
    Boolean createUser(User user);
}
