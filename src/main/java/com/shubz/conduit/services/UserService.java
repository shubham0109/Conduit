package com.shubz.conduit.services;

import com.shubz.conduit.models.AuthenticationResponse;
import com.shubz.conduit.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shubz.conduit.models.Users;

import java.util.Optional;

@Service
public class UserService {
    

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }


    public AuthenticationResponse registerUser(Users user){

        Users new_user = new Users(user.getUsername(), user.getEmail(), passwordEncoder.encode(user.getPassword()));

        new_user = userRepository.save(new_user);

        String jwt = jwtService.generateToken(new_user);
        new_user.setToken(jwt);

        return new AuthenticationResponse(new_user);

    }

    public AuthenticationResponse authenticate(String email, String password) {

        System.out.println("email" + email);
        Users user = userRepository.findByEmail(email);
        String username  = user.getUsername();

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        password
                )
        );

        //Users user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String jwt = jwtService.generateToken(user);
        user.setToken(jwt);

        return new AuthenticationResponse(user);

    }


    public AuthenticationResponse currentUser(String username) {

        Users user = userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));


        return new AuthenticationResponse(user);

    }
}
