package com.mftplus.demo.controller.session;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    private static int visited;
    private static int online;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        visited++;
        online++;
        System.out.printf("session-created : {online:%s},{visited:%s}%n", visited, online);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        online--;
        System.out.printf("session-destroyed : {online:%s},{visited:%s}%n", visited, online);

    }
}
