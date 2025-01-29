package com.mftplus.demo.controller.api;

import com.mftplus.demo.controller.interceptor.annotation.ResponseMaker;
import com.mftplus.demo.model.entity.Role;
import com.mftplus.demo.model.service.RoleService;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

@Path("/roles")
@Slf4j
public class RoleApi {
    @Inject
    private RoleService roleService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker(authority = "GET_ROLES")
    public Object getRoles() {
        log.info("get roles");
        return roleService.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    @Loggable
    @ResponseMaker(authority = "GET_ROLES_BY_ID")
    public Object getRoleById(@PathParam("id") Long id) {
        return roleService.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/type/{type}")
    @Loggable
    @ResponseMaker(authority = "GET_ROLES_BY_TYPE")
    public Object getRoleByName(@PathParam("type") String roleName) {
        return roleService.findByRoleName(roleName);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/permission/{permission}")
    @Loggable
    @ResponseMaker(authority = "GET_ROLES_BY_PERMISSION_NAME")
    public Object getRoleByPermissionName(@PathParam("permission") String permissionName) {
        return roleService.findByPermission(permissionName);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/username/{username}")
    @Loggable
    @ResponseMaker(authority = "GET_ROLES_BY_USERNAME")
    public Object getByUsername(@PathParam("username") String username) {
        return roleService.findByUsername(username);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker(authority = "SAVE_ROLE")
    public Object addRole(Role role) {
        roleService.save(role);
        return role;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker(authority = "EDIT_ROLE")
    public Object updateRole(@Valid Role role) {
        roleService.edit(role);
        return role;
    }

    @DELETE
    @Path("{id}")
    @ResponseMaker(authority = "REMOVE_ROLE")
    @Loggable
    //todo
    public Object deleteRole(@PathParam("id") Long id) {
        Role role = roleService.remove(id);
        return role.getId();

//        return Response.ok().entity(id).build();
    }
}
