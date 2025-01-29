package com.mftplus.demo.controller.api;


import com.mftplus.demo.controller.interceptor.annotation.ResponseMaker;
import com.mftplus.demo.model.entity.OrderItem;
import com.mftplus.demo.model.service.OrderItemService;

import com.mftplus.demo.model.utils.Loggable;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

@Path("/orderItems")
@Slf4j
public class OrderItemApi {
    @Inject
    private OrderItemService orderItemService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_ORDER_ITEMS")
    @Loggable
    public Object getAllOrderItems() {
        log.info("Getting-all Order Items");
        return orderItemService.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    @ResponseMaker(authority = "GET_ORDER_ITEMS_BY_ID")
    @Loggable
    public Object getOrderItemById(@PathParam("id") Long id) {
        return orderItemService.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/proId/{proId}")
    @ResponseMaker(authority = "GET_ORDER_ITEMS_BY_PRODUCT_ID")
    @Loggable
    public Object getOrderItemByProductId(@PathParam("proId") Long id) {
        return orderItemService.findByProductId(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/proName/{proName}")
    @ResponseMaker(authority = "GET_ORDER_ITEMS_BY_PRODUCT_ID")
    @Loggable
    public Object getOrderItemByProductName(@PathParam("proName") String name) {
        return orderItemService.findByProductName(name);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "SAVE_ORDER_ITEMS")
    @Loggable
    public Object addOrderItems(OrderItem orderItem) {
        orderItemService.save(orderItem);
        return orderItem;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "UPDATE_ORDER_ITEMS")
    @Loggable
    public Object updateOrderItems(OrderItem orderItem) {
        orderItemService.edit(orderItem);
        return orderItem;
    }

    @DELETE
    @Path("{id}")
    @ResponseMaker(authority = "DELETE_ORDER_ITEMS")
    @Loggable
    public Object deleteOrderItems(@PathParam("id") Long id) {
        orderItemService.remove(id);
        return id;
    }
}
