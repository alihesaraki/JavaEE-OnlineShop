package com.mftplus.demo.model.service;

import com.mftplus.demo.controller.interceptor.annotation.Authorize;
import com.mftplus.demo.model.entity.Bank;
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
public class BankService implements Service<Bank, Long> {

    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(Bank bank) {
        entityManager.persist(bank);
    }

    @Transactional
    @Authorize(authority = "ADMIN")
    @Override
    public void edit(Bank bank) {
        entityManager.merge(bank);
    }

    @Transactional
    @Authorize(authority = "ADMIN")
    @Override
    public void remove(Long id) {
        Bank bank = entityManager.find(Bank.class, id);
        if (bank != null) {
            entityManager.remove(bank);
        }
    }

    @Transactional
    @Override
    public Bank findById(Long id) {
        return entityManager.find(Bank.class, id);
    }

    @Transactional
    @Override
    public List<Bank> findAll() {
        Query query = entityManager.createQuery("select b from bankEntity b", Bank.class);
        return query.getResultList();
    }

    @Transactional
    @Authorize(authority = "USER")
    public Bank findByAccountNumber(String accountNumber) {
        Query query = entityManager.createQuery("select b from bankEntity b where b.accountNumber = :accountNumber", Bank.class);
        query.setParameter("accountNumber", accountNumber);
        return (Bank) query.getSingleResult();
    }
}
