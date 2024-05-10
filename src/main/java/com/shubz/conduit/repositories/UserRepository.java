package com.shubz.conduit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shubz.conduit.models.Users;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<Users, Integer> {


    Optional<Users> findByUsername(String username);

    @Query("SELECT u FROM Users u WHERE u.email = :email")
    Users findByEmail(String email);

    //@Query("SELECT * FROM user WHERE user.email == :email")
    //List<User> findUserOfSpecificUser(@Param("email") String email);

}
