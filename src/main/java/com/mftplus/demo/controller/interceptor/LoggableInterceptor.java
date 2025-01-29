package com.mftplus.demo.controller.interceptor;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import lombok.extern.slf4j.Slf4j;

@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
@Slf4j
public class LoggableInterceptor {
    @AroundInvoke
    public Object logMethodCall(InvocationContext context) throws Exception {
        try {
            log.info(String.format("Method %s Called +", context.getMethod().getName()));
            return context.proceed();
        } finally {
            log.info(String.format("Method %s Finished -", context.getMethod().getName()));
        }
    }
}
