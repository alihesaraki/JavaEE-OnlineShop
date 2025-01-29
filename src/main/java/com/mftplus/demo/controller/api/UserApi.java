package com.mftplus.demo.controller.api;

import com.mftplus.demo.controller.interceptor.annotation.ResponseMaker;
import com.mftplus.demo.model.entity.User;
import com.mftplus.demo.model.service.UserService;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

@Path("/users")
@Slf4j
public class UserApi {
    @Inject
    private UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker(authority = "GET_USERS")
    public Object getUsers() {
        log.info("get users");
        return userService.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    @Loggable
    @ResponseMaker(authority = "GET_USERS_BY_ID")
    public Object getUserById(@PathParam("id") Long id) {
        return userService.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/username/{username}")
    @Loggable
    @ResponseMaker(authority = "GET_USERS_BY_USERNAME")
    public Object getUserByUsername(@PathParam("username") String username) {
        return userService.findByUsername(username);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/password/{password}")
    @Loggable
    @ResponseMaker(authority = "GET_USERS_BY_PASSWORD")
    public Object getUserByPassword(@PathParam("password") String password) {
        return userService.findByPassword(password);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/loginData/{loginData}")
    @Loggable
    @ResponseMaker(authority = "GET_USERS_BY_USERNAME_AND_PASSWORD")
    public Object getUserByUsernameAndPassword(@PathParam("loginData") String loginData) {
        String[] parts = loginData.split(" ");
        if (parts.length == 2) {
            String username = parts[0];
            String password = parts[1];
            return userService.findByUsernameAndPassword(username, password);

//            return Response.ok().entity(userService.findByUsernameAndPassword(username, password)).build();
        } else {
            throw new IllegalArgumentException("input username && password !!");
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/email/{email}")
    @Loggable
    @ResponseMaker(authority = "GET_USERS_BY_EMAIL")
    public Object getUserByEmail(@PathParam("email") String email) {
        return userService.findByEmail(email);

        //        return Response.ok().entity(userService.findByEmail(email)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/role/{role}")
    @Loggable
    @ResponseMaker(authority = "GET_USERS_BY_ROLE")
    public Object getUserByRoleName(@PathParam("role") String roleName) {
        return userService.findByRoleName(roleName);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/perUser/{perUser}")
    @Loggable
    @ResponseMaker(authority = "GET_USERS_PERMISSION_BY_USERNAME")
    public Object getPermissionsByUsername(@PathParam("perUser") String username) {
        return userService.findPermissionsByUsername(username);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker(authority = "create_user")
    public Object addUser(@Valid User user) {
        userService.save(user);
        return user;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker(authority = "EDIT_USER")
    public Object updateUser(@Valid User user) {
        userService.edit(user);
        return user;
    }

    @DELETE
    @Path("{userRemove}")
    @Loggable
    @ResponseMaker(authority = "REMOVE_USER")
    //todo
    public Object deleteUser(@PathParam("userRemove") String username) {
        User user = userService.remove(username);
        return user.getId();
        //      return id;
//        return Response.ok().entity(id).build();
    }
}
