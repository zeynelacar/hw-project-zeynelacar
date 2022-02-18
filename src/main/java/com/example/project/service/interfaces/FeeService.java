package com.example.project.service.interfaces;

import com.example.project.model.Block;
import com.example.project.model.Fee;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface FeeService {

    List<Fee> getAllFees();

    Fee getFee(Integer id);

    List<Fee> getFeeByFlatId(Integer flatId);

    void addFee(@RequestBody Fee fee);

    Fee updateFee(@RequestBody Fee fee );

    boolean deleteFee(Integer id);

}
