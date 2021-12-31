package com.cg.authservice.service;

public interface AuthService {
    /**
     * helps to validate the user using userName and password
     *
     * @param userId userName
     * @param password password
     * @return Boolean
     */
    Boolean authenticateUser(String userId, String password);
}
