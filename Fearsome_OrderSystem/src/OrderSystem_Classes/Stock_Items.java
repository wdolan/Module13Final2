/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OrderSystem_Classes;

/**
 *
 * @author Bella Belova
 */
public class Stock_Items {
    
    private int ProductID;
    private String ProductName;
    private int StockQuantity;

    
    
    // Constructor
    
    public Stock_Items (int ProdID, String ProdName, int StockQty) {
        
        ProductID = ProdID;
        ProductName = ProdName;
        StockQuantity = StockQty;
    }
    
}
