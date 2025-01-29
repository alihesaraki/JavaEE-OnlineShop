package com.mftplus.demo.controller.servlet;

import com.mftplus.demo.model.utils.Loggable;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@WebServlet(urlPatterns = "/order")
@Slf4j
public class OrderServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        log.info("Order-Servlet-init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Order-Servlet-service");
        super.service(req, resp);

    }


    @Override
    @Loggable
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("OrderServlet-doGet");
//        HttpSession session = req.getSession();
        req.getRequestDispatcher("/orderTest.html").forward(req, resp);

    }

    @Override
    public void destroy() {
        log.info("OrderServlet-destroy");
    }
}
