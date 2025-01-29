package com.mftplus.demo.controller.api;


import com.mftplus.demo.controller.interceptor.annotation.ResponseMaker;
import com.mftplus.demo.model.entity.Ticket;
import com.mftplus.demo.model.service.TicketService;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

@Path("/tickets")
@Slf4j
public class TicketApi {
    @Inject
    private TicketService ticketService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker(authority = "GET_TICKETS")
    public Object getAllTickets() {
        log.info("All-Tickets :");
        return ticketService.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker(authority = "GET_TICKET_BY_ID")
    public Object getTicketById(@PathParam("id") Long id) {
        log.info("Get-Ticket by id : {}", id);
        return ticketService.findById(id);
    }

    @GET
    @Path("/title/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker(authority = "GET_TICKET_BY_TITLE")
    public Object getTicketByTitle(@PathParam("title") String title) {
        log.info("Get-Ticket by title : {}", title);
        return ticketService.findByTitle(title);
    }

    @GET
    @Path("/text/{text}")
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker(authority = "GET_TICKET_BY_TEXT")
    public Object getTicketByText(@PathParam("text") String text) {
        log.info("Get-Ticket by text : {}", text);
        return ticketService.findByText(text);
    }

    @GET
    @Path("/response/{response}")
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker(authority = "GET_TICKET_BY_RESPONSE")
    public Object getTicketByRespType(@PathParam("response") String responseType) {
        log.info("Get-Ticket by response type : {}", responseType);
        return ticketService.findByResponseType(responseType);
    }

    @GET
    @Path("/username/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker(authority = "GET_TICKET_BY_USERNAME")
    public Object getTicketByUsername(@PathParam("username") String username) {
        log.info("Get-Ticket by username : {}", username);
        return ticketService.findByUsername(username);
    }

    @GET
    @Path("/email/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker(authority = "GET_TICKET_BY_EMAIL")
    public Object getTicketByUserEmail(@PathParam("email") String email) {
        log.info("Get-Ticket by Email : {}", email);
        return ticketService.findByUserEmail(email);
    }

    @GET
    @Path("/mTitle/{mTitle}")
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker(authority = "GET_TICKET_BY_TITLE")
    public Object getTicketByMessageTitle(@PathParam("mTitle") String title) {
        log.info("Get-Ticket by Message Title : {}", title);
        return ticketService.findByMessageTitle(title);
    }

    @GET
    @Path("/history/{history}")
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker(authority = "GET_TICKET_BY_HISTORY")
    public Object getTicketByDateTime(@PathParam("history") String dateTime) {
        log.info("Get-Ticket by date time : {}", dateTime);
        return ticketService.findByDateTime(dateTime);
    }

    @GET
    @Path("/mText/{mText}")
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker(authority = "GET_TICKET_BY_TEXT")
    public Object getTicketByMessageText(@PathParam("mText") String text) {
        log.info("Get-Ticket by Message Text : {}", text);
        return ticketService.findByMessageText(text);
    }

    @GET
    @Path("/groupName/{groupName}")
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker(authority = "GET_TICKET_BY_GROUP_NAME")
    public Object getTicketByGroupName(@PathParam("groupName") String name) {
        log.info("Get-Ticket by Group Name : {}", name);
        return ticketService.findByTicketGroupName(name);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker(authority = "SAVE_TICKET")
    public Object createTicket(@Valid Ticket ticket) {
        log.info("Create-Ticket : {}", ticket);
        ticketService.save(ticket);
        return ticket;
//        ticketService.save(ticket);
//        return Response.ok().entity(ticket).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
//    @Loggable
    @ResponseMaker(authority = "EDIT_TICKET")
    public Object updateTicket(@Valid Ticket ticket) {
        log.info("Update-Ticket : {}", ticket);
        ticketService.edit(ticket);
        return ticket;
    }

    @DELETE
    @Path("{id}")
    @ResponseMaker(authority = "REMOVE_TICKET")
    @Loggable
    //todo for object
    public Object deleteTicket(@PathParam("id") Long id) {
        log.info("Delete-Ticket : {}", id);
        Ticket ticket = ticketService.remove(id);
        return ticket.getId();
    }
}
