package com.cg.authservice.controller;

import com.cg.authservice.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/auth")
@Slf4j
public class AuthController {
    @Autowired
    private AuthService authService;

    @GetMapping(value = "/login/userName/{userName}/password/{password}")
    public ResponseEntity<String> validateUser(@PathVariable final String userName, @PathVariable final String password) {
        HttpStatus status = HttpStatus.OK;
        try {
            Boolean isValid = authService.authenticateUser(userName, password);
            if (!isValid) {
                status = HttpStatus.FORBIDDEN;
            }
        } catch (RuntimeException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(status).build();
    }
}
