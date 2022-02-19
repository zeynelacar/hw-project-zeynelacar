package com.example.project.service.implementations;


import com.example.project.exception.NotFoundException;
import com.example.project.model.Flat;
import com.example.project.repository.FlatRepository;
import com.example.project.service.interfaces.FlatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@RequiredArgsConstructor
@Service
public class FlatServiceImpl implements FlatService {

    private final FlatRepository flatRepository;


    @Override
    public List<Flat> getAllFlats() {

        return flatRepository.findAll();
    }

    @Override
    public Flat getFlat(Integer id) {
        Optional<Flat> byId = flatRepository.findById(id);
        return byId.orElseThrow(()->new NotFoundException("Flat"));
    }

    @Override
    public void addFlat(Flat flat) {

        flatRepository.save(flat);

    }

    @Override
    public Flat updateFlat(Flat flat) {
        return flatRepository.save(flat);
    }

    @Override
    public boolean deleteFlat(Integer id) {
        flatRepository.delete(getFlat(id));
        return true;
    }
}
