package Servlets;

import DAO.JDBC;
import DAO.Product;
import jdk.nashorn.internal.scripts.JD;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BasketServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session = req.getSession(true);
        if(session.getAttribute("UserCartList") != null)
        {
            JDBC D = JDBC.getInstance();
            ArrayList<Product> L = D.GetProducts((ArrayList<Long>)session.getAttribute("UserCartList"));
            req.setAttribute("List", L);
        }
        req.getRequestDispatcher("/WEB-INF/Pages/Basket.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session = req.getSession(true);
        ArrayList<Long> L = new ArrayList<>();
        switch(req.getParameter("SetDel"))
        {
            case "1":
                if(session.getAttribute("UserCartList") != null)
                {
                    L = (ArrayList<Long>) session.getAttribute("UserCartList");
                }
                L.add(Long.valueOf(req.getParameter("ProductID")));

                System.out.println(req.getParameter("ProductID"));

                session.setAttribute("UserCartList", L);
                break;

            case "2":
                L = (ArrayList<Long>) session.getAttribute("UserCartList");
                L.remove(Long.valueOf(req.getParameter("ProductID")));
                session.setAttribute("UserCartList", L);
                break;
        }
        System.out.println();
        resp.sendRedirect("/shop/basket");
    }
}
