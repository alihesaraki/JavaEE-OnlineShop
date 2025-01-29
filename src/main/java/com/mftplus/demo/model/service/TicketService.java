package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.Ticket;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;


import java.util.List;

@RequestScoped
@Slf4j
public class TicketService {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Transactional
    @Loggable
    public void save(Ticket ticket) {
        entityManager.persist(ticket);
        log.info("ticket-saved");
    }

    @Transactional
    @Loggable
    public void edit(Ticket ticket) {
        if (ticket.getId() != null) {
            entityManager.merge(ticket);
            log.info("ticket-updated");
        } else {
            log.error("ticket-update-error");
        }
    }

    @Transactional
    @Loggable
    public Ticket remove(Long id) {
        Ticket ticket = entityManager.find(Ticket.class, id);
        entityManager.remove(ticket);
        log.info("ticket-removed");
        return ticket;
    }

    @Transactional
    @Loggable
    public Ticket findById(Long id) {
        return entityManager.find(Ticket.class, id);
    }

    @Transactional
    @Loggable
    public List<Ticket> findAll() {
        Query query = entityManager.createQuery("select t from ticketEntity t", Ticket.class);
        return query.getResultList();

    }

    @Transactional
    @Loggable
    public List<Ticket> findByTitle(String title) {
        Query query = entityManager.createQuery("select t from ticketEntity t where t.title=:title", Ticket.class);
        query.setParameter("title", title);
        return query.getResultList();
    }

    @Transactional
    @Loggable
    public Ticket findByDateTime(String dateTime) {
        Query query = entityManager.createQuery("select t from ticketEntity t where t.dateTime=:dateTime", Ticket.class);
        query.setParameter("dateTime", dateTime);
        return (Ticket) query.getSingleResult();
    }

    @Transactional
    @Loggable
    public List<Ticket> findByText(String text) {
        Query query = entityManager.createQuery("select t from ticketEntity t where t.text=:text", Ticket.class);
        query.setParameter("text", text);
        return query.getResultList();
    }

    @Transactional
    @Loggable
    public Ticket findByResponseType(String responseType) {
        Query query = entityManager.createQuery("select t from ticketEntity t where t.responseType=:responseType", Ticket.class);
        query.setParameter("responseType", responseType);
        return (Ticket) query.getSingleResult();
    }

    @Transactional
    @Loggable
    public Ticket findByUsername(String username) {
        Query query = entityManager.createQuery("select t from ticketEntity t where t.user.username=:username", Ticket.class);
        query.setParameter("username", username);
        return (Ticket) query.getSingleResult();
    }

    @Transactional
    @Loggable
    public Ticket findByUserEmail(String email) {
        Query query = entityManager.createQuery("select t from ticketEntity t where t.user.email=:email", Ticket.class);
        query.setParameter("email", email);
        return (Ticket) query.getSingleResult();
    }

    @Transactional
    @Loggable
    public List<Ticket> findByMessageTitle(String title) {
        Query query = entityManager.createQuery("select t from ticketEntity t cross join messageEntity  m where m.title =:title", Ticket.class);
        query.setParameter("title", title);
        return query.getResultList();
    }

    @Transactional
    @Loggable
    public List<Ticket> findByMessageText(String text) {
        Query query = entityManager.createQuery("select t from ticketEntity t cross join messageEntity  m where m.text =:text", Ticket.class);
        query.setParameter("text", text);
        return query.getResultList();
    }

    @Transactional
    @Loggable
    public Ticket findByTicketGroupName(String name) {
        Query query = entityManager.createQuery("select t from ticketEntity t where t.ticketGroup.name=:name", Ticket.class);
        query.setParameter("name", name);
        return (Ticket) query.getSingleResult();
    }
}
