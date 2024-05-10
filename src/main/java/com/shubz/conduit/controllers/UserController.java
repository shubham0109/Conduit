package com.shubz.conduit.controllers;

import com.shubz.conduit.dto.LoginUserDTO;
import com.shubz.conduit.models.AuthenticationResponse;
import com.shubz.conduit.services.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.shubz.conduit.dto.RegisterUserDTO;
import com.shubz.conduit.models.Users;


@RestController
@RequestMapping("/")
public class UserController {
    
    
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value="/user")
    public ResponseEntity<AuthenticationResponse> getUser(@AuthenticationPrincipal UserDetails userDetails) {

        String username = userDetails.getUsername();

        return ResponseEntity.ok(userService.currentUser(username));

    }


    @PostMapping(value="/users/login")
    public ResponseEntity<AuthenticationResponse> loginUser(@RequestBody LoginUserDTO user) {

        System.out.println("IN POST LOGIN");
        String email = user.getEmail();
        String password = user.getPassword();
        return ResponseEntity.ok(userService.authenticate(email, password));
    }

    @PostMapping(value="users")
    public ResponseEntity<AuthenticationResponse> registerUser(@RequestBody RegisterUserDTO user) {

        System.out.println("IN POST REGISTER");
        Users new_user = new Users(user.getUsername(), user.getEmail(), user.getPassword());
        return ResponseEntity.ok(userService.registerUser(new_user));

    }

}
