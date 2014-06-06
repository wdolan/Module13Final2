/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect;

/**
 *
 * @author Bella Belova
 */
public class SQL extends CommonConnection {
    
    private static java.sql.Connection sqlConn = null;
    private static final String jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
    private static final String connectionUrl = "jdbc:sqlserver://localhost";
    private static final String username = "sa";
    private static final String password = "password";
    
    public SQL()
    {
        super(jdbcDriver, connectionUrl, username, password);
        CommonConnection.initialize();
        sqlConn = super.getConnection();
    }
    
    public  static  java.sql.Connection getSQLConn()
    {
        return sqlConn;
    }

}
