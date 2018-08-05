package Filters;

import javax.servlet.*;
import java.io.IOException;

public class ShopServletFilter implements Filter
{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    { }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException
    {
        String FilterString = "";
        if(req.getParameter("Price") != null | req.getParameter("Year") != null |
                req.getParameter("Stars") != null | req.getParameter("Country") != null |
                req.getParameter("Scope") != null | req.getParameter("VoL") != null)
        {
            FilterString += "WHERE ";
        }


        if(req.getParameter("Price") != null)
        {
            if(!FilterString.equals("WHERE "))
            {
                FilterString += " AND ";
            }
            FilterString += "Price = "+ req.getParameter("Price") +"";
        }
        if(req.getParameter("Year") != null)
        {
            if(!FilterString.equals("WHERE "))
            {
                FilterString += " AND ";
            }
            FilterString += "Year="+ req.getParameter("Year") +"";
        }
        if(req.getParameter("Stars") != null)
        {
            if(!FilterString.equals("WHERE "))
            {
                FilterString += " AND ";
            }
            FilterString += "Stars = "+ req.getParameter("Stars") +"";
        }
        if(req.getParameter("Country") != null)
        {
            if(!FilterString.equals("WHERE "))
            {
                FilterString += " AND ";
            }
            FilterString += "Country = '"+ req.getParameter("Country") +"'";
        }
        if(req.getParameter("Scope") != null)
        {
            if(!FilterString.equals("WHERE "))
            {
                FilterString += " AND ";
            }
            FilterString += "Scope = "+ req.getParameter("Scope") +"";
        }
        if(req.getParameter("VoL") != null)
        {
            if(!FilterString.equals("WHERE "))
            {
                FilterString += " AND ";
            }
            FilterString += "VoL = "+ req.getParameter("VoL") +"";
        }

        if(req.getParameter("Sort") != null)
        {
            FilterString += "ORDER BY "+ req.getParameter("Sort") +" DESC";
        }

        System.out.println(FilterString);
        req.setAttribute("FilterString", FilterString);
        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy()
    { }
}
