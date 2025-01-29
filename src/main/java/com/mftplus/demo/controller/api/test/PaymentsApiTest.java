package com.mftplus.demo.controller.api.test;

import com.mftplus.demo.model.entity.Payment;
import com.mftplus.demo.model.service.PaymentService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Path("/test_payments")
public class PaymentsApiTest {

    @Inject
    private PaymentService paymentService;

    @GET
    public String testGetPayments() {
        log.info("test get payments");
        // فرض می‌کنیم پرداخت‌ها در حال حاضر در پایگاه داده موجودند
        return paymentService.findAll().toString(); // این متد یک لیست برمی‌گرداند
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response testGetPaymentById(@PathParam("id") Long id) {
        log.info("test get payment by id: {}", id);
        Payment payment = paymentService.findById(id);
        return Response.ok().entity(payment).build(); // این متد یک Payment واحد برمی‌گرداند
    }

    @GET
    @Path("/doc/{docNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response testGetPaymentByDocNumber(@PathParam("docNumber") Long docNumber) {
        log.info("test get payment by doc number: {}", docNumber);
        Payment payment = paymentService.findByDocNumber(docNumber);
        return Response.ok().entity(payment).build(); // این متد یک Payment واحد برمی‌گرداند
    }

    @GET
    @Path("/method/{paymentMethod}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response testGetPaymentByMethod(@PathParam("paymentMethod") String paymentMethod) {
        log.info("test get payment by payment method: {}", paymentMethod);
        // این متد یک لیست از Payments برمی‌گرداند
        List<Payment> payments = paymentService.findByPaymentMethod(paymentMethod);
        return Response.ok().entity(payments).build(); // اصلاح شده: حالا باید لیست برگردانده شود
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response testAddPayment(Payment payment) {
        log.info("test add payment: {}", payment);
        paymentService.save(payment);
        return Response.ok().entity(payment).build(); // این متد یک Payment واحد برمی‌گرداند
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response testUpdatePayment(Payment payment) {
        log.info("test update payment: {}", payment);
        paymentService.edit(payment);
        return Response.ok().entity(payment).build(); // این متد یک Payment واحد برمی‌گرداند
    }

    @DELETE
    @Path("{id}")
    public Response testDeletePayment(@PathParam("id") Long id) {
        log.info("test delete payment with id: {}", id);
        paymentService.remove(id);
        return Response.ok().entity(id).build(); // این متد یک Payment واحد برمی‌گرداند
    }
}
