package com.example.project.service.interfaces;


import com.example.project.model.Block;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BlockService {

    List<Block> getAllBlocks();

    Block getBlock(Integer id);

    void addBlock(@RequestBody Block block);

    Block updateBlock(@RequestBody Block block);

    boolean deleteBlock(Integer id);

    List<Block> getBlocksNameStartsWith(String prefix);


}
