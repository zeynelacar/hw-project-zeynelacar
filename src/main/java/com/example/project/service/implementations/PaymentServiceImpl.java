package com.example.project.service.implementations;

import com.example.project.model.Fee;
import com.example.project.model.Flat;
import com.example.project.model.Payment;
import com.example.project.repository.FlatRepository;
import com.example.project.repository.PaymentRepository;
import com.example.project.service.interfaces.FeeService;
import com.example.project.service.interfaces.FlatService;
import com.example.project.service.interfaces.PaymentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {


    private final PaymentRepository paymentRepository;

    /*private final FlatService flatService;*/

    @Autowired
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
    public Payment makePayment(Payment payment,@NotNull Integer feeId) {
            Fee fee = feeService.getFee(feeId);

            if (payment.getPayment_amount().equals(fee.getTotalFee())) {
                feeService.deleteFee(feeId);
                return paymentRepository.save(payment);
            }

            throw new RuntimeException("System only receives exact amount of payment.");
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
