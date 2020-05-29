package controller.command;

import model.dao.DAOUser;
import model.entity.User;
import model.exception.DAOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogOutCommand extends Command {
    final String urlPattern = "logout";
    final int accessLevel = -1;

    @Override
    public int getAccessLevel() {
        return accessLevel;
    }
    @Override
    public String getPattern() {
        return urlPattern;
    }


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        if(request.getParameter("command").equals("logout")){
            HttpSession session = request.getSession(true);
            session.setAttribute("user",null);
            //session.setAttribute("user_type", -1);

            request.getRequestDispatcher("/view/homeView.jsp").forward(request, response);
        }
    }


}
