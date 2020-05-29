package controller.filter;

import controller.MainServlet;
import model.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandAccessFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("user");
        String command = httpServletRequest.getParameter("command");

        int userType = (user == null ? -1 : ((User)session.getAttribute("user")).getUser_type());
        int accessLevel = -1;
        try {
            accessLevel = MainServlet.commands.get(command).getAccessLevel();
        } catch (Exception ex){

        }
        if (userType < accessLevel){
            String errorString = "Access denied";
            httpServletRequest.setAttribute("errorString", errorString);
            httpServletRequest.getRequestDispatcher("/view/homeView.jsp")
                    .forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
