package com.shubz.conduit.models;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AuthenticationResponse {

    private Map<String, String> user = new HashMap<>();

    public AuthenticationResponse(Users user) {
        this.user.put("email", user.getEmail());
        this.user.put("username", user.getUsername());
        this.user.put("token", user.getToken());
        this.user.put("bio", user.getBio());
        this.user.put("image", user.getImage());
    }



    public Map<String, String> getUser() {
        return user;
    }


}
