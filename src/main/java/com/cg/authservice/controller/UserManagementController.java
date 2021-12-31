package com.cg.authservice.controller;

import com.cg.authservice.dto.UserDTO;
import com.cg.authservice.model.User;
import com.cg.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerResponse;

@RestController
@RequestMapping(value = "/v1/user")
public class UserManagementController {
    @Autowired
    private UserService userService;

    /**
     * Controller method to capture the create user request
     *
     * @return HttpStatus
     */
    @PostMapping(value = "/create")
    public ResponseEntity<String> createUser(@RequestBody final UserDTO userDTO) {
        HttpStatus status = HttpStatus.OK;
        try {
            final User user = new User();
            user.setUserName(userDTO.getUserName());
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setPassword(userDTO.getPassword());
            user.setLocation(userDTO.getLocation());
            final Boolean isCreated = userService.createUser(user);
            if (!isCreated) {
                status = HttpStatus.BAD_REQUEST;
            }
        } catch (RuntimeException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(status).build();
    }
}
