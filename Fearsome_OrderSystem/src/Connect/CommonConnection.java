/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect;

/**
 *
 * @author Gregory
 */
public class CommonConnection {

    private static java.sql.Connection dbCon = null;
    private static String jdbcDriver;
    private static String connectionUrl;
    private static String username;
    private static String password;
    
    
    CommonConnection(String jdbcDriver_assign, String connectionUrl_assign,String username_assign, String password_assign)
    {
        jdbcDriver = jdbcDriver_assign;
        connectionUrl = connectionUrl_assign;
        username = username_assign;
        password = password_assign;        
    }
    
    public static void initialize()
    {
        try{
            Class.forName(jdbcDriver);
            
            try{
                dbCon = java.sql.DriverManager.getConnection(connectionUrl,username, password);
            } catch (java.sql.SQLException e){System.err.println(e); }
        }catch(ClassNotFoundException e){
            System.err.println(e);
        }
    }
    java.sql.Connection getConnection()
    {
        return dbCon;
    }
}
