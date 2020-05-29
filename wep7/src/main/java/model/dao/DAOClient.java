package model.dao;

import model.entity.Task;
import model.exception.DAOException;
import model.exception.DBConnectionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOClient extends DAO{
    private static final String SHOW_CLIENTINFO_SQL = "select * from  task  where client_id = ?";


    public DAOClient() throws Exception {
    }

    public List<Task> showClientInfo(int client_id) throws DAOException {
        List<Task> technicalTasks = new ArrayList<Task>();
        Connection connection = null;
        try {
            connection = getDBConnection().getConnection();
            PreparedStatement stmt = connection.prepareStatement(SHOW_CLIENTINFO_SQL);
            stmt.setInt(1, client_id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int paid = rs.getInt(3);
                int rankNeeded = rs.getInt(4);
                int clientId = rs.getInt(5);
                int workerId = rs.getInt(6);
                Task technicalTask = new Task(id, clientId, workerId, name, paid, rankNeeded);
                technicalTasks.add(technicalTask);
            }
        } catch (SQLException e) {
            throw new DAOException("Read unpaid TechnicalTasks exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("Failed to get connection from db connector ", e);
        } finally {
            if (connection != null) {
                try {
                    getDBConnection().releaseConnection(connection);
                } catch (DBConnectionException | SQLException e) {
                    throw new DAOException("Failed to return connection to db connector ", e);
                }
            }
        }
        return technicalTasks;
    }
}
