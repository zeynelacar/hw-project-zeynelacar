package com.example.project.controller;


import com.example.project.model.Block;
import com.example.project.service.interfaces.BlockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/block")
public class BlockController {

    private final BlockService blockService;

    @GetMapping(value = "/hello")
    public String hello(){
        return "Hello to the blocks";
    }
    @GetMapping (value ="/all")
    public List<Block> getAllBlocks(){
        return  blockService.getAllBlocks();
    }
    @PostMapping(value ="/add")
    public void addBlock(@RequestBody Block newBlock){
        blockService.addBlock(newBlock);
    }

    @PutMapping(value="/update")
    public Block updateBlock(@RequestBody Block block){
        return blockService.updateBlock(block);
    }

    @DeleteMapping(value = "/delete")
    public boolean deleteBlock(@RequestParam @Min(1) Integer id) {
        return blockService.deleteBlock(id);
    }

}