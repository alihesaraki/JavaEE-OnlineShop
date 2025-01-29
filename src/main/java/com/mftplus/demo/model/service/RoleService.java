package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.Role;
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
public class RoleService {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;


    @Transactional
    @Loggable
    public void save(Role role) {
        entityManager.persist(role);
        log.info("Role saved: ");
    }

    @Transactional
    @Loggable
    public void edit(Role role) {
        if (role.getId() != null) {
            entityManager.merge(role);
            log.info("role-updated");
        } else {
            log.error("role-update-error");
        }
    }

    @Transactional
    @Loggable
    public Role remove(Long id) {
        Role role = entityManager.find(Role.class, id);
        entityManager.remove(role);
        log.info("Role removed");
        return role;
    }

    @Transactional
    @Loggable
    public Role findById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Transactional
    @Loggable
    public List<Role> findAll() {
        Query query = entityManager.createQuery("select r from roleEntity r", Role.class);
        return query.getResultList();
    }

    @Transactional
    @Loggable
    public List<Role> findByRoleName(String roleName) {
        Query query = entityManager.createQuery("select r from roleEntity r where r.roleName = :roleName", Role.class);
        query.setParameter("roleName", roleName);
        return query.getResultList();

    }

    @Transactional
    @Loggable
    public List<Role> findByUsername(String username) {
//        Query query = entityManager.createQuery("select r from  userEntity  r where r.username=:username", Role.class);

        Query query = entityManager.createQuery("select u.roleList from  userEntity  u where u.username=:username", Role.class);
        query.setParameter("username", username);
        return query.getResultList();

//        return (Set<Role>) query.getResultList().get(0);
    }

    @Transactional
    @Loggable
    public List<Role> findByPermission(String permissionName) {
        Query query = entityManager.createQuery("select r from roleEntity r cross join permissionEntity pp where pp.permissionName = : permissionName", Role.class);
        query.setParameter("permissionName", permissionName);
        return query.getResultList();

    }

}