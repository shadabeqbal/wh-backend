package com.example.wh_backend.controllers;


import com.example.wh_backend.models.request.UserRegisterInput;
import com.example.wh_backend.models.response.GlobalResponse;
import com.example.wh_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)

public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST,value = "/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterInput userRegisterInput) {
        GlobalResponse globalResponse = userService.registerUser(userRegisterInput);
        return ResponseEntity.status(globalResponse.getStatusCode()).body(globalResponse);
    }
}
