package com.example.project.service.implementations;

import com.example.project.exception.NotFoundException;
import com.example.project.model.Block;
import com.example.project.repository.BlockRepository;
import com.example.project.service.interfaces.BlockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BlockServiceImpl implements BlockService {

    private final BlockRepository blockRepository;

    @Override
    public List<Block> getAllBlocks() {
        return blockRepository.findAll();
    }

    @Override
    public Block getBlock(Integer id) {
        Optional<Block> byId = blockRepository.findById(id);
        return byId.orElseThrow(() -> new NotFoundException("Block"));
    }

    @Override
    public void addBlock(Block block) {

         blockRepository.save(block);

    }

    @Override
    public Block updateBlock(Block block) {
        return blockRepository.save(block);
    }

    @Override
    public boolean deleteBlock(Integer id) {
        blockRepository.delete(getBlock(id));
        return true;
    }

    @Override
    public List<Block> getBlocksNameStartsWith(String prefix) {
        List<Block> allPassengers = getAllBlocks();
        return allPassengers.stream()
                .filter(p -> p.getName().startsWith(prefix))
                .collect(Collectors.toList());
    }
}
