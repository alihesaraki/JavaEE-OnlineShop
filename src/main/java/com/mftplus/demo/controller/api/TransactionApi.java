package com.mftplus.demo.controller.api;

import com.mftplus.demo.controller.interceptor.annotation.ResponseMaker;
import com.mftplus.demo.model.entity.Transaction;
import com.mftplus.demo.model.service.TransactionService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Path("/transactions")
@Slf4j
public class TransactionApi {

    @Inject
    private TransactionService transactionService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_TRANSACTIONS")
    public Response getTransactions() {
        log.info("get transactions");
        return Response.ok().entity(transactionService.findAll()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority="GET_TRANSACTION_BY_ID")
    @Path("{id}")
    public Response getTransactionById(@PathParam("id") Long id) {
        return Response.ok().entity(transactionService.findById(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/tracking/{trackingCode}")
    public Response getTransactionByTrackingCode(@PathParam("trackingCode") Long trackingCode) {
        return Response.ok().entity(transactionService.findByTrackingCode(trackingCode)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTransaction(@Valid Transaction transaction) {
        transactionService.save(transaction);
        return Response.ok().entity(transaction).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateTransaction(@Valid Transaction transaction) {
        transactionService.edit(transaction);
        return Response.ok().entity(transaction).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteTransaction(@PathParam("id") Long id) {
        transactionService.remove(id);
        return Response.ok().entity(id).build();
    }
}
