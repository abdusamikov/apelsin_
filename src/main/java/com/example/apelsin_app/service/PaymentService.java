package com.example.apelsin_app.service;

import com.example.apelsin_app.dto.PaymentDto;
import com.example.apelsin_app.entity.Invoice;
import com.example.apelsin_app.entity.Payment;
import com.example.apelsin_app.repository.DetailRepository;
import com.example.apelsin_app.repository.InvoiceRepository;
import com.example.apelsin_app.repository.Paymentrepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {
    final Paymentrepository paymentrepository;
    final InvoiceRepository invoiceRepository;
    final DetailRepository detailRepository;

    public void add(PaymentDto dto){
        Optional<Invoice> optionalInvoice = invoiceRepository.findById(dto.getInvoice_id());
        Payment payment=new Payment();
        LocalDate now = LocalDate.now();
        payment.setTimestamp(now);
        payment.setInvoice(optionalInvoice.get());
        payment.setAmount(optionalInvoice.get().getAmount());
        Payment save = paymentrepository.save(payment);
    }
}
