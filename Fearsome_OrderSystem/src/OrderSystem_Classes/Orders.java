/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OrderSystem_Classes;

/**
 *
 * @author Gregory
 */
public class Orders {
    
    private int OrderID;
    private int CustomerID;
    private String Financial;
    private String OrderDate;
    
    // Constructor
    
    public Orders (int OrdID, int CustID, String Fin, String OrdDate) {
        
        OrderID     = OrdID;
        CustomerID  = CustID;
        Financial   = Fin;
        OrderDate   = OrdDate;
    }
}
