package com.mftplus.demo.controller.api.test;


import com.mftplus.demo.model.entity.Message;
import com.mftplus.demo.model.entity.Ticket;
import com.mftplus.demo.model.service.MessageService;
import com.mftplus.demo.model.service.TicketService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;

@Path("/testTicketing")
@Slf4j
public class TestApiTicketing {

//    @Inject
//    private TicketService ticketService;
//
//    @GET
//    public String getTicket(){
//        log.info("get ticket test");
//        Ticket ticket = Ticket.builder().text("aaaaaaa").createdBy("ali").dateTime("11:50").createdDate("2025/02/11").responseType("emailing").title("firing").build();
//        ticketService.save(ticket);
//        return ticketService.findAll().toString();
//    }

    @Inject
    private MessageService messageService;

    @GET
    public String getMessage(){
        log.info("get ticket test");
        Message message = Message.builder().text("ppppp").createdDate("monday").createdBy("manager").dateTime("15:00").title("mmm").updatedBy("kimia").build();
        messageService.save(message);
        return messageService.findAll().toString();
    }
}
