package model.dao;

import model.DBConnectorPool;
import model.exception.DAOException;
import model.exception.DBConnectionException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.SQLException;

/**
 * @author Mikita Ishchanka
 * @version 1.0.1
 */

/**
 * DAO class for working with DB
 */
public class DAO {
    private static String PERSISTENCE_UNIT_NAME = "Test_Local";
    private DBConnectorPool dbc;

    protected DBConnectorPool getDBConnection() throws SQLException {
        logger.info("requested to db connector");
        return dbc;
    }
    protected Logger logger = LogManager.getLogger("dao_layer");
    protected DAO() throws Exception {
        try {
            dbc = DBConnectorPool.getInstance();
            logger.info("Connection to database from dao inited");
        } catch (DBConnectionException e) {
            throw new DAOException("Can't create ConnectorPool ", e);
        }
    }
}
