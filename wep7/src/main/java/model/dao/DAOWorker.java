package model.dao;

import model.entity.Task;
import model.entity.Worker;
import model.exception.DAOException;
import model.exception.DBConnectionException;
import org.hibernate.jdbc.Work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOWorker extends DAO {
    private static final String SHOW_WORKERWITHRANK_SQL = "select * from  worker  where rank_of_worker = ?";

    public DAOWorker() throws Exception {
    }

    public List<Worker> showWorkersWithRank(int rank) throws DAOException {
        List<Worker> workers = new ArrayList<Worker>();
        Connection connection = null;
        try {
            connection = getDBConnection().getConnection();
            PreparedStatement stmt = connection.prepareStatement(SHOW_WORKERWITHRANK_SQL);
            stmt.setInt(1, rank);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int rank_of_worker = rs.getInt(3);
                Worker worker = new Worker(id, name, rank_of_worker);
                workers.add(worker);
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
        return workers;
    }
}
