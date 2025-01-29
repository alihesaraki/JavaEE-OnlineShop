package com.mftplus.demo.controller.servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import com.mftplus.demo.model.utils.Loggable;
import lombok.extern.slf4j.Slf4j;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/inventoryPro")
@Slf4j
public class InventoryProductServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        log.info("InventoryProductServlet-init");
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("InventoryProductServlet-service");
        super.service(req, resp);

    }

    @Override
    @Loggable
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ServletException {

        log.info("InventoryProductServlet-doGet");
        req.getRequestDispatcher("/inventoryProduct.html").forward(req, resp);
    }

    @Override
    public void destroy() {
        log.info("InventoryProductServlet-destroy");
    }
}

