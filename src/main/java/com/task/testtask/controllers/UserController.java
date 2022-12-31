package com.task.testtask.controllers;

import com.task.testtask.dtos.UserDTO;
import com.task.testtask.services.UserService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * User controller.
 */

@RestController
public class UserController {

    private final UserService userService;

    /**
     * Constructor.
     *
     * @param userService user service
     */

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users/{userId}")
    @ResponseStatus(code = HttpStatus.OK)
    public UserDTO getUserAgeById(@PathVariable("userId") UUID id){
        return userService.getById(id);
    }

}
