package com.mftplus.demo.controller.api.test;

import com.mftplus.demo.model.entity.*;
import com.mftplus.demo.model.entity.enums.DeliveryMethod;
import com.mftplus.demo.model.entity.enums.DeliveryStatus;
import com.mftplus.demo.model.entity.enums.OrderStatus;
import com.mftplus.demo.model.service.DeliveryService;
import com.mftplus.demo.model.service.OrderItemService;
import com.mftplus.demo.model.service.OrderService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;
@Slf4j
@Path("/testOrder")
public class TestApiOrder {

//    @Inject
//    private OrderService orderService;
//
//    @GET
//    public String testOrder() {
//        Product product = Product.builder().name("aux").code(564l).price(52.6f).build();
//        User user = User.builder().username("zahra").email("ebrahimi").password("123321").build();
//        OrderItem orderItem = OrderItem.builder().product(product).price(300L).amount(500).quantity(3).build();
//        Order order = Order.builder().user(user).tax(5642).billingAddress("hhhh").discount(56).shippingCost(89745).totalAmount(89).orderDateTime(LocalDateTime.of(2020, 10, 5, 22, 15)).orderItems(List.of(orderItem)).orderStatus(OrderStatus.PENDING).build();
//        orderService.save(order);
//        return orderService.findAll().toString();
//    }

//    @Inject
//    private OrderItemService orderItemService;
//
//    @GET
//    public String testOrderItem() {
//        Product product = Product.builder().name("aux").code(564l).price(52.6f).build();
//        OrderItem orderItem = OrderItem.builder().product(product).price(555).amount(888).quantity(65).build();
//        orderItemService.save(orderItem);
//        return orderItemService.findAll().toString();
//    }

    @Inject
    private DeliveryService deliveryService;

    @GET
    public String testDelivery() {
        Product product = Product.builder().name("aux").code(564l).price(52.6f).build();
        OrderItem orderItem = OrderItem.builder().product(product).price(555).amount(888).quantity(65).build();
        Order order = Order.builder().tax(5642).billingAddress("hhhh").discount(56).shippingCost(89745).totalAmount(89).orderDateTime(LocalDateTime.of(2020, 10, 5, 22, 15)).orderItems(List.of(orderItem)).orderStatus(OrderStatus.PENDING).build();
        Delivery delivery = Delivery.builder().deliveredDate(LocalDateTime.now()).deliveryAddress("KJKJ").deliveryMethod(DeliveryMethod.expressShipping).deliveryStatus(DeliveryStatus.OUT_FOR_DELIVERY).trackingNumber("565").carrier("HOSSEIN AGHA").phoneNumber("56545").order(order).shippedDate(LocalDateTime.now()).shippingCost(565).build();
        deliveryService.save(delivery);
        return deliveryService.findAll().toString();
    }
}