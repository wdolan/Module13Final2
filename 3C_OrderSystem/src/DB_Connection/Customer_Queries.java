/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Connection;

/**
 *
 * @author Bella Belova
 */
public class Customer_Queries {
        public static class TableException extends Exception{
        TableException(String s){
            super(s);
        }
    }

    // Search table data
    public static java.util.ArrayList searchbyLASTNAME(String LAST_NAME)
            throws TableException{
        int id; String fn; String ln;
        java.sql.Statement stmt;
        Object p = null;
        java.util.ArrayList results = null;
        java.sql.ResultSet rs = null;
        
        try{
          String createString = "select * from " + Create_Tables.Customer_Table.CUSTOMER_TABLE_NAME + " where LastName like '%" + LAST_NAME + "%';" ;                
          stmt = Create_Tables.Customer_Table.sqlConn.createStatement();
          rs = stmt.executeQuery(createString);  
          results = new java.util.ArrayList();
            while (rs.next() == true)
                results.add(new OrderSystem_Classes.Customer (rs.getInt("CustomerID"), rs.getString("FirstName"), 
                        rs.getString("LastName"), rs.getInt("BillAddress"), rs.getInt("ShipAddress"), 
                        rs.getString("EmailAddress"), rs.getString("PhoneNumber")));  
        }catch (java.sql.SQLException e){
            throw new TableException("Unable to search Customer Table." + "\nDetail: " + e);
        }
        return results;
    }
}
