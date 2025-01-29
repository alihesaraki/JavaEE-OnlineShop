package com.mftplus.demo.controller.api;

import com.mftplus.demo.controller.interceptor.annotation.ResponseMaker;
import com.mftplus.demo.model.entity.TicketGroup;
import com.mftplus.demo.model.service.TicketGroupService;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

@Path("/groups")
@Slf4j
public class TicketGroupApi {
    @Inject
    private TicketGroupService ticketGroupService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker(authority = "GET_TICKET_GROUPS")
    public Object getAllTicketGroups() {
        log.info("All-TicketGroups :");
        return ticketGroupService.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker(authority = "GET_TICKET_GROUPS_BY_ID")
    public Object getTicketGroupById(@PathParam("id") Long id) {
        log.info("Get-TicketGroup by id : {}", id);
        return ticketGroupService.findById(id);
    }

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker(authority = "GET_TICKET_GROUPS_BY_NAME")
    public Object getTicketGroupByName(@PathParam("name") String name) {
        log.info("Get-TicketGroup by name : {}", name);
        return ticketGroupService.findByName(name);
    }

    @GET
    @Path("/parent/{parent}")
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker(authority = "GET_TICKET_GROUPS_BY_PARENT")
    public Object getTicketGroupByParent(@PathParam("parent") String name) {
        log.info("Get-TicketGroup by parent : {}", name);
        return ticketGroupService.findByParent(name);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker(authority = "SAVE_TICKET_GROUP")
    public Object createTicketGroup(@Valid TicketGroup ticketGroup) {
        log.info("Create-TicketGroup : {}", ticketGroup);
        ticketGroupService.save(ticketGroup);
        return ticketGroup;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker(authority = "EDIT_TICKET_GROUP")
    public Object updateTicketGroup(@Valid TicketGroup ticketGroup) {
        log.info("Update-TicketGroup : {}", ticketGroup);
        ticketGroupService.edit(ticketGroup);
        return ticketGroup;
//        ticketGroupService.edit(ticketGroup);
//        return Response.ok().entity(ticketGroup).build();
    }

    @DELETE
    @Path("{id}")
    @ResponseMaker(authority = "EDIT_TICKET_GROUP")
    @Loggable
    //todo
    public Object deleteTicketGroup(@PathParam("id") Long id) {
        log.info("Delete ticketGroupGroupGroup : {}", id);
        TicketGroup ticketGroup = ticketGroupService.remove(id);
        return ticketGroup.getId();
    }
}
