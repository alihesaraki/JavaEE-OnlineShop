package com.mftplus.demo.controller.api;

import com.mftplus.demo.controller.interceptor.annotation.ResponseMaker;
import com.mftplus.demo.model.entity.GroupProperty;
import com.mftplus.demo.model.service.GroupPropertyService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

@Path("/properties")
@Slf4j
public class GroupPropertyApi {
    @Inject
    private GroupPropertyService groupPropertyService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_ALL_GROUP_PROPERTIES")
    public Object getProperties() {
        return groupPropertyService.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_GROUP_PROPERTIES_BY_ID")
    public Object getProductById(@PathParam("id") Long id) {
        return groupPropertyService.findById(id);
    }

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_GROUP_PROPERTIES_BY_NAME")
    public Object getProductByName(@PathParam("name") String name) {
        return groupPropertyService.findByName(name);
    }

    @GET
    @Path("/pGroupName/{pGroupName}")
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_GROUP_PROPERTIES_BY_P_GROUP_NAME")
    public Object getProductGroupNameByGroupProperty(@PathParam("pGroupName") String name) {
        return groupPropertyService.findProductGroupNameByGroupProperty(name);
    }

//    @GET
//    @Path("/pGroupParent/{pGroupParent}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @ResponseMaker(authority = "GET_GROUP_PROPERTIES_BY_P_GROUP_PARENT")
//    public Object getProductGroupParentByGroupProperty(@PathParam("pGroupParent") String name) {
//        return groupPropertyService.findProductGroupParentByGroupProperty(name);
//    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "SAVE_GROUP_PROPERTY")
    public Object addProperty(@Valid GroupProperty groupProperty) {
        groupPropertyService.save(groupProperty);
        return groupProperty;

    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "UPDATE_GROUP_PROPERTY")
    public Object updateProperty(@Valid GroupProperty groupProperty) {
        groupPropertyService.edit(groupProperty);
        return groupProperty;

    }

    @DELETE //TODO
    @Path("{id}")
    @ResponseMaker(authority = "DELETE_GROUP_PROPERTY")
    public Object deleteGroupProperty(@PathParam("id") Long id) {
        GroupProperty groupProperty = groupPropertyService.findById(id);
        groupPropertyService.remove(id);
        return groupProperty.getId();
    }
}
