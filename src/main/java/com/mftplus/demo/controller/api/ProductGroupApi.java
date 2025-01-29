package com.mftplus.demo.controller.api;

import com.mftplus.demo.controller.interceptor.annotation.ResponseMaker;
import com.mftplus.demo.model.entity.ProductGroup;
import com.mftplus.demo.model.service.ProductGroupService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

@Path("/ProductsGroups")
@Slf4j

public class ProductGroupApi {
    @Inject
    private ProductGroupService productGroupService;

    @GET
    @Produces
    @ResponseMaker(authority = "GET_ALL_PRODUCT_GROUPS")
    public Object getProductGroups() {
        log.info("getProductGroups");
        return productGroupService.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_PRODUCT_GROUP_BY_ID")
    public Object getProductGroupById(@PathParam("id") Long id) {
        log.info("getProductGroupById");
        return productGroupService.findById(id);
    }

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_PRODUCT_GROUP_BY_NAME")
    public Object getProductGroupByName(@PathParam("name") String name) {
        log.info("getProductGroupByName");
        return productGroupService.findByName(name);
    }

//    @GET
//    @Path("/child/{child}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @ResponseMaker(authority = "GET_PRODUCT_GROUP_BY_ID")
//    public Response getProductGroupByChild(@PathParam("child") String child) {
//        log.info("getProductGroupByChild");
//        return Response.ok().entity(productGroupService.findByChild(child)).build();
//    }

    @GET
    @Path("/parent/{parent}")
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_PRODUCT_GROUP_BY_PARENT_NAME")
    public Object getProductGroupByParent(@PathParam("parent") String name) {
        log.info("getProductGroupByParent");
        return productGroupService.findByParent(name);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "SAVE_PRODUCT_GROUP")
    public Object addProductGroup(@Valid ProductGroup productGroup) {
        log.info("addProductGroup");
        productGroupService.save(productGroup);
        return productGroup;

    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "UPDATE_PRODUCT_GROUP")
    public Object editProductGroup(@Valid ProductGroup productGroup) {
        log.info("edit ProductGroup");
        productGroupService.edit(productGroup);
        return productGroup;
    }

    @DELETE
    @Path("{id}")
    @ResponseMaker(authority = "DELETE_PRODUCT_GROUP")
    public Object removeProductGroupById(@PathParam("id") Long id) {
        log.info("remove ProductGroupById");
        ProductGroup productGroup = productGroupService.findById(id);
        productGroupService.remove(id);
        return productGroup.getId();
    }

}
