package com.mftplus.demo.controller.api;

import com.mftplus.demo.controller.interceptor.annotation.ResponseMaker;
import com.mftplus.demo.model.entity.InventoryProduct;
import com.mftplus.demo.model.service.InventoryProductService;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import  jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Path("/inventory_product")
@Slf4j
public class InventoryProductApi {

    @Inject
    private InventoryProductService inventoryProductService;

    @GET
    @Loggable
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_INVENTORY_PRODUCT")
    public Object getInventoryProduct(){
        log.info("get inventory product info");
        return inventoryProductService.findAll();
    }

    @GET
    @Loggable
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_INVENTORY_PRODUCT_BY_ID")
    @Path("{id}")
    public Object getInventoryProductById (@PathParam("id") Long id){
        return inventoryProductService.findById(id);
    }

    @GET
    @Loggable
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_INVENTORY_PRODUCT_BY_QUANTITY")
    @Path("/quantity/{quantity}")
    public Object getInventoryProductByQuantity (@PathParam("quantity") Double quantity){
        return inventoryProductService.findByQuantity(quantity);
    }

    @GET
    @Loggable
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_INVENTORY_PRODUCT_BY_PRODUCT")
    @Path("/product/{product}")
    public Object getInventoryProductByProductId (@PathParam("product") Long id){
        return inventoryProductService.findByProductId(id);
    }

    @GET
    @Loggable
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_INVENTORY_PRODUCT_BY_PRODUCT_NAME")
    @Path("/product/{product}")
    public Object getInventoryProductByProductName (@PathParam("product") String name){
        return inventoryProductService.findByProductName(name);
    }

    @GET
    @Loggable
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_INVENTORY_PRODUCT_BY_INVENTORY_TRANSACTION_ID")
    @Path("/inventoryTransaction/{inventoryTransaction}")
    public Object getInventoryProductByInventoryTransactionId (@PathParam("inventoryTransaction") Long id){
        return inventoryProductService.findByInventoryTransactionId(id);
    }

    @GET
    @Loggable
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_INVENTORY_PRODUCT_BY_INVENTORY_ID")
    @Path("/inventory/{inventory}")
    public Object getInventoryProductByInventoryId (@PathParam("inventory") Long id){
        return inventoryProductService.findByInventoryId(id);
    }

    // inventoryTransaction

    @POST
    @Loggable
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "SAVE_INVENTORY_PRODUCT")
    public Object addInventoryProduct (@Valid InventoryProduct inventoryProduct){
        inventoryProductService.save(inventoryProduct);
        return inventoryProduct;
    }

    @PUT
    @Loggable
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "EDIT_INVENTORY_PRODUCT")
    public Object editInventoryProduct (InventoryProduct inventoryProduct){
        inventoryProductService.edit(inventoryProduct);
        return inventoryProduct;
    }

    @DELETE
    @Loggable
    @ResponseMaker(authority = "DELETE_INVENTORY_PRODUCT")
    @Path("{id}")
    public Object removeInventoryProduct(@PathParam("id") Long id) {
        inventoryProductService.remove(id);
        return id;
    }
}
