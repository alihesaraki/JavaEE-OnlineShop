package com.mftplus.demo.controller.api.test;

import com.mftplus.demo.model.entity.Transaction;
import com.mftplus.demo.model.service.TransactionService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/test_transactions")
public class TransactionApiTest {

    @Inject
    private TransactionService transactionService;

    @GET
    public String testGetTransactions() {
        log.info("test get transactions");
        // فرض می‌کنیم تراکنش‌ها در حال حاضر در پایگاه داده موجودند
        return transactionService.findAll().toString();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response testGetTransactionById(@PathParam("id") Long id) {
        log.info("test get transaction by id: {}", id);
        Transaction transaction = transactionService.findById(id);
        return Response.ok().entity(transaction).build();
    }

    @GET
    @Path("/tracking/{trackingCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response testGetTransactionByTrackingCode(@PathParam("trackingCode") Long trackingCode) {
        log.info("test get transaction by tracking code: {}", trackingCode);
        Transaction transaction = transactionService.findByTrackingCode(trackingCode);
        return Response.ok().entity(transaction).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response testAddTransaction(Transaction transaction) {
        log.info("test add transaction: {}", transaction);
        transactionService.save(transaction);
        return Response.ok().entity(transaction).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response testUpdateTransaction(Transaction transaction) {
        log.info("test update transaction: {}", transaction);
        transactionService.edit(transaction);
        return Response.ok().entity(transaction).build();
    }

    @DELETE
    @Path("{id}")
    public Response testDeleteTransaction(@PathParam("id") Long id) {
        log.info("test delete transaction with id: {}", id);
        transactionService.remove(id);
        return Response.ok().entity(id).build();
    }
}
