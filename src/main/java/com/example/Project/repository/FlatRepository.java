package com.example.project.repository;

import com.example.project.model.Block;
import com.example.project.model.Flat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlatRepository extends JpaRepository<Flat,Integer> {
}
