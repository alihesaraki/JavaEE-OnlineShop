package com.mftplus.demo.controller.api.test;

import com.mftplus.demo.model.entity.Bank;
import com.mftplus.demo.model.service.BankService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/test_banks")
public class BankApiTest {

    @Inject
    private BankService bankService;

    @GET
    public String testGetBanks() {
        log.info("test get banks");
        return bankService.findAll().toString();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response testGetBankById(@PathParam("id") Long id) {
        log.info("test get bank by id: {}", id);
        Bank bank = bankService.findById(id);
        return Response.ok().entity(bank).build();
    }

    @GET
    @Path("/account/{accountNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response testGetBankByAccountNumber(@PathParam("accountNumber") String accountNumber) {
        log.info("test get bank by account number: {}", accountNumber);
        Bank bank = bankService.findByAccountNumber(accountNumber);
        return Response.ok().entity(bank).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response testAddBank(Bank bank) {
        log.info("test add bank: {}", bank);
        bankService.save(bank);
        return Response.ok().entity(bank).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response testUpdateBank(Bank bank) {
        log.info("test update bank: {}", bank);
        bankService.edit(bank);
        return Response.ok().entity(bank).build();
    }

    @DELETE
    @Path("{id}")
    public Response testDeleteBank(@PathParam("id") Long id) {
        log.info("test delete bank with id: {}", id);
        bankService.remove(id);
        return Response.ok().entity(id).build();
    }
}
