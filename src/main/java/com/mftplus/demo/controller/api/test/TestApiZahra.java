//package com.mftplus.demo.controller.api.test;
//
//import com.mftplus.demo.model.entity.*;
//import com.mftplus.demo.model.entity.enums.OrderStatus;
//import com.mftplus.demo.model.service.InventoryService;
//import com.mftplus.demo.model.service.InventoryTransactionService;
//import com.mftplus.demo.model.service.OrderService;
//import jakarta.inject.Inject;
//import jakarta.ws.rs.GET;
//import jakarta.ws.rs.Path;
//
//import java.util.List;
//
//@Path("test4")
//public class TestApiZahra {
//    @Inject
//    private OrderService orderService;
//
//    @Inject
//   private InventoryTransactionService inventoryTransactionService;
//
//    @Inject
//    private InventoryService inventoryService;
//
//    @GET
//    public String test(){
//        Product product=Product.builder().name("dress").build();
//        OrderItem orderItem=OrderItem.builder().unitPrice(100L).build();
//        Order order=Order.builder().orderItems(List.of(orderItem)).orderStatus(OrderStatus.PENDING).discount(100).shippingCost(50).build();
//        orderService.save(order);
//        InventoryTransaction inventoryTransaction=InventoryTransaction.builder().order(order).product(product).build();
//        Inventory inventory = Inventory.builder().inventoryTransaction(inventoryTransaction).address("tehran").phone("1234").title("pooshak").build();
//        inventoryService.save(inventory);
//        return inventory.toString();
//    }
//}
