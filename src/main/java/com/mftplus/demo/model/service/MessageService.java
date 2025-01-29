package com.mftplus.demo.model.service;


import com.mftplus.demo.model.entity.Message;
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
public class MessageService {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Transactional
    @Loggable
    public void save(Message message) {
        entityManager.persist(message);
        log.info("message-saved");

    }

    @Transactional
    @Loggable
    public void edit(Message message) {
        if (message.getId() != null) {
            entityManager.merge(message);
            log.info("message-updated");
        } else {
            log.error("message-update-error");
        }
    }

    @Transactional
    @Loggable
    public Message remove(Long id) {
        Message message = entityManager.find(Message.class, id);
        entityManager.remove(message);
        log.info("message-removed");
        return message;

    }

    @Transactional
    @Loggable
    public Message findById(Long id) {
        return entityManager.find(Message.class, id);
    }

    @Transactional
    @Loggable
    public List<Message> findAll() {
        Query query = entityManager.createQuery("select m from messageEntity m", Message.class);
        return query.getResultList();

    }

    @Transactional
    @Loggable
    public List<Message> findByTitle(String title) {
        Query query = entityManager.createQuery("select m from messageEntity m where m.title=:title", Message.class);
        query.setParameter("title", title);
        return query.getResultList();
    }

    @Transactional
    @Loggable
    public Message findByDateTime(String dateTime) {
        Query query = entityManager.createQuery("select m from messageEntity m where m.dateTime=:dateTime", Message.class);
        query.setParameter("dateTime", dateTime);
        return (Message) query.getSingleResult();
    }

    @Transactional
    @Loggable
    public List<Message> findByText(String text) {
        Query query = entityManager.createQuery("select m from messageEntity m where m.text=:text", Message.class);
        query.setParameter("text", text);
        return query.getResultList();
    }

    @Transactional
    @Loggable
    public Message findByUsername(String username) {
        Query query = entityManager.createQuery("select m from messageEntity m where m.user.username=:username", Message.class);
        query.setParameter("username", username);
        return (Message) query.getSingleResult();
    }

    @Transactional
    @Loggable
    public Message findByUserEmail(String email) {
        Query query = entityManager.createQuery("select m from messageEntity m where m.user.email=:email", Message.class);
        query.setParameter("email", email);
        return (Message) query.getSingleResult();
    }
}
