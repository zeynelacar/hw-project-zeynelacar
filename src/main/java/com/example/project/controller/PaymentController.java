package com.example.project.controller;


import com.example.project.model.Flat;
import com.example.project.model.Payment;
import com.example.project.service.interfaces.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping (value ="/all")
    public List<Payment> getAllPayments(){
        return  paymentService.getAllPayments();
    }

    /*@PostMapping(value ="/pay")
    public Payment makePayment(@RequestBody Integer paymentAmount,Integer feeId){
        return paymentService.makePayment(paymentAmount,feeId);
    }*/

    @PostMapping(value ="/pay")
    public Payment makePayment(@RequestParam @Min(1) Integer paymentAmount,@RequestParam @Min(1) Integer feeId){
         return paymentService.makePayment(paymentAmount,feeId);
    }

    @PutMapping(value="/update")
    public Payment updatePayment(@RequestBody Payment payment){
        return paymentService.updatePayment(payment);
    }

    @DeleteMapping(value = "/delete")
    public boolean deletePayment(@RequestParam @Min(1) Integer id) {
        return paymentService.deletePayment(id);
    }


}
