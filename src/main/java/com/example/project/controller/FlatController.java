package com.example.project.controller;

import com.example.project.model.Block;
import com.example.project.model.Flat;
import com.example.project.service.interfaces.FlatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/flat")
public class FlatController {

    private final FlatService flatService;


    @GetMapping (value ="/all")
    public List<Flat> getAllFlats(){
        return  flatService.getAllFlats();
    }
    @PostMapping(value ="/add")
    public void addFlat(@RequestBody Flat newFlat){
        flatService.addFlat(newFlat);
    }

    @PutMapping(value="/update")
    public Flat updateFlat(@RequestBody Flat flat){
        return flatService.updateFlat(flat);
    }

    @DeleteMapping(value = "/delete")
    public boolean deleteFlat(@RequestParam @Min(1) Integer id) {
        return flatService.deleteFlat(id);
    }

}
