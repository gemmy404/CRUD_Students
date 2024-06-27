package listener;

import data.ConnManiDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ConnectionDB implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ConnManiDB cmdb = new ConnManiDB();
        Connection connection = null;
        try {
            connection = cmdb.connect();
            sce.getServletContext().setAttribute("dbConnection", connection);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Connection connection = (Connection) sce.getServletContext().getAttribute("dbConnection");
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
