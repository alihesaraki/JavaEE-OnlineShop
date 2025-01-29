package com.mftplus.demo.controller.api;

import com.mftplus.demo.controller.interceptor.annotation.ResponseMaker;
import com.mftplus.demo.model.entity.Person;
import com.mftplus.demo.model.service.PersonService;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

@Path("/persons")
@Slf4j
public class PersonApi {
    @Inject
    private PersonService personService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker(authority = "GET_PERSONS")
    public Object getPerson() {
        log.info("Get-Admin Info");
        return personService.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker(authority = "GET_PERSON_BY_ID")
    public Object getPersonById(@PathParam("id") Long id) {
        return personService.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/nationalId/{nationalId}")
    @Loggable
    @ResponseMaker(authority = "GET_PERSON_BY_NATIONAL_ID")
    public Object getPersonByNationalId(@PathParam("nationalId") String nationalId) {
        return personService.findByNationalId(nationalId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/fullName/{fullName}")
    @Loggable
    @ResponseMaker(authority = "GET_PERSON_BY_FULL_NAME")
    public Object getPersonFullName(@PathParam("fullName") String fullName) {
        String[] parts = fullName.split(" ");
        if (parts.length == 2) {
            String name = parts[0];
            String family = parts[1];
            return personService.findByFirstNameAndLastName(name, family);
        } else {
            throw new IllegalArgumentException("input name & family !");
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/loginData/{loginData}")
    @Loggable
    @ResponseMaker(authority = "GET_PERSON_BY_LOGIN_DATA")
    public Object getPersonByUsernameAndPassword(@PathParam("loginData") String loginData) {
//        return personService.findByUsernameAndPassword(username, password);

        String[] parts = loginData.split(" ");
        if (parts.length == 2) {
            String username = parts[0];
            String password = parts[1];
            return personService.findByUsernameAndPassword(username, password);
        } else {
            throw new IllegalArgumentException("input username & password !");
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value = "/username/{username}")
    @ResponseMaker(authority = "GET_PERSON_BY_USERNAME")
    @Loggable
    public Object getPersonByUsername(@PathParam("username") String username) {
        return personService.findByUsername(username);
//        try {
//            return Response.ok().entity(personService.findByUsername(username)).build();
//        } catch (Exception e) {
//            log.error(e.getMessage());
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
//        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/phone/{phone}")
    @Loggable
    @ResponseMaker(authority = "GET_PERSON_BY_PHONE")
    public Object getPersonByPhoneNumber(@PathParam("phone") String phoneNumber) {
        return personService.findByPhoneNumber(phoneNumber);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/postCode/{postCode}")
    @Loggable
    @ResponseMaker(authority = "GET_PERSON_BY_POSTAL_CODE")
    public Object getPersonByPostalCode(@PathParam("postCode") String postalCode) {
        return personService.findByPostalCode(postalCode);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/address/{address}")
    @Loggable
    @ResponseMaker(authority = "GET_PERSON_BY_ADDRESS")
    public Object getPersonByAddress(@PathParam("address") String address) {
        return personService.findByAddress(address);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker(authority = "SAVE_PERSON")
    public Object addPerson(@Valid Person person) {
        personService.save(person);
        return person;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker(authority = "EDIT_PERSON")
    public Object updatePerson(@Valid Person person) {
        personService.edit(person);
        return person;
    }

    @DELETE
    @Path("{id}")
    @Loggable
    @ResponseMaker(authority = "DELETE_PERSON")
    //todo
    public Object deletePerson(@PathParam("id") Long id) {
        Person person = personService.remove(id);
        return person.getId();
//      return Response.ok().entity(id).build();
    }
}
