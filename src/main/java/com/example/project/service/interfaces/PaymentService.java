package com.example.project.service.interfaces;

import com.example.project.model.Fee;
import com.example.project.model.Payment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PaymentService {

    List<Payment> getAllPayments();

    Payment getPayment(Integer id);

    Payment makePayment(@RequestBody Payment payment,@PathVariable Integer FeeId);

    void addPayment(@RequestBody Payment payment);

    Payment updatePayment(@RequestBody Payment payment );

    boolean deletePayment(Integer id);


}
