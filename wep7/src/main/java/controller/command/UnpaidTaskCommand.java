package controller.command;

import model.dao.DAOTask;
import model.entity.Task;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UnpaidTaskCommand extends Command{
    final String urlPattern = "unpaidTasks";
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
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {
        String errorString = null;

        List<Task> list = null;
        try {
            list = (new DAOTask()).readUnpaidTasks();
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        request.setAttribute("errorString", errorString);
        request.setAttribute("unpaidTasks", list);

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/view/unpaidTasksView.jsp");
        dispatcher.forward(request, response);
    }
}
