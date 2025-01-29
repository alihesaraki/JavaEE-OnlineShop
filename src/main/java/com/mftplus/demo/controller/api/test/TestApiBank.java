package com.mftplus.demo.controller.api.test;

import com.mftplus.demo.model.entity.Transaction;
import com.mftplus.demo.model.service.TransactionService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
@Path("/test_banks")
public class TestApiBank {

//    @Inject
//    private BankService bankService;

//    @GET
//    public String testGetBanks() {
//        log.info("test get banks");
////        Transaction transaction = Transaction.builder().date(LocalDate.now()).trackingCode(69874l).build();
//        Bank bank = Bank.builder().name("pasargad").accountNumber("659").branchCode(589l).build();
//        bankService.save(bank);
//        return bankService.findAll().toString();
//    }

//    @Inject
//    private PaymentService paymentService;
//
//    @GET
//    public String testGetPayment() {
//        log.info("test get payments");
//        Payment payment = Payment.builder().paymentMethod(PaymentMethod.CASH).description("BILL").date(LocalDate.now()).docNumber(5649L).build();
//        paymentService.save(payment);
//        return paymentService.findAll().toString();
//    }

    @Inject
    private TransactionService transactionService;

        @GET
    public String testGetTransaction() {
        log.info("test get transaction");
        Transaction transaction = Transaction.builder().date(LocalDate.now()).trackingCode(69874l).build();
            transactionService.save(transaction);
        return transactionService.findAll().toString();
    }


}
