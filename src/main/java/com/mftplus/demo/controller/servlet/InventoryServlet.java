package com.mftplus.demo.controller.servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import com.mftplus.demo.model.utils.Loggable;
import lombok.extern.slf4j.Slf4j;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/inventory")
@Slf4j
public class InventoryServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        log.info("InventoryServlet-init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("InventoryServlet-service");
        super.service(req, resp);

    }


    @Override
    @Loggable
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ServletException {

        log.info("InventoryServlet-doGet");
         req.getRequestDispatcher("/inventory.html").forward(req, resp);
     }


    @Override
    public void destroy() {
        log.info("InventoryServlet-destroy");
    }
}
