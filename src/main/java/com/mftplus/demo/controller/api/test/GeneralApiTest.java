package com.mftplus.demo.controller.api.test;

import com.mftplus.demo.model.entity.Bank;
import com.mftplus.demo.model.entity.Payment;
import com.mftplus.demo.model.entity.Transaction;
import com.mftplus.demo.model.service.BankService;
import com.mftplus.demo.model.service.PaymentService;
import com.mftplus.demo.model.service.TransactionService;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
@Path("/general_test")
public class GeneralApiTest {

    @Inject
    private BankService bankService;

    @Inject
    private PaymentService paymentService;

    @Inject
    private TransactionService transactionService;

    @PostConstruct
    public void initialize() {
        log.info("Initializing default data...");

        // Test Bank API
        Bank bank = Bank.builder()
                .name("General Test Bank")
                .accountNumber("1234567890")
                .branchCode(111L)
                .build();
        bankService.save(bank);
        log.info("Default bank created: {}", bank);

        // Test Payment API
        Payment payment = Payment.builder()
                .docNumber(98765L)
                .date(LocalDate.now())
                .description("General Test Payment")
                .build();
        paymentService.save(payment);
        log.info("Default payment created: {}", payment);

        // Test Transaction API
        Transaction transaction = Transaction.builder()
                .trackingCode(1122334455L)
                .date(LocalDate.now())
                .build();
        transactionService.save(transaction);
        log.info("Default transaction created: {}", transaction);
    }

    @GET
    @Path("/test_all")
    public String testAll() {
        log.info("Testing all APIs");

        return "All APIs tested successfully!";
    }

    @GET
    @Path("/bank/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBankById(@PathParam("id") Long id) {
        Bank bank = bankService.findById(id);
        if (bank == null) {
            log.error("Bank with id {} not found", id);
            return Response.status(Response.Status.NOT_FOUND).entity("Bank not found").build();
        }
        return Response.ok(bank).build();
    }

    @GET
    @Path("/payment/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPaymentById(@PathParam("id") Long id) {
        Payment payment = paymentService.findById(id);
        if (payment == null) {
            log.error("Payment with id {} not found", id);
            return Response.status(Response.Status.NOT_FOUND).entity("Payment not found").build();
        }
        return Response.ok(payment).build();
    }

    @GET
    @Path("/transaction/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTransactionById(@PathParam("id") Long id) {
        Transaction transaction = transactionService.findById(id);
        if (transaction == null) {
            log.error("Transaction with id {} not found", id);
            return Response.status(Response.Status.NOT_FOUND).entity("Transaction not found").build();
        }
        return Response.ok(transaction).build();
    }

    @PUT
    @Path("/update_bank")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateBank(Bank bank) {
        bank.setBranchCode(222L);
        bankService.edit(bank);
        return Response.ok(bank).build();
    }

    @PUT
    @Path("/update_payment")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePayment(Payment payment) {
        payment.setDescription("Updated General Payment");
        paymentService.edit(payment);
        return Response.ok(payment).build();
    }

    @PUT
    @Path("/update_transaction")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateTransaction(Transaction transaction) {
        transaction.setTrackingCode(5566778899L);
        transactionService.edit(transaction);
        return Response.ok(transaction).build();
    }
}
