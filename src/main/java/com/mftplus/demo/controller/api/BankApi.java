package com.mftplus.demo.controller.api;

import com.mftplus.demo.controller.interceptor.annotation.ResponseMaker;
import com.mftplus.demo.model.entity.Bank;
import com.mftplus.demo.model.service.BankService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Path("/banks")
@Slf4j
public class BankApi {

    @Inject
    private BankService bankService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_BANKS")
    public Response getBanks() {
        log.info("get banks");
        return Response.ok().entity(bankService.findAll()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority="GET_BANK_BY_ID")
    @Path("{id}")
    public Response getBankById(@PathParam("id") Long id) {
        return Response.ok().entity(bankService.findById(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/account/{accountNumber}")
    public Response getBankByAccountNumber(@PathParam("accountNumber") String accountNumber) {
        return Response.ok().entity(bankService.findByAccountNumber(accountNumber)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addBank(@Valid Bank bank) {
        bankService.save(bank);
        return Response.ok().entity(bank).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateBank(@Valid Bank bank) {
        bankService.edit(bank);
        return Response.ok().entity(bank).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteBank(@PathParam("id") Long id) {
        bankService.remove(id);
        return Response.ok().entity(id).build();
    }
}
