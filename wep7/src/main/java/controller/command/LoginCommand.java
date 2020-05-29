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

public class LoginCommand extends Command {
    final String urlPattern = "login";
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
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/view/loginView.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        if(request.getParameter("command").equals("login")){
            String errorString = "";
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            try {
                DAOUser daoUser = new DAOUser();
                if (!daoUser.isLoginValid(login)){
                    errorString = "Invalid login";
                } else {
                    User user = daoUser.getUserByLoginPass(login, password);
                    System.out.println(user);
                    if (user != null){
                        errorString = user.toString();

                        HttpSession session = request.getSession(true);
                        session.setAttribute("user", user);
                        //session.setAttribute("user_type", user.getUser_type());
                        request.getRequestDispatcher("/view/homeView.jsp").forward(request, response);
                    } else {
                        errorString = "Invalid password";
                    }
                }
            } catch (DAOException e) {

                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

            request.setAttribute("errorString", errorString);
            request.getRequestDispatcher("/view/loginView.jsp").forward(request, response);
        }
    }
}
