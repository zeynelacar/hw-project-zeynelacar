package com.example.project.controller;


import com.example.project.model.Block;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/block")
public class BlockController {



    @RequestMapping(method = RequestMethod.GET,path = "/hello")
    public String hello(){
        return "Hello to the blocks";
    }
    @RequestMapping(method = RequestMethod.GET,path ="/blocks/all")
    public List<Block> getAllBlocks(){
        return  blocks;
    }
    @RequestMapping(method =RequestMethod.POST ,path ="/blocks/add")
    public Block addBlock(@RequestBody Block newBlock)
    {
        blocks.add(newBlock);
        return newBlock;
    }
}