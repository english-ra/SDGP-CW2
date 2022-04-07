package SDGP.GroupD.CW2.Database;

import SDGP.GroupD.CW2.Constants.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author natty
 */
public class ConnectDB {
    public static Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            String url = Constants.databaseURL;
            Connection conn = DriverManager.getConnection(url);
            //JOptionPane.showMessageDialog(null, "Connection Established");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

}

