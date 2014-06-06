/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Connection;

import Create_Tables.*;
/**
 *
 * @author Bella Belova
 */
public class DataLoad {
    Address_Table address_data;
    Customer_Table customer_data;
    Items_Table item_order_data;
    Orders_Table orders_data;
    Product_Table product_data;
    Stock_Items_Table stock_item_data;
    int max_index;
    int index;

    public DataLoad()
    {
        address_data = new Address_Table();
        customer_data = new Customer_Table();
        item_order_data = new Items_Table();
        orders_data = new Orders_Table();
        product_data = new Product_Table();
        stock_item_data = new Stock_Items_Table();
    }
    
    public void load_data() throws Address_Table.TableException, Items_Table.TableException, Orders_Table.TableException
    {
        /*
    Tables create:
    
    Address;
    Customer;
    Item;
    order;
    Product;
    Stock_Items;
            
  */
// Customer Table
        try {
            customer_data.reset();
            customer_data.createCustomer(10005, "John", "Smith", 1, 2, "bb248141@yahoo.com", "(718)698-9852", 77777 );
            customer_data.createCustomer(10012, "Adam", "Sandler", 1, 2, "sy896325@hotmail.com", "(212)569-7896", 77712 );
            java.util.ArrayList results  = customer_data.getAllCustomers();
            max_index = results.size();
            System.out.println("Customer Table:\n");
            for(index = 0; index < max_index; index++)
            {
                System.out.println(results.get(index));
            }
        }catch (Exception Customer){                    // Renamed "e" to "Customer" for clearly define where the error is
            System.err.println(Customer);
        }
        
        
        try {
        // Address Table
            address_data.reset();
            address_data.createAddress(1, 10005, "home", "45 Jewett St", "Address2", "Brooklyn", "NY", 10314);
            address_data.createAddress(2, 10012, "home","7A Rockland Ave", "Address2", "New York", "NY", 10003);
            java.util.ArrayList results  = address_data.getAllAddresses();
            max_index = results.size();
            System.out.println("Address Table:\n");
            for(index = 0; index < max_index; index++)
            {
                System.out.println(results.get(index));
            }
        }catch (Exception Address){                    // Renamed "e" to "Address" for clearly define where the error is
            System.err.println(Address);
        }

                // Order Table
        try {
            orders_data.reset();
            orders_data.createOrder(77777, 10005, "1234567812348965", "12/27/2005");
            orders_data.createOrder(77712, 10012, "7896123645691025", "5/14/1998");
            java.util.ArrayList results  = orders_data.getAllOrders();
            max_index = results.size();
            System.out.println("Order Table:\n");
            for(index = 0; index < max_index; index++)
            {
                System.out.println(results.get(index));
            }
        }catch (Exception Orders){                    // Renamed "e" to "Order" for clearly define where the error is
            System.err.println(Orders);
        }

        // Item Table
        try {
            item_order_data.reset();
            item_order_data.createItems(12, 77777, 7896, 2);
            item_order_data.createItems(78, 77712, 7589, 6);
            java.util.ArrayList results  = item_order_data.getAllItems();
            max_index = results.size();
            System.out.println("Items Table:\n");
            for(index = 0; index < max_index; index++)
            {
                System.out.println(results.get(index));
            }
        }catch (Exception Items){                    // Renamed "e" to "Order Items" for clearly define where the error is
            System.err.println(Items);
        }

        // Stock Items
        try {
            stock_item_data.reset();
            stock_item_data.createOrder(7896, "hat", 8);
            stock_item_data.createOrder(7589, "gloves", 12);
            java.util.ArrayList results  = stock_item_data.getAllStocks();
            max_index = results.size();
            System.out.println("Stock Items Table:\n");
            for(index = 0; index < max_index; index++)
            {
                System.out.println(results.get(index));
            }
        }catch (Exception Stocks){                    // Renamed "e" to "Stock Items" for clearly define where the error is
            System.err.println(Stocks);
        }
 
        
        
        // Product
        try {
            product_data.reset();
            product_data.createOrder(7896, 12, "hat", "red had", 1.25f);
            product_data.createOrder(7589, 78, "gloves", "white gloves", 5.99f);
            java.util.ArrayList results  = product_data.getAllProducts();
            max_index = results.size();
            System.out.println("Product Table:\n");
            for(index = 0; index < max_index; index++)
            {
                System.out.println(results.get(index));
            }
        }catch (Exception Products){                    // Renamed "e" to "Customer" for clearly define where the error is
            System.err.println(Products);
        }
}
}