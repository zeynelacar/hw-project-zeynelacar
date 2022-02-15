package com.example.project.service.implementations;

import com.example.project.model.Fee;
import com.example.project.model.Flat;
import com.example.project.model.Payment;
import com.example.project.repository.FlatRepository;
import com.example.project.repository.PaymentRepository;
import com.example.project.service.interfaces.FeeService;
import com.example.project.service.interfaces.FlatService;
import com.example.project.service.interfaces.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {


    private final PaymentRepository paymentRepository;

    /*private final FlatService flatService;*/

    private final FeeService feeService;

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPayment(Integer id) {
        Optional<Payment> byId = paymentRepository.findById(id);
        return byId.orElseThrow(()->new RuntimeException("No payment found."));
    }

    @Override
    public Payment makePayment(Integer paymentAmount, Integer feeId) {
            Fee fee = feeService.getFee(feeId);

            if (paymentAmount.equals(fee.getTotalFee())) {
                Payment newPayment = new Payment();
                feeService.deleteFee(feeId);
                addPayment(newPayment);
                return newPayment;

            }else{
                System.out.println("System only receives exact amount of payment.");
            }
            throw new RuntimeException("No fee found.");
    }

    @Override
    public void addPayment(Payment payment) {

        paymentRepository.save(payment);

    }

    @Override
    public Payment updatePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public boolean deletePayment(Integer id) {
        paymentRepository.delete(getPayment(id));
        return true;
    }
}
