package com.mftplus.demo.test;

import com.mftplus.demo.model.entity.Order;
import com.mftplus.demo.model.service.OrderService;

public class OrderTest {
    public static void main(String[] args) {
       Order order = Order
               .builder()
               .tax(0.10)
               .shippingCost(10.00)

               .totalAmount(150)
               .build();

//        OrderService.getRoleService.save(order); todo --> getRoleService does not work
//        OrderService todo --> OrderService does not work
    }
}
