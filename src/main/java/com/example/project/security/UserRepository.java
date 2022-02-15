package com.example.project.security;

import com.example.project.model.Flat;
import com.example.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    boolean existsByUsername(String username);

    boolean existsByFlat(Flat flat);

    User findByUsername(String username);

    User findByFlat(Flat flat);

    void deleteByUsername(String username);

    User deleteByFlat(Flat flat);




}
