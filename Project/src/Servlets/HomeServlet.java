package Servlets;

import DAO.JDBC;
import DAO.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class HomeServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        JDBC D = JDBC.getInstance();
        ArrayList<Product> ArrayOfPopularProduct = D.GetFourPopular();
        req.setAttribute("ArrayOfPopularProduct", ArrayOfPopularProduct);
        req.getRequestDispatcher("/WEB-INF/Pages/Home.jsp").forward(req, resp);
    }
}
