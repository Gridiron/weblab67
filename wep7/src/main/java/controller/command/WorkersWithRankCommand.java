package controller.command;

import model.dao.DAOClient;
import model.dao.DAOTask;
import model.dao.DAOWorker;
import model.entity.Task;
import model.entity.Worker;
import model.exception.DAOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WorkersWithRankCommand extends Command{
    final String urlPattern = "workersWithRank";
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
        List<Worker> list = new ArrayList<>();
        String errorString = null;

        request.setAttribute("errorString", errorString);
        request.setAttribute("workersWithRank", list);
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/view/workersWithRankView.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        int rank = Integer.parseInt(request.getParameter("rank"));
        String errorString = null;

        List<Worker> list = null;
        try {
            list = (new DAOWorker()).showWorkersWithRank(rank);
        } catch (DAOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("errorString", errorString);
        request.setAttribute("workersWithRank", list);

        request.getRequestDispatcher("/view/workersWithRankView.jsp").forward(request, response);
    }
}
