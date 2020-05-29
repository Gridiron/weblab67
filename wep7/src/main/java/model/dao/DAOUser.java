package model.dao;

import model.entity.Task;
import model.entity.User;
import model.exception.DAOException;
import model.exception.DBConnectionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOUser extends DAO{
    private static final String SHOW_GETALLUSERS_SQL = "select * from user";
    private static final String SHOW_ISLOGINVALID_SQL = "select * from  user where login = ?";
    private static final String SHOW_GETUSERBYLOGINPASS_SQL = "select * from  user where login = ? and password = ?";
    private static final String SHOW_INSERTUSER_SQL = "insert into user (type, login, password) values(?,?,?)";

    /**
     * Creates DAO class
     */
    public DAOUser() throws Exception {
    }


    /**
     * Returns all users from database
     * */
    public List<User> getAllUsers() throws DAOException {
        List<User> users = new ArrayList<User>();
        Connection connection = null;
        try {
            connection = getDBConnection().getConnection();
            PreparedStatement stmt = connection.prepareStatement(SHOW_GETALLUSERS_SQL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int type= rs.getInt(2);
                String login = rs.getString(3);
                String password = rs.getString(4);
                User user = new User(id, type, login, password);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new DAOException("Read users exception ", e);
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
        return users;
    }

    /**
     * Checks if user's login valid
     * */
    public boolean isLoginValid(String login) throws DAOException {
        Connection connection = null;
        try {
            connection = getDBConnection().getConnection();
            PreparedStatement stmt = connection.prepareStatement(SHOW_ISLOGINVALID_SQL);
            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();
            int i=0;
            while (rs.next()) {
                i++;
            }
            if(i==0){
                return false;
            }
            else {
                return true;
            }
        } catch (SQLException e) {
            throw new DAOException("Read users exception ", e);
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
    }

    /**
     * Returns user by login and password or null if cridentials are not valid
     * */
    public User getUserByLoginPass(String login, String password) throws DAOException {
        Connection connection = null;
        try {
            connection = getDBConnection().getConnection();
            PreparedStatement stmt = connection.prepareStatement(SHOW_GETUSERBYLOGINPASS_SQL);
            stmt.setString(1, login);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            User user = null;
            while (rs.next()) {
                int id = rs.getInt(1);
                int type= rs.getInt(2);
                user = new User(id, type, login, password);
            }
            return user;

        } catch (SQLException e) {
            throw new DAOException("Read users exception ", e);
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
    }

    /**
     * Inserts user to database
     * */
    public void insertUser(User user) throws DAOException {
        List<Task> technicalTasks = new ArrayList<Task>();
        Connection connection = null;
        try {
            connection = getDBConnection().getConnection();
            PreparedStatement stmt = connection.prepareStatement(SHOW_INSERTUSER_SQL);
            stmt.setInt(1, user.getUser_type());
            stmt.setString(2, user.getLogin());
            stmt.setString(3, user.getPassword());
            stmt.execute();
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
    }
}
