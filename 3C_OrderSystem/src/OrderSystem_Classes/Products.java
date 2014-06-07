/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OrderSystem_Classes;

/**
 *
 * @author Bella Belova
 */
public class Products {
    
    private int ProductID;
    private int Category_ID;
    private String ProductName;
    private String ProductDescription;
    private float Price;

    


    // Constructor
    
    public Products (int ProdID, int CategID, String ProdName, String ProdDesc, float ProdPrice) {
        
        ProductID = ProdID;
        ProductName = ProdName;
        ProductDescription = ProdDesc;
        ProductDescription = ProdDesc;
        Price = ProdPrice;
    }
}
