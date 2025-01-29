package com.mftplus.demo.controller.api;

import com.mftplus.demo.controller.interceptor.annotation.ResponseMaker;
import com.mftplus.demo.model.entity.Order;
import com.mftplus.demo.model.entity.enums.OrderStatus;
import com.mftplus.demo.model.service.OrderService;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

@Path("/orders")
@Slf4j
public class OrderApi {
    @Inject
    private OrderService orderService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_ORDERS")
    @Loggable
    public Object getOrders() {
        log.info("get-Orders");
        return orderService.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    @ResponseMaker(authority = "GET_ORDERS_BY_ID")
    @Loggable
    public Object getOrderById(@PathParam("id") Long id) {
        return orderService.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/userId/{userId}")
    @ResponseMaker(authority = "GET_ORDERS_BY_USER_ID")
    @Loggable
    public Object getOrderByUserId(@PathParam("userId") Long id) {
        return orderService.findByUserId(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/username/{username}")
    @ResponseMaker(authority = "GET_ORDERS_BY_USERNAME")
    @Loggable
    public Object getOrderByUsername(@PathParam("username") String username) {
        return orderService.findByUsername(username);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/status/{status}")
    @ResponseMaker(authority = "GET_ORDERS_BY_STATUS")
    @Loggable
    public Object getOrderByUsername(@PathParam("status") OrderStatus orderStatus) {
        return orderService.findByOrderStatus(orderStatus);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/bill/{bill}")
    @ResponseMaker(authority = "GET_ORDERS_BY_BILLING_ADDRESS")
    @Loggable
    public Object getOrderByBillingAddress(@PathParam("bill") String billingAddress) {
        return orderService.findByBillingAddress(billingAddress);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/product/{product}")
    @ResponseMaker(authority = "GET_PRODUCTS_BY_ORDER_ITEM")
    @Loggable
    public Object getProductByOrderInItem(@PathParam("product") String name) {
        return orderService.findProductByOrderInItem(name);
    }//todo:  check beshe

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "SAVE_ORDERS")
    @Loggable
    public Object addOrder(@Valid Order order) {
        orderService.save(order);
        return order;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "UPDATE_ORDERS")
    @Loggable
    public Object updateOrder(@Valid Order order) {
        orderService.edit(order);
        return order;
    }

    @DELETE
    @Path("{id}")
    @ResponseMaker(authority = "DELETE_ORDERS_BY_ID")
    @Loggable
    public Object deleteOrder(@PathParam("id") Long id) {
        orderService.remove(id);
        return id;
    }
}
