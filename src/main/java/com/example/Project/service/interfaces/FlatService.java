package com.example.project.service.interfaces;

import com.example.project.model.Block;
import com.example.project.model.Flat;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface FlatService {

    List<Flat> getAllFlats();

    Flat getFlat(Integer id);

    void addFlat(@RequestBody Flat flat);

    Flat updateFlat(@RequestBody Flat flat);

    boolean deleteFlat(Integer id);

}
