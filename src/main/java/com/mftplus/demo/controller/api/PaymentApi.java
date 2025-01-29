package com.mftplus.demo.controller.api;

import com.mftplus.demo.controller.interceptor.annotation.ResponseMaker;
import com.mftplus.demo.model.entity.Payment;
import com.mftplus.demo.model.service.PaymentService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Path("/payments")
@Slf4j
public class PaymentApi {

    @Inject
    private PaymentService paymentService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_PAYMENTS")
    public Response getPayments() {
        log.info("get payments");
        return Response.ok().entity(paymentService.findAll()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority="GET_PAYMENT_BY_ID")
    @Path("{id}")
    public Response getPaymentById(@PathParam("id") Long id) {
        Payment payment = paymentService.findById(id); // اصلاح شده
        return Response.ok().entity(payment).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/doc/{docNumber}")
    public Response getPaymentByDocNumber(@PathParam("docNumber") Long docNumber) {
        Payment payment = paymentService.findByDocNumber(docNumber);
        return Response.ok().entity(payment).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/method/{paymentMethod}")
    public Response getPaymentByMethod(@PathParam("paymentMethod") String paymentMethod) {
        List<Payment> payments = paymentService.findByPaymentMethod(paymentMethod);
        return Response.ok().entity(payments).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPayment(@Valid Payment payment) {
        paymentService.save(payment);
        return Response.ok().entity(payment).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePayment(@Valid Payment payment) {
        paymentService.edit(payment);
        return Response.ok().entity(payment).build();
    }

    @DELETE
    @Path("{id}")
    public Response deletePayment(@PathParam("id") Long id) {
        paymentService.remove(id);
        return Response.ok().entity(id).build();
    }
}
