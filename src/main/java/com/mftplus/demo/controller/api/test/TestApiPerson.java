package com.mftplus.demo.controller.api.test;

import com.mftplus.demo.model.entity.Permission;
import com.mftplus.demo.model.entity.Person;
import com.mftplus.demo.model.entity.Role;
import com.mftplus.demo.model.entity.User;
import com.mftplus.demo.model.entity.enums.Gender;
import com.mftplus.demo.model.service.PermissionService;
import com.mftplus.demo.model.service.PersonService;
import com.mftplus.demo.model.service.RoleService;
import com.mftplus.demo.model.service.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Path("/test-persons")
@Slf4j
public class TestApiPerson {
//    @Inject
//    private PersonService personService;
//
//    @GET
//    public String testApiPerson (){
//        log.info("get person test");
//        Permission permission = Permission.builder().permissionName("save").build();
//        Role role = Role.builder().roleName("ADMIN").permissionSet(Set.of(permission)).build();
//        User user = User.builder().email("jkljjk").password("123456").username("lili").roleList(List.of(role)).build();
//        Person person = Person.builder().name("kkk").family("hhh").address("dddd").birthDate(LocalDate.now()).gender(Gender.Female).nationalId("8520147096").user(user).build();
//        personService.save(person);
//        return personService.findAll().toString();
//    }

//    @Inject
//    private PermissionService permissionService;
//
//    @GET
//    public String testApiPermission () {
//        log.info("get permission test");
//        Permission permission = Permission.builder().permissionName("save").build();
//        permissionService.save(permission);
//        return permissionService.findAll().toString();
//    }

//    @Inject
//    private RoleService roleService;
//
//    @GET
//    public String testApiRole () {
//    log.info("get Role test");
//    Permission permission = Permission.builder().permissionName("save").build();
//    Role role = Role.builder().roleName("CUSTOMER").permissionSet(Set.of(permission)).build();
//    roleService.save(role);
//    return roleService.findAll().toString();}

    @Inject
    private UserService userService;

    @GET
    public String testApiUser () {
        log.info("get Role test");
        Permission permission = Permission.builder().permissionName("remove").build();
        Role role = Role.builder().roleName("staff").permissionSet(Set.of(permission)).build();
        User user = User.builder().email("opu").password("1020").username("bab").roleList(List.of(role)).build();
        userService.save(user);
        return userService.findAll().toString();}

}
