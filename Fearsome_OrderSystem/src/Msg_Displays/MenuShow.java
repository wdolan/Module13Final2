/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Msg_Displays;
import Create_Tables.Address_Table;
import Create_Tables.Items_Table;
import Create_Tables.Orders_Table;
import DB_Connection.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Bella Belova
 */
public class MenuShow {
boolean repeat_choice;
String input_line;
char choice_symbol;
DataLoad  data_load;

public MenuShow()
{
    
}

public void MenuRun() throws Address_Table.TableException, Orders_Table.TableException, Items_Table.TableException
{
    data_load = new DataLoad();
    data_load.load_data();
   
    repeat_choice = false;
    while(repeat_choice == false)
    {
       print_menu(); 
       try {
           BufferedReader brin = new BufferedReader(new InputStreamReader(System.in));
           input_line = brin.readLine(); 
           choice_symbol = input_line.charAt(0);
           switch(choice_symbol)
           {
            case '1':   // Search by Product ID 
            //        System.out.println("Enter Product ID :  ");
                    
              //      DB_Connection.Product_Queries.searchbyProductID(input_line);
                    
                    repeat_choice = false;
                    break;
            case '2':           // Select ALL from Product Table
             //   DB_Connection.Product_Queries.searchALLProducts();
                    repeat_choice = false;
                    break;
            case '3':
                
                    repeat_choice = false;
                    break;
            case '4':
                
                    repeat_choice = false;
                    break;
            case '5':
                
                    repeat_choice = false;
                    break;
            case '6':
                
                    repeat_choice = false;
                    break;
            case '7':
                    repeat_choice = true;
                    System.out.println("Good Bye...\n");
                    break;
                
            default:
                    System.out.println("This choice is not supported\n");
                    repeat_choice = false;
                    break;
           }
         } //end try
         catch (Exception e) 
         {
            System.out.println("Error occurred: " + e);
         }
    }
  }
  public void print_menu()
  {
    System.out.println("Welcome");
    System.out.println("1.Search product");
    System.out.println("2.Browse entire catalog");
    System.out.println("3.View shopping cart");
    System.out.println("4.Place order");
    System.out.println("5.Modify / Cancel existing Order");
    System.out.println("6.Search by Order Number: ");
    System.out.println("7.Exit ");  
  }
}