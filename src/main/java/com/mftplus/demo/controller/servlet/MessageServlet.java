package com.mftplus.demo.controller.servlet;

import com.mftplus.demo.controller.websocket.MessageEndPoint;
import com.mftplus.demo.model.entity.Message;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/message.do")
public class MessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Message message = null;
//        MessageEndPoint.send(MessageEndPoint.allSessions.get(req.getSession()),message);
        req.getRequestDispatcher("/message.jsp").forward(req,resp);
    }
}
