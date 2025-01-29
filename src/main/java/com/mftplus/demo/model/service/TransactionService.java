package com.mftplus.demo.model.service;

import com.mftplus.demo.controller.interceptor.annotation.Authorize;
import com.mftplus.demo.model.entity.Transaction;
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
public class TransactionService implements Service<Transaction, Long> {

    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Transactional
    @Override
    @Authorize(authority = "ADMIN")
    public void save(Transaction transaction) {
        entityManager.persist(transaction);
    }

    @Transactional
    @Override
    @Authorize(authority = "ADMIN")
    public void edit(Transaction transaction) {
        entityManager.merge(transaction);
    }

    @Transactional
    @Override
    @Authorize(authority = "ADMIN")
    public void remove(Long id) {
        Transaction transaction = entityManager.find(Transaction.class, id);
        if (transaction != null) {
            entityManager.remove(transaction);
        }
    }

    @Transactional
    @Override
    public Transaction findById(Long id) {
        return entityManager.find(Transaction.class, id);
    }

    @Transactional
    @Override
    public List<Transaction> findAll() {
        Query query = entityManager.createQuery("select t from transactionEntity t", Transaction.class);
        return query.getResultList();
    }

    @Transactional
    @Authorize(authority = "USER")
    public Transaction findByTrackingCode(Long trackingCode) {
        Query query = entityManager.createQuery("select t from transactionEntity t where t.trackingCode = :trackingCode", Transaction.class);
        query.setParameter("trackingCode", trackingCode);
        return (Transaction) query.getSingleResult();
    }
}
