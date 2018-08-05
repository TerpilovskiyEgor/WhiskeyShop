package Servlets;

import DAO.JDBC;
import DAO.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OfficeServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session = req.getSession(true);
        if(session.getAttribute("UserName") != null)
        {
            JDBC D = JDBC.getInstance();
            User U = D.GetUser((long)session.getAttribute("UserID"));
            req.setAttribute("User", U);
            req.getRequestDispatcher("/WEB-INF/Pages/Office.jsp").forward(req, resp);
        }
        else
        {
            resp.sendRedirect("/registration");
        }
    }
}
