package com.example.project.security;

import com.example.project.model.Flat;
import com.example.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    boolean existsByUsername(String username);

    boolean existsByPassword(String password);

    User findByUsername(String username);

    void deleteByUsername(String username);




}
