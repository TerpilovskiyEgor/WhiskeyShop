package Servlets;

import DAO.JDBC;
import DAO.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EntranceServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session = req.getSession(true);
        if(session.getAttribute("UserName") == null)
        {
            req.getRequestDispatcher("/WEB-INF/Pages/Entrance.jsp").forward(req, resp);
        }
        else
        {
            if(req.getParameter("Out") != null)
            {
                session.setAttribute("UserName", null);
                session.setAttribute("UserID", null);
            }
            resp.sendRedirect("/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session = req.getSession(true);
        String Login = req.getParameter("Login");
        String Password = req.getParameter("Password");
        JDBC D = JDBC.getInstance();

        User U = D.GetUser(Login, Password);
        if(U == null)
        {
            req.setAttribute("Error", "Error");
            req.getRequestDispatcher("/WEB-INF/Pages/Entrance.jsp").forward(req, resp);
        }
        else
        {
            session.setAttribute("UserName", U.getName());
            session.setAttribute("UserID", U.getID());
            resp.sendRedirect("/");
        }
    }
}
