package controller.command;

import model.dao.DAOClient;
import model.dao.DAOTask;
import model.entity.Task;
import model.exception.DAOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientInfoCommand extends Command{
    final String urlPattern = "clientInfo";
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
        List<Task> list = new ArrayList<>();
        String errorString = null;

        request.setAttribute("errorString", errorString);
        request.setAttribute("clientTasks", list);
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/view/clientInfoView.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        int client_id = Integer.parseInt(request.getParameter("client_id"));
        String errorString = null;

        List<Task> list = null;
        try {
            list = (new DAOClient()).showClientInfo(client_id);
        } catch (DAOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("errorString", errorString);
        request.setAttribute("clientTasks", list);

        request.getRequestDispatcher("/view/clientInfoView.jsp").forward(request, response);
    }
}

