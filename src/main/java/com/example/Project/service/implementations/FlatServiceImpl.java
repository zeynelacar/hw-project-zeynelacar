package com.example.project.service.implementations;


import com.example.project.model.Flat;
import com.example.project.service.interfaces.FlatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FlatServiceImpl implements FlatService {

    private final FlatService flatService;


    @Override
    public List<Flat> getAllFlats() {
        return null;
    }

    @Override
    public Flat getFlat(Integer id) {
        return null;
    }

    @Override
    public void addFlat(Flat flat) {

    }

    @Override
    public Flat updateFlat(Flat flat) {
        return null;
    }

    @Override
    public boolean deleteBlock(Integer id) {
        return false;
    }
}
