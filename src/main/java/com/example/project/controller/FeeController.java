package com.example.project.controller;

import com.example.project.model.Fee;
import com.example.project.model.Payment;
import com.example.project.service.interfaces.FeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/fee")
public class FeeController
{

    private final FeeService feeService;

    @GetMapping(value = "/all")
    public List<Fee> getAllFees(){return feeService.getAllFees();}

    @GetMapping(value ="/find")
    public Fee getFee(@RequestParam @Min((1)) Integer id){return feeService.getFee(id);}

    @PostMapping(value ="/add")
    public void addFee(@RequestBody Fee newFee){
        feeService.addFee(newFee);
    }

    @PutMapping(value="/update")
    public Fee updateFee(@RequestBody Fee fee){
        return feeService.updateFee(fee);
    }

    @DeleteMapping(value = "/delete")
    public boolean deleteFee(@RequestParam @Min(1) Integer id) {
        return feeService.deleteFee(id);
    }



}
