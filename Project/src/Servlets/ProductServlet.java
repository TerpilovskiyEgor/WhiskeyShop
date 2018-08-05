package Servlets;

import DAO.JDBC;
import DAO.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        JDBC D = JDBC.getInstance();
        Product P = D.GetProduct(Long.parseLong(req.getParameter("ID")));
        req.setAttribute("Product", P);
        req.getRequestDispatcher("/WEB-INF/Pages/Product.jsp").forward(req, resp);
    }
}
