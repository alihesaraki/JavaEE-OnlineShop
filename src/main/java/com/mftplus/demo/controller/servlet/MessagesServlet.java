package com.mftplus.demo.controller.servlet;

import com.mftplus.demo.model.utils.Loggable;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@WebServlet(urlPatterns = "/messages")
@Slf4j
public class MessagesServlet extends HttpServlet {
    @Override
    @Loggable
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Message-Servlet-doGet");
//        HttpSession session = req.getSession();
        req.getRequestDispatcher("/messageTest.html").forward(req, resp);

    }
}
