/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OrderSystem_Classes;

/**
 *
 * @author Bella Belova
 */
public class OrderItems {
    
    private int OrderItemID;
    private int OrderID;
    private int ProductID;
    private int Quantity;
    
    public OrderItems (int OrdItemID, int OrdID, int ProdID, int Qty) {
        
        OrderItemID = OrdItemID;
        OrderID = OrdID;
        ProductID = ProdID;
        Quantity = Qty;
    }
    
}
