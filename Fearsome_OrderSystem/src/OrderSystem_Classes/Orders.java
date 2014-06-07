/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OrderSystem_Classes;

/**
 *
 * @author Bella Belova
 */
public class Orders {
    
    private int OrderID;
    private int CustomerID;
    private String Financial;
    private String OrderDate;
    private float OrderTotal;
    
    // Constructor
    
    public Orders (int OrdID, int CustID, String Fin, String OrdDate, float OrdTotal) {
        
        OrderID     = OrdID;
        CustomerID  = CustID;
        Financial   = Fin;
        OrderDate   = OrdDate;
        OrderTotal  = OrdTotal;
        
    }
}
