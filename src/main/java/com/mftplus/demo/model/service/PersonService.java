package com.mftplus.demo.model.service;

import com.mftplus.demo.controller.exception.NoPersonException;
import com.mftplus.demo.model.entity.Person;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RequestScoped
@Slf4j
public class PersonService {

    @Inject
    private UserService userService;

    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;
    @Inject
    private PermissionService permissionService;

    @Transactional
    @Loggable
    public void save(Person person) {
        entityManager.persist(person);
        log.info("person-saved");
    }

    @Transactional
    @Loggable
    public void edit(Person person) {
        if (person.getId() != null) {
            entityManager.merge(person);
            log.info("person-updated");
        } else {
            log.error("person-update-error");
        }
    }

    @Transactional
    @Loggable
    public Person remove(Long id) {
        Person person = entityManager.find(Person.class, id);
        entityManager.remove(person);
        log.info("person-removed");
        return person;
    }

    @Transactional
    @Loggable
    public Person findById(Long id) {
        return entityManager.find(Person.class, id);

    }

    @Transactional
    @Loggable
    public List<Person> findAll() {
        Query query = entityManager.createQuery("select p from personEntity p", Person.class);
        return query.getResultList();
    }

    @Transactional
    @Loggable
    public List<Person> findByNationalId(String nationalId) {
        Query query = entityManager.createQuery("select p from personEntity p where p.nationalId = :nationalId", Person.class);
        query.setParameter("nationalId", nationalId);
        return query.getResultList();
    }

    @Transactional
    @Loggable
    public List<Person> findByName(String name) {
        Query query = entityManager.createQuery("select p from personEntity p where p.name like :name", Person.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Transactional
    @Loggable
    public List<Person> findByFirstNameAndLastName(String name, String family) {
        Query query = entityManager.createQuery("select p from  personEntity p where p.name = : name and p.family = : family", Person.class);
        query.setParameter("name", name);
        query.setParameter("family", family);
        return query.getResultList();
    }

    @Transactional  //todo
    @Loggable
    public Person findByUsernameAndPassword(String username, String password) {
        Query query = entityManager.createQuery("select p from  personEntity p where p.user.username = : username and p.user.password = : password", Person.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        if (userService.findByUsernameAndPassword(username, password) != null) {
            return (Person) query.getSingleResult();
        } else {
            log.error("person-not-found", new NoPersonException());
            return null;
        }
    }


    @Transactional
    @Loggable
    public Person findByUsername(String username) {
        Query query = entityManager.createQuery("select u.username from  userEntity u where u.username = :username", Person.class);
        query.setParameter("username", username);
        if (userService.findByUsername(username) != null) {
            return (Person) query.getSingleResult();
        } else {
            log.error("person-not-found", new NoPersonException());
            return null;
        }
    }

    @Transactional
    @Loggable
    public List<Person> findByPhoneNumber(String phoneNumber) {
        Query query = entityManager.createQuery("select p from  personEntity p where p.phoneNumber = :phoneNumber", Person.class);
        query.setParameter("phoneNumber", phoneNumber);
        return query.getResultList();

    }

    @Transactional
    @Loggable
    public List<Person> findByPostalCode(String postalCode) {
        Query query = entityManager.createQuery("select p from personEntity p where p.postalCode = :postalCode", Person.class);
        query.setParameter("postalCode", postalCode);
        return query.getResultList();
    }

    @Transactional
    @Loggable
    public List<Person> findByAddress(String address) {
        Query query = entityManager.createQuery("select p from personEntity p where p.address = :address", Person.class);
        query.setParameter("address", address);
        return query.getResultList();
    }

}
