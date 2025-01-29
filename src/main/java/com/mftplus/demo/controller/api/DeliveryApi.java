package com.mftplus.demo.controller.api;


import com.mftplus.demo.controller.interceptor.annotation.ResponseMaker;
import com.mftplus.demo.model.entity.Delivery;
import com.mftplus.demo.model.entity.enums.DeliveryMethod;
import com.mftplus.demo.model.entity.enums.DeliveryStatus;
import com.mftplus.demo.model.service.DeliveryService;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

@Path("/deliveries")
@Slf4j
public class DeliveryApi {

    @Inject
    private DeliveryService deliveryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_ALL_DELIVERIES")
    @Loggable
    public Object getAllDelivery() {
        log.info("Getting-all Deliveries");
        return deliveryService.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_DELIVERY_BY_ID")
    @Path("{id}")
    @Loggable
    public Object getDeliveryById(@PathParam("id") Long id) {
        return deliveryService.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_DELIVERY_BY_TRACK_NUMBER")
    @Path("/track/{track}")
    @Loggable
    public Object getDeliveryByTrackNumber(@PathParam("track") String trackingNumber) {
        return deliveryService.findByTrackingNumber(trackingNumber);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_DELIVERY_BY_DELIVERY_ADDRESS")
    @Path("/address/{address}")
    @Loggable
    public Object getDeliveryByDeliveryAddress(@PathParam("address") String deliveryAddress) {
        return deliveryService.findByDeliveryAddress(deliveryAddress);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_DELIVERY_BY_CARRIER")
    @Path("/carrier/{carrier}")
    @Loggable
    public Object getDeliveryByCarrier(@PathParam("carrier") String carrier) {
        return deliveryService.findByCarrier(carrier);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_DELIVERY_BY_CARRIER")
    @Path("/shipCost/{shipCost}")
    @Loggable
    public Object getDeliveryByShippingCost(@PathParam("shipCost") double shippingCost) {
        return deliveryService.findByShippingCost(shippingCost);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_DELIVERY_BY_STATUS")
    @Path("/status/{status}")
    @Loggable
    public Object getDeliveryByDeliveryStatus(@PathParam("status") DeliveryStatus status) {
        return deliveryService.findByDeliveryStatus(status);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_DELIVERY_BY_DELIVERY_METHOD")
    @Path("/method/{method}")
    @Loggable
    public Object getDeliveryByDeliveryMethod(@PathParam("method") DeliveryMethod deliveryMethod) {
        return deliveryService.findByDeliveryMethod(deliveryMethod);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_PHONE_BY_DELIVERY")
    @Path("/phone/{phone}")
    @Loggable
    public Object getDeliveryByPhoneNumber(@PathParam("phone") String phoneNumber) {
        return deliveryService.findByPhoneNumber(phoneNumber);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_ORDER_BY_DELIVERY")
    @Path("/order/{order}")
    @Loggable
    public Object getOrderIdByDelivery(@PathParam("order") Long id) {
        return deliveryService.findOrderIdByDelivery(id);
    }//todo: check
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_DELIVERY_BY_ORDER_USERNAME")
    @Path("/username/{username}")
    @Loggable
    public Object getUsernameByDelivery(@PathParam("username") String username) {
        return deliveryService.findOrderByUsername(username);
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "CREATE_DELIVERY")
    @Loggable
    public Object addDelivery(@Valid Delivery delivery) {
        deliveryService.save(delivery);
        return delivery;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "UPDATE_DELIVERY")
    @Loggable
    public Object updateDelivery(@Valid Delivery delivery) {
        deliveryService.edit(delivery);
        return delivery;
    }

    @DELETE
    @Path("{id}")
    @ResponseMaker(authority = "REMOVE_DELIVERY")
    @Loggable
    public Object deleteDelivery(@PathParam("id") Long id) {
        deliveryService.remove(id);
        return id;
    }
}
