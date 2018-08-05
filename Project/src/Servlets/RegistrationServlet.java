package Servlets;

import DAO.JDBC;
import DAO.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session = req.getSession(true);
        if(session.getAttribute("UserName") != null)
        {
            resp.sendRedirect("/");
        }
        else
        {
            req.getRequestDispatcher("/WEB-INF/Pages/Registration.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session = req.getSession(true);
        User U = new User(req.getParameter("Login"), req.getParameter("Password"),
                req.getParameter("Name"), req.getParameter("Surname"),
                req.getParameter("Email"));
        JDBC D = JDBC.getInstance();
        if(!D.CheckLoginDuplicate(U.getLogin()))
        {
            D.AddUser(U);
            session.setAttribute("UserName", U.getName());
            session.setAttribute("UserID", U.getID());
            resp.sendRedirect("/");
        }
        else
        {
            req.setAttribute("Error", "Error");
            req.getRequestDispatcher("/WEB-INF/Pages/Registration.jsp").forward(req, resp);
        }
    }
}
