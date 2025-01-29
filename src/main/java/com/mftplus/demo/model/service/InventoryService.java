package com.mftplus.demo.model.service;


import com.mftplus.demo.model.entity.Inventory;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@RequestScoped
@Loggable
@Slf4j
public class InventoryService implements Service<Inventory, Long> {

    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;


    @Override
    @Transactional
    @Loggable
    public void save(Inventory inventory) {
        entityManager.persist(inventory);
    }

    @Transactional
    @Override
    @Loggable
    public void edit(Inventory inventory) {
        entityManager.merge(inventory);
    }

    @Transactional
    @Override
    @Loggable
    public void remove(Long id) {
        Inventory inventory = entityManager.find(Inventory.class, id);
        entityManager.remove(inventory);
    }

    @Transactional
    @Override
    @Loggable
    public Inventory findById(Long id) {
        return entityManager.find(Inventory.class, id);
    }

    @Transactional
    @Override
    @Loggable
    public List<Inventory> findAll() {
        Query query = entityManager.createQuery("select oo from inventoryEntity oo", Inventory.class);
        return query.getResultList();
    }

    @Transactional
    @Loggable
    public List<Inventory> findByTitle(String title) {
        Query query = entityManager.createQuery("select oo from inventoryEntity oo where oo.title = :title", Inventory.class);
        query.setParameter("title", title);
        return query.getResultList();
    }

    @Transactional
    @Loggable
    public List<Inventory> findByAddress(String address) {
        Query query = entityManager.createQuery("select oo from inventoryEntity oo where oo.address = :address", Inventory.class);
        query.setParameter("address", address);

        return query.getResultList();
    }

    @Transactional
    @Loggable
    public List<Inventory> findByPhone(String phone) {
        Query query = entityManager.createQuery("select oo from inventoryEntity oo where oo.phone = :phone", Inventory.class);
        query.setParameter("phone", phone);
        return query.getResultList();
    }

    @Transactional
    @Loggable
    public Inventory findByInventoryProductId(Long id) {
        Query query = entityManager.createQuery("select oo from inventoryEntity oo cross join inventory_product i where i.id=:id", Inventory.class);
        query.setParameter("id", id);
        return (Inventory) query.getSingleResult();
    }


    @Transactional
    @Loggable
    public Inventory findByProductName(String name) {
        Query query = entityManager.createQuery("select oo from inventoryEntity oo cross join inventory_product i where i.product.name=:Product_Name", Inventory.class);
        query.setParameter("Product_Name", name);
        return (Inventory) query.getResultList();
    }


}
