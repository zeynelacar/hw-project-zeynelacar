package com.example.project.service.interfaces;

import com.example.project.model.Fee;
import com.example.project.model.Payment;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PaymentService {

    List<Payment> getAllPayments();

    Payment getPayment(Integer id);

    Payment makePayment(Integer paymentAmount , Integer FeeId);

    void addPayment(@RequestBody Payment payment);

    Payment updatePayment(@RequestBody Payment payment );

    boolean deletePayment(Integer id);


}
