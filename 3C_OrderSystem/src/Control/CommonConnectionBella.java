/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author Bella Belova
 */
public class CommonConnectionBella {

    /**
     *
     */
    public static java.sql.Connection sqldbConn;

    /**
     *
     */
    public static java.sql.Connection mysqldbConn;
    private static String jdbcDriver;
    private static String connectionUrl;
    private static String username;
    private static String password;
    boolean sql_flag;
    
    /**
     * Common connection call that will open a given connection based on boolean input
     * If passed a true it will open a SQL connection and now save to a local variable sqldbConn
     * If passed anything other then true will open and save a MySQL to local variable mysqldbConn
     *
     * @param sql_flag_a true to open sql or false to open mysql
     */
    public void CommonConnection(boolean sql_flag_a)
    {
        sql_flag = sql_flag_a;
        
        if(sql_flag == true)
        {   //SQL
            jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            connectionUrl = "jdbc:sqlserver://localhost";
            username = "sa";
            password = "password";
        }
        else
        {   //MYSQL
            jdbcDriver = "com.mysql.jdbc.Driver";
            connectionUrl = "jdbc:mysql://oak.safesecureweb.com:3306/nianbrandsco?zeroDateTimeBehavior=convertToNull";
            username = "store";
            password = "testDB1234!";
        }    
        initialize();    
    }
    
    /**
     * Function called that is common to open either or from the CommonConnection() call.
     */
    public void initialize()
    {
        try{
            Class.forName(jdbcDriver);
            
            //If it is a true will open and save the sql connection to foriegn DB
            if(sql_flag == true)
            {
                try
                {
                    sqldbConn = java.sql.DriverManager.getConnection(connectionUrl,username, password);
                }
                catch (java.sql.SQLException e){System.err.println(e); }
            }//End if
            
            //If it is a true will open and save the sql connection to local DB
            if(sql_flag != true)
            {
                try
                {
                    mysqldbConn = java.sql.DriverManager.getConnection(connectionUrl,username, password);
                }
                catch (java.sql.SQLException e){System.err.println(e); }
            }//End if
        }catch(ClassNotFoundException e){
            System.err.println(e);
        }
    }

    /**
     * Function that would return an open connection.
     * If using global public variables to have two open connections
     * this is then not needed.
     * @return
     */
    /*public java.sql.Connection getConnection()
    {
        return dbCon;
    }*/
}