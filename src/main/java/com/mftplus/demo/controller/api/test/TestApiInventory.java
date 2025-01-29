package com.mftplus.demo.controller.api.test;
import com.mftplus.demo.controller.interceptor.annotation.ResponseMaker;
import com.mftplus.demo.model.entity.Inventory;
import com.mftplus.demo.model.entity.InventoryProduct;
import com.mftplus.demo.model.entity.InventoryTransaction;
import com.mftplus.demo.model.entity.Product;
import com.mftplus.demo.model.entity.enums.InventoryStatus;
import com.mftplus.demo.model.service.InventoryProductService;
import com.mftplus.demo.model.service.InventoryService;
import com.mftplus.demo.model.service.InventoryTransactionService;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Path("/test_inventory")
public class TestApiInventory {

    @Inject
    private InventoryService inventoryService;


//    @GET
//    public String testInventory() {
//        log.info("test get inventories");
//        Product product = Product.builder().name("LLLL").code(897L).build();
//        InventoryProduct inventoryProduct = InventoryProduct.builder().quantity(52D).product(product).build();
//        Inventory inventory = Inventory.builder().title("cvc").phone("8888").address("NNNN").inventoryProduct(inventoryProduct).build();
//
//        inventoryService.save(inventory);
//        return inventoryService.findAll().toString();
//    }
    @Inject
    private InventoryProductService inventoryProductService;

//    @GET
//    public String testInventoryPro(){
//        log.info("test get inventory product");
//        Product product1 = Product.builder().name("hhh").code(8987L).build();
////        InventoryTransaction inventoryTransaction = InventoryTransaction.builder().status(InventoryStatus.income).count(5641D).build();
////        InventoryTransaction inventoryTransaction1 = InventoryTransaction.builder().status(InventoryStatus.income).count(695D).build();
//        InventoryProduct inventoryProduct = InventoryProduct.builder().quantity(59D).product(product1).build();
//        inventoryProductService.save(inventoryProduct);
//        return inventoryProductService.findAll().toString();
//    }

    @Inject
    private InventoryTransactionService inventoryTransactionService;
    @GET
    public String testInventoryTrans(){
        log.info("test get inventory transaction");
        Product product1 = Product.builder().name("hhh").code(8987L).build();
        InventoryProduct inventoryProduct = InventoryProduct.builder().quantity(59D).product(product1).build();
        InventoryTransaction inventoryTransaction = InventoryTransaction.builder().status(InventoryStatus.income).count(5641D).inventoryProduct(inventoryProduct).build();
//        InventoryTransaction inventoryTransaction1 = InventoryTransaction.builder().status(InventoryStatus.income).count(695D).build();
        inventoryTransactionService.save(inventoryTransaction);
        return inventoryTransactionService.findAll().toString();
    }
}

