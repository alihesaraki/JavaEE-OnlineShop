package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.Delivery;
import com.mftplus.demo.model.entity.enums.DeliveryMethod;
import com.mftplus.demo.model.entity.enums.DeliveryStatus;
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

public class DeliveryService implements Service<Delivery, Long> {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Transactional
    @Override
    @Loggable
    public void save(Delivery delivery) {
        entityManager.persist(delivery);
        log.info("delivery-saved");
    }

    @Transactional
    @Override
    @Loggable
    public void edit(Delivery delivery) {
        if (delivery.getId() != null) {
            entityManager.merge(delivery);
            log.info("delivery-updated");
        } else {
            log.error("delivery-update-error");
        }
    }
//        entityManager.merge(delivery);
//        log.info("delivery-updated");
//    }

    @Transactional
    @Override
    @Loggable
    public void remove(Long id) {
        Delivery delivery = entityManager.find(Delivery.class, id);
        entityManager.remove(delivery);
        log.info("delivery-removed");
    }

    @Transactional
    @Override
    @Loggable
    public Delivery findById(Long id) {
        return entityManager.find(Delivery.class, id);
    }

    @Transactional
    @Override
    @Loggable
    public List<Delivery> findAll() {
        Query query = entityManager.createQuery("select d from deliveryEntity d", Delivery.class);
        return query.getResultList();
    }

    @Transactional
    @Loggable
    public Delivery findByTrackingNumber(String trackingNumber) {
        Query query = entityManager.createQuery("select d from deliveryEntity d where d.trackingNumber = :trackingNumber", Delivery.class);
        query.setParameter("trackingNumber", trackingNumber);
        return (Delivery) query.getSingleResult();
    }

    @Transactional
    @Loggable
    public List<Delivery> findByDeliveryAddress(String deliveryAddress) {
        Query query = entityManager.createQuery("select d from deliveryEntity d where d.deliveryAddress = :deliveryAddress", Delivery.class);
        query.setParameter("deliveryAddress", deliveryAddress);
        return query.getResultList();
    }

    @Transactional
    @Loggable
    public List<Delivery> findByCarrier(String carrier) {
        Query query = entityManager.createQuery("select d from deliveryEntity d where d.carrier = :carrier", Delivery.class);
        query.setParameter("carrier", carrier);
        return query.getResultList();
    }

    @Transactional
    @Loggable
    public List<Delivery> findByShippingCost(double shippingCost) {
        Query query = entityManager.createQuery("select d from deliveryEntity d where d.shippingCost = :shippingCost", Delivery.class);
        query.setParameter("shippingCost", shippingCost);
        return query.getResultList();
    }

    @Transactional
    @Loggable
    public List<Delivery> findByDeliveryStatus(DeliveryStatus deliveryStatus) {
        Query query = entityManager.createQuery("select d from deliveryEntity d where d.deliveryStatus = :deliveryStatus", Delivery.class);
        query.setParameter("deliveryStatus", deliveryStatus);
        return query.getResultList();
    }

    @Transactional
    @Loggable
    public List<Delivery> findByDeliveryMethod(DeliveryMethod deliveryMethod) {
        Query query = entityManager.createQuery("select d from deliveryEntity d where d.deliveryMethod = :deliveryMethod", Delivery.class);
        query.setParameter("deliveryMethod", deliveryMethod);
        return query.getResultList();
    }

    @Transactional
    @Loggable
    public List<Delivery> findByPhoneNumber(String phoneNumber) {
        Query query = entityManager.createQuery("select d from deliveryEntity d where d.phoneNumber = :phoneNumber", Delivery.class);
        query.setParameter("phoneNumber", phoneNumber);
        return query.getResultList();
    }

    @Transactional
    @Loggable
    public Delivery findOrderIdByDelivery(Long id) {
        Query query = entityManager.createQuery("select d from deliveryEntity d join orderEntity o where o.id = :id", Delivery.class);
        query.setParameter("id", id);
        return (Delivery) query.getSingleResult();
    }

    @Transactional
    @Loggable
    public Delivery findOrderByUsername(String username) {
        Query query = entityManager.createQuery("select d from deliveryEntity d join orderEntity o where o.user.username like:username", Delivery.class);
        query.setParameter("username", username);
        return (Delivery) query.getSingleResult();
    }


}
