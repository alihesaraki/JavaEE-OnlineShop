package com.mftplus.demo.controller.api;

import com.mftplus.demo.controller.interceptor.annotation.ResponseMaker;
import com.mftplus.demo.model.entity.ProductPropertyValue;
import com.mftplus.demo.model.service.ProductPropertyValueService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

@Path("/values")
@Slf4j
public class ProPropertyValueApi {
    @Inject
    private ProductPropertyValueService productPropertyValueService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_ALL_PROPERTY_VALUE")
    public Object getValues() {
        log.info("Get all property values");
        return productPropertyValueService.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_PROPERTY_VALUE_BY_ID")
    public Object getValuesById(@PathParam("id") Long id) {
        log.info("Get property value by id: {}", id);
        return productPropertyValueService.findById(id);
    }

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_PROPERTY_VALUE_BY_NAME")
    public Object getValuesByName(@PathParam("name") String name) {
        log.info("Get property value by name: {}", name);
        return productPropertyValueService.findByName(name);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "SAVE_PROPERTY_VALUE")
    public Object addValues(@Valid ProductPropertyValue productPropertyValue) {
        log.info("Save property value: {}", productPropertyValue);
        productPropertyValueService.save(productPropertyValue);
        return productPropertyValue;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "UPDATE_PROPERTY_VALUE")
    public Object updateValues(@Valid ProductPropertyValue productPropertyValue) {
        log.info("Update property value: {}", productPropertyValue);
        productPropertyValueService.edit(productPropertyValue);
        return productPropertyValue;
    }

    @DELETE
    @Path("{id}")
    @ResponseMaker(authority = "DELETE_PROPERTY_VALUE")
    public Object removeValueById(@PathParam("id") Long id) {
        log.info("remove value By Id");
        ProductPropertyValue productPropertyValue = productPropertyValueService.findById(id);
        productPropertyValueService.remove(id);
        return productPropertyValue.getId();
    }
}
