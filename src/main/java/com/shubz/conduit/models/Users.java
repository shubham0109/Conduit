package com.shubz.conduit.models;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author shubh
 */
@Data
@Entity
public class Users implements UserDetails {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int Id;

    private String username;
    private String email;
    private String password;
    private String image;
    private String bio;

    @Transient
    private String token;

    @Enumerated(value = EnumType.STRING)
    Role role;

    public Users() {
    }

    public Users(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
        this.image = null;
        this.bio = null;
        this.role = Role.USER;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
