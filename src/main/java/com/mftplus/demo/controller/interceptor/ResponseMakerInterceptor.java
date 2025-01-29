package com.mftplus.demo.controller.interceptor;

import com.mftplus.demo.controller.interceptor.annotation.ResponseMaker;
import com.mftplus.demo.model.entity.Permission;
import com.mftplus.demo.model.service.UserService;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jakarta.security.enterprise.SecurityContext;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.Response;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ResponseMaker
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class ResponseMakerInterceptor {
    @Inject
    private SecurityContext securityContext;

    @Inject
    private UserService userService;

    @AroundInvoke
    public Object responseMaker(InvocationContext context) throws Exception {
        try {
            String authority = context.getMethod().getAnnotation(ResponseMaker.class).authority();
            if (!authority.equals("")) {
                String username = securityContext.getCallerPrincipal().getName();
                Set<Permission> permissionSet = userService.findPermissionsByUsername(username);
                if (permissionSet != null && permissionSet.contains(authority)) {
                    Object result = context.proceed(); //when the method is calling!
                    if (context.getMethod().getAnnotation(POST.class) != null) {
                        return Response.status(Response.Status.CREATED).entity(result).build();
                    }
                    if (result == null || result instanceof List<?> && ((List<?>) result).isEmpty()) {
                        return Response.noContent().build();
                    }
//            return Response.ok(result).build();
                    if (context.getMethod().getAnnotation(DELETE.class) != null) {
                        return Response.noContent().build();
                    }
                    return Response.ok(result).build();
                } else {
                    throw new AccessDeniedException("You Have Not Access To This Method !!!");
                }
            }
            return Response
                    .status(Response.Status.FORBIDDEN)
                    .entity(Map.of("Error-Type :", "AUTHORITY", "Message :", "You Have Not Access To This Method !!!"))
                    .build();
        } catch (
                Throwable e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Map.of("Error-Type :", e.getClass(), "Message :", e.getMessage()))
                    .build();
        }
    }
}
