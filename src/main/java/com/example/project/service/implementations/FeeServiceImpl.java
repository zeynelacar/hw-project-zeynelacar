package com.example.project.service.implementations;

import com.example.project.model.Fee;
import com.example.project.repository.FeeRepository;
import com.example.project.service.interfaces.FeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FeeServiceImpl implements FeeService {

    private final FeeRepository feeRepository;

    @Override
    public List<Fee> getAllFees() {
        return feeRepository.findAll();
    }

    @Override
    public Fee getFee(Integer id) {
        Optional<Fee> byId = feeRepository.findById(id);
        return byId.orElseThrow(()->new RuntimeException("No fee found"));
    }

    @Override
    public void addFee(Fee fee) {

        feeRepository.save(fee);

    }

    @Override
    public Fee updateFee(Fee fee) {
        return feeRepository.save(fee);
    }

    @Override
    public boolean deleteFee(Integer id) {
        feeRepository.delete(getFee(id));
        return true;
    }

    /*@Override
    public Fee getTotalFee(Integer water_bill, Integer gas_bill, Integer electricity_bill, Integer dues) {

    }*/
}
