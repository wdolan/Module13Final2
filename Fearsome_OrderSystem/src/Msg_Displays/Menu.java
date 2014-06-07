/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Msg_Displays;

/**
 *
 * @author Amy Roberts
 */
public class Menu {
	
	public static void main_menu()
	{
		System.out.println("Main menu:");
		System.out.println("1. Browse catalog");
		System.out.println("2. View shopping cart");
		System.out.println("3. Place order");
		System.out.println("X. Exit program\n");
		System.out.println("Please enter your selection: ");
	} //end main_menu
	
	public static void browse_menu()
	{
		System.out.println("Full catalog:");
		
		//get all products
		//display all products
		
		System.out.println("M. Main menu");
		System.out.println("X. Exit program\n");
		System.out.println("Which product are you interested in? Please make a selection: ");
	} //end browse_menu
	
	public static void product_details()
	{
		System.out.println("Product details:");
		
		//reformat and display full product details
		
		System.out.println("C. Back to product catalog");
		System.out.println("M. Main menu");
		System.out.println("X. Exit program\n");
		System.out.println("Please enter how many of this product you would like to order, or make a menu selection.");
		System.out.println("What is your selection?");
	} //end product_details
	
	public static void view_cart()
	{
		System.out.println("Your cart:");
		
		//display current cart, or "Your cart is empty" message
		
		System.out.println("M. Main menu");
		System.out.println("X. Exit program\n");
		System.out.println("Please select a line number to modify that item, or make a menu selection.");
		System.out.println("What is your selection?");
	} //end view_cart
	
	public static void place_order()
	{
		System.out.println("Place order:");
		
		//display current cart
		
		System.out.println("1. Make changes to this order");
		System.out.println("2. Place this order");
		System.out.println("M. Main menu");
		System.out.println("X. Exit program\n");
		System.out.println("Please make a selection: ");
	} //end place_order
	
	public static void confirm_order()
	{
		System.out.println("Confirm order:");
		
		//format billing/shipping addresses
		
		System.out.println("1. Place order");
		System.out.println("2. Correct this information (NOT YET IMPLEMENTED)");
		System.out.println("M. Main menu");
		System.out.println("X. Exit program\n");
		System.out.println("Please make a selection: ");
		
	} //end confirm_order

} //end menu class
