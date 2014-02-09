/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbperson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fmi
 */
public class DBUtil {
    static Connection connected = null;
   
    static Connection getConnected(){
        try {
            Class.forName("org.h2.Driver");
            connected = DriverManager.getConnection("jdbc:h2:~/test","sa","");
            return connected;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connected;
    }
}
