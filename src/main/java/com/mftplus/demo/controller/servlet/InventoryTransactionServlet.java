package com.mftplus.demo.controller.servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import com.mftplus.demo.model.utils.Loggable;
import lombok.extern.slf4j.Slf4j;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/inventoryTrans")
@Slf4j

public class InventoryTransactionServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        log.info("InventoryTransactionServlet-init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("InventoryTransactionServlet-service");
        super.service(req, resp);
    }

    @Override
    @Loggable
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ServletException {

        log.info("InventoryTransactionServlet-doGet");
        req.getRequestDispatcher("/inventoryTransaction.html").forward(req, resp);
    }

    @Override
    public void destroy() {
        log.info("InventoryTransactionServlet-destroy");
    }
}


