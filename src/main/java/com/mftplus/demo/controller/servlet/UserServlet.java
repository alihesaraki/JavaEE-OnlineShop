package com.mftplus.demo.controller.servlet;

import com.mftplus.demo.model.utils.Loggable;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@WebServlet(urlPatterns = "/user")
@Slf4j
public class UserServlet extends HttpServlet {
    @Override
//    @Loggable
    public void init() throws ServletException {
        log.info("UserServlet-init");
    }

    @Override
    @Loggable
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("UserServlet-service");
        super.service(req, resp);

    }


    @Override
    @Loggable
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("UserServlet-doGet");
//        HttpSession session = req.getSession();
        req.getRequestDispatcher("/userTest.html").forward(req, resp);

    }

    @Override
    @Loggable
    public void destroy() {
        log.info("userServlet-destroy");
    }
}
