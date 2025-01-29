package com.mftplus.demo.controller.api;


import com.mftplus.demo.controller.interceptor.annotation.ResponseMaker;
import com.mftplus.demo.model.entity.Product;
import com.mftplus.demo.model.service.ProductService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

@Path("/products")
@Slf4j
public class productApi {
    @Inject
    private ProductService productService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_ALL_PRODUCTS")
    public Object getProducts() {
        log.info("getProducts +");
        return productService.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_ALL_PRODUCTS_BY_ID")
    public Object getProductById(@PathParam("id") Long id) {
        log.info("getProduct By Id +");
        return productService.findById(id);
    }

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_ALL_PRODUCTS_BY_NAME")
    public Object getProductByName(@PathParam("name") String name) {
        log.info("getProductByName +");
        return productService.findByName(name);
    }

//    @GET
//    @Path("/price/{price}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getProductByPrice(@PathParam("price") Float price) {
//        log.info("getProductByPrice +");
//        return Response.ok().entity(productService.findByPrice(price)).build();
//    }

    @GET
    @Path("/code/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_ALL_PRODUCTS_BY_CODE")
    public Object getProductByCode(@PathParam("code") Long code) {
        log.info("getProductByCode +");
        return productService.findByCode(code);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "SAVE_PRODUCTS")
    public Object addProduct(@Valid Product product) {
        log.info("add Product +");
        productService.save(product);
        return product;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "UPDATE_PRODUCTS")
    public Object updateProduct(@Valid Product product) {
        log.info("update Product +");
        productService.edit(product);
        return product;
    }

    @DELETE
    @Path("{id}")
    @ResponseMaker(authority = "DELETE_PRODUCTS")
    public Object deleteProduct(@PathParam("id") Long id) {
        log.info("deleteProduct +");
        Product product = productService.findById(id);
        productService.remove(id);
        return product.getId();
    }

}
