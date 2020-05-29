package controller.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String command = httpServletRequest.getParameter("command");

        String password = httpServletRequest.getParameter("password");
        String confirmPassword = httpServletRequest.getParameter("password_confirm");

        if (httpServletRequest.getMethod().equals("POST") && command.equals("registration")){
            if (!password.equals(confirmPassword)){
                String errorString = "Passwords do not match";
                httpServletRequest.setAttribute("errorString", errorString);
                httpServletRequest.getRequestDispatcher("/view/registrationView.jsp").forward(httpServletRequest, httpServletResponse);
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
