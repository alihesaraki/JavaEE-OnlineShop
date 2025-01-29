//package com.mftplus.demo.controller.api.test;
//
//import com.mftplus.demo.model.entity.Permission;
//import com.mftplus.demo.model.entity.Person;
//import com.mftplus.demo.model.entity.Role;
//import com.mftplus.demo.model.entity.User;
//import com.mftplus.demo.model.entity.enums.Gender;
//import com.mftplus.demo.model.service.PersonService;
//import com.mftplus.demo.model.service.RoleService;
//import com.mftplus.demo.model.service.UserService;
//import jakarta.inject.Inject;
//import jakarta.ws.rs.*;
//import jakarta.ws.rs.core.MediaType;
//import jakarta.ws.rs.core.Response;
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.List;
//
//@Slf4j
//@Path("/mobina_test")
//
//public class TestApiMobina {
//    @Inject
//    private PersonService personService;
//
//    @Inject
//    private UserService userService;
//
//    @Inject
//    private RoleService roleService;
//
//
//    @GET
//    public String test() {
//
//        log.info("test");
//        Permission permission = Permission.builder().permissionName("admin").build();
//
//        Role role = Role.builder().permission(List.of(permission)).roleName("admin").build();
////        roleService.save(role);
//
//        User user = User.builder().roleList(List.of(role)).username("mmm").password("1234565").email("www.az.com").build();
////        userService.save(user);
//
//        Person person = Person.builder().user(user).name("mobina").family("aaa").address("tehran").gender(Gender.Female).build();
//       personService.save(person);
//        person.setId(1L);
//        person.setFamily("azimi");
//        personService.edit(person);
//
//        return person.toString();
//    }
//    @PUT
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public String updatePerson(Person person){
//       person.setId(1L);
//       person.setFamily("azimi");
//       personService.edit(person);
//       return person.toString();
//    }
//    @GET
//    @Path(value = "{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getPerson(@PathParam("id") Long id) {
//        return Response.ok(personService.findById(id)).build();
//
//    }
//
//    @GET
//    @Path( "/username/{username}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getPerson(@PathParam("username") String username) {
//        try {
//            return Response.ok(personService.findByUsername(username)).build();
//        }catch (Exception e){
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
//        }
//
//    }
//
//}
