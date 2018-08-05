package Servlets;

import DAO.JDBC;
import DAO.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ShopServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        JDBC D = JDBC.getInstance();
        ArrayList<Product> L = D.GetProducts((String) req.getAttribute("FilterString"));
        req.setAttribute("List",L );
        req.getRequestDispatcher("/WEB-INF/Pages/Shop.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
    }
}
