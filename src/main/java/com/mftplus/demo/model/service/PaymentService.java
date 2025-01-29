package com.mftplus.demo.model.service;

import com.mftplus.demo.controller.interceptor.annotation.Authorize;
import com.mftplus.demo.model.entity.Payment;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@ApplicationScoped
@Loggable
@Slf4j
public class PaymentService implements Service<Payment, Long> {

    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(Payment payment) {
        entityManager.persist(payment);
    }

    @Transactional
    @Authorize(authority = "ADMIN")
    @Override
    public void edit(Payment payment) {
        entityManager.merge(payment);
    }

    @Transactional
    @Authorize(authority = "ADMIN")
    @Override
    public void remove(Long id) {
        Payment payment = entityManager.find(Payment.class, id);
        if (payment != null) {
            entityManager.remove(payment);
        }
    }

    @Transactional
    @Override
    public Payment findById(Long id) {
        return entityManager.find(Payment.class, id);
    }

    @Transactional
    @Override
    public List<Payment> findAll() {
        Query query = entityManager.createQuery("select p from paymentEntity p", Payment.class);
        return query.getResultList();
    }

    @Transactional
    @Authorize(authority = "USER")
    public Payment findByDocNumber(Long docNumber) {
        Query query = entityManager.createQuery("select p from paymentEntity p where p.docNumber = :docNumber", Payment.class);
        query.setParameter("docNumber", docNumber);
        return (Payment) query.getSingleResult();
    }

    @Transactional
    @Authorize(authority = "USER")
    public List<Payment> findByPaymentMethod(String paymentMethod) {
        Query query = entityManager.createQuery("select p from paymentEntity p where p.paymentMethod = :paymentMethod", Payment.class);
        query.setParameter("paymentMethod", paymentMethod);
        return query.getResultList();
    }
}
