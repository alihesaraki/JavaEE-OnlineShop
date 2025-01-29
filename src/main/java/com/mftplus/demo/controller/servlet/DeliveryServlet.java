package com.mftplus.demo.controller.servlet;

import com.mftplus.demo.model.utils.Loggable;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@WebServlet(urlPatterns = "/delivery")
@Slf4j
public class DeliveryServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        log.info("DeliveryServlet-init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("DeliveryServlet-service");
        super.service(req, resp);

    }


    @Override
    @Loggable
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("DeliveryServlet-doGet");
//        HttpSession session = req.getSession();
        req.getRequestDispatcher("/deliveryTest.html").forward(req, resp);

    }

    @Override
    public void destroy() {
        log.info("DeliveryServlet-destroy");
    }
}
