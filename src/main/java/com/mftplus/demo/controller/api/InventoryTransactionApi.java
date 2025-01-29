package com.mftplus.demo.controller.api;
import com.mftplus.demo.model.utils.Loggable;
import com.mftplus.demo.controller.interceptor.annotation.ResponseMaker;
import com.mftplus.demo.model.entity.InventoryTransaction;
import com.mftplus.demo.model.service.InventoryTransactionService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import  jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

@Path("/inventoryTransaction")
@Slf4j
public class InventoryTransactionApi {

    @Inject
    private InventoryTransactionService inventoryTransactionService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_INVENTORY_TRANSACTION")
    @Loggable
    public Object getInventoryTransaction(){
        log.info("Get Inventory Transactions Info");
        return inventoryTransactionService.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    @ResponseMaker(authority = "GET_INVENTORY_TRANSACTION_BY_ID")
    @Loggable
    public Object getInventoryTransactionById(@PathParam("id") Long id){
        return inventoryTransactionService.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_INVENTORY_TRANSACTION_BY_INVENTORY")
    @Path("/inventory/{inventory}")
    @Loggable
    public Object getInventoryTransactionByInventory(@PathParam("inventory") Long id){
        log.info("get inventory id");
        return inventoryTransactionService.findByInventoryId(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_INVENTORY_TRANSACTION_BY_INVENTORY_TITLE")
    @Path("/inventory/{inventory}")
    @Loggable
    public Object getInventoryTransactionByInventory(@PathParam("inventory") String title) {
        log.info("get inventory title");
        return inventoryTransactionService.findByInventoryTitle(title);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_INVENTORY_TRANSACTION_BY_INVENTORY_TITLE")
    @Path("/product/{product}")
    @Loggable
    public Object getInventoryTransactionByProduct(@PathParam("product") Long id){
        return inventoryTransactionService.findByProductId(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_INVENTORY_TRANSACTION_BY_PRODUCT")
    @Path("/product/{product}")
    public Object getInventoryTransactionByProductName(@PathParam("product") String name){
        return inventoryTransactionService.findByProductName(name);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_INVENTORY_TRANSACTION_BY_INVENTORY_PRODUCT")
    @Path("/inventoryProduct/{inventoryProduct}")
    @Loggable
    public Object getInventoryTransactionByInventoryProduct(@PathParam("inventoryProduct") Long id){
        return inventoryTransactionService.findByInventoryProductId(id);
    }



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_INVENTORY_TRANSACTION_BY_ORDER_ITEM")
    @Path("/orderItem/{orderItem}")
    @Loggable
    public Object getInventoryTransactionByOrderItem(@PathParam("orderItem") Long id){
        return inventoryTransactionService.findByOrderItemId(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "SAVE_INVENTORY_TRANSACTION")
    @Loggable
    public Object addInventoryTransaction( @Valid InventoryTransaction inventoryTransaction){
        inventoryTransactionService.save(inventoryTransaction);
        return inventoryTransaction;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "EDIT_INVENTORY_TRANSACTION")
    @Loggable
    public Object updateInventoryTransaction(InventoryTransaction inventoryTransaction){
        inventoryTransactionService.edit(inventoryTransaction);
        return inventoryTransaction;
    }

    @DELETE
    @Path("{id}")
    @ResponseMaker(authority = "DELETE_INVENTORY_TRANSACTION")
    @Loggable
    public Object removeInventoryTransaction(@PathParam("id") Long id) {
        inventoryTransactionService.remove(id);
        return id;
    }
}
