package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.InventoryProduct;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.enterprise.context.RequestScoped;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

@RequestScoped
@Loggable
@Slf4j
public class InventoryProductService implements Service<InventoryProduct, Long> {

    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;


    @Override
    @Loggable
    @Transactional
    public void save (InventoryProduct inventoryProduct){
       entityManager.persist(inventoryProduct);
    }

    @Transactional
    @Override
    @Loggable
    public void edit (InventoryProduct inventoryProduct){
        entityManager.merge(inventoryProduct);
    }

    @Transactional
    @Override
    @Loggable
    public void remove (Long id){
        InventoryProduct inventoryProduct = entityManager.find(InventoryProduct.class,id);
        entityManager.remove(inventoryProduct);
    }

    @Transactional
    @Override
    @Loggable
    public List<InventoryProduct> findAll(){
        Query query = entityManager.createQuery("select bb from inventory_product bb", InventoryProduct.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    @Loggable
    public InventoryProduct findById(Long id){
              return entityManager.find(InventoryProduct.class,id);
    }

    @Transactional
    @Loggable
    public List<InventoryProduct> findByQuantity (Double quantity){
        Query query = entityManager.createQuery("select bb from inventory_product bb where bb.quantity = : quantity", InventoryProduct.class);
        query.setParameter("quantity", quantity);
        return query.getResultList();
    }

    @Transactional
    @Loggable
    public InventoryProduct findByProductId(Long id) {
        Query query = entityManager.createQuery("select bb from inventory_product bb where bb.product.id =:id", InventoryProduct.class);
        query.setParameter("id", id);
        return (InventoryProduct) query.getResultList();
    }

    @Transactional
    @Loggable
    public List<InventoryProduct> findByProductName(String name) {
        Query query = entityManager.createQuery("select bb from inventory_product bb where bb.product.name = :Product_Name",InventoryProduct.class);
        query.setParameter("Product_Name",name);
        return query.getResultList();
    }

    @Transactional
    @Loggable
    public List<InventoryProduct> findByInventoryTransactionId (Long id) {
        Query query = entityManager.createQuery("select d from inventory_product d join inventoryTransactionEntity o where o.id = :Transaction_Id", InventoryProduct.class);
        query.setParameter("Transaction_Id", id);
        return query.getResultList();
    }

    @Transactional
    @Loggable
    public InventoryProduct findByInventoryId (Long id) {
        Query query = entityManager.createQuery("select d from inventory_product d join inventoryEntity o where o.id = :Inventory_Id", InventoryProduct.class);
        query.setParameter("Inventory_Id",id);
        return (InventoryProduct) query.getResultList();
    }

}
