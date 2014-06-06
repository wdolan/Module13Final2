/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect;

/**
 *
 * @author Gregory
 */
public class MYSQL extends CommonConnection {
    
    
    private static final String jdbcDriver = "com.mysql.jdbc.Driver";
    private static final String connectionUrl = "jdbc:mysql://oak.safesecureweb.com:3306/nianbrandsco?zeroDateTimeBehavior=convertToNull";
    private static final String username = "store";
    private static final String password = "testDB1234!";
    private static java.sql.Connection mysqlConn;
    
    public MYSQL()
    {
        super(jdbcDriver, connectionUrl, username, password);
        CommonConnection.initialize();
        mysqlConn = super.getConnection();
    }

    public static java.sql.Connection getMSQLConn()
    {
        return mysqlConn;
    }
}
