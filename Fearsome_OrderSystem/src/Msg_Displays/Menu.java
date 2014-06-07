/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Msg_Displays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Amy Roberts
 */
public class Menu {
	
	//variable which controls breaking back to main menu
	private static boolean returntomain = false;
	
	//variables to control loops and switches
	private static boolean repeat;
	private static String input;
	private static char choice;
	private static BufferedReader brin = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * Presents the main menu options.
	 */
	public static void main_menu()
	{
		System.out.println("Main menu:");
		System.out.println("1. Browse catalog");
		System.out.println("2. View shopping cart");
		System.out.println("3. Place order");
		System.out.println("X. Exit program\n");
		System.out.println("Please enter your selection: ");
	} //end main_menu
	
	/**
	 * Presents the full catalog for browsing and selection.
	 */
	public static void browse_menu()
	{
		returntomain = false;
		System.out.println("Full catalog:");
		
		//get all products
		//display all products
		//probably want an array of product objects for this
		
		System.out.println("M. Main menu");
		System.out.println("X. Exit program\n");
		System.out.println("Which product are you interested in? Please make a selection: ");
		
		//take user input and switch based on choice
		try
		{
			repeat = true;
			while(repeat = true) 
			{
				input = brin.readLine();
				input = input.toUpperCase();
				choice = input.charAt(0);
				
				System.out.println(choice);
				switch(choice)
				{
					case '1':
						
						//for cases 1-6, get product ID from the product object at the right place
						//in the array and pass to product_details()
						//product_details(prodID);
						break;
					case '2':
						
						break;
					case '3':
						
						break;
					case 'M':
						main_menu();
						repeat = false;
						returntomain = true;
						break;
					case 'X':
						System.out.println("Goodbye! Thank you for shopping with us!");
						repeat = false;
						System.exit(0);
						break;
					default:
						System.out.println("Sorry, invalid selection. Please select an option from the menu above: ");
				} //end switch
				
				if(returntomain == true)
				{
					return;
				} //end if
				
			} //end while loop
		} //end try
		catch (Exception e)
		{
			System.err.println("Error: " + e);
		} //end catch
	} //end browse_menu
	
	
	/**
	 * Presents the details on a specific product and allows selecting a quantity to order.
	 */
	public static void product_details(int prodID)
	{
		returntomain = false;
		System.out.println("Product details:");
		
		//reformat and display full product details
		
		System.out.println("C. Back to product catalog");
		System.out.println("M. Main menu");
		System.out.println("X. Exit program\n");
		System.out.println("Please enter how many of this product you would like to order, or make a menu selection.");
		System.out.println("What is your selection?");
	} //end product_details
	
	
	/**
	 * Presents the current cart.
	 */
	public static void view_cart()
	{
		returntomain = false;
		System.out.println("Your cart:");
		
		//display current cart, or "Your cart is empty" message
		
		System.out.println("P. Place order");
		System.out.println("M. Main menu");
		System.out.println("X. Exit program\n");
		System.out.println("Please select a line number to modify that item, or make a menu selection.");
		System.out.println("What is your selection?");
	} //end view_cart
	
	/**
	 * Presents the cart and begins the procedure to finalize an order.
	 */
	public static void place_order()
	{
		returntomain = false;
		System.out.println("Place order:");
		
		//display current cart
		
		System.out.println("1. Make changes to this order");
		System.out.println("2. Place this order");
		System.out.println("M. Main menu");
		System.out.println("X. Exit program\n");
		System.out.println("Please make a selection: ");
	} //end place_order
	
	/**
	 * Presents the shipping and billing addresses for confirmation and finalizes the order.
	 */
	public static void confirm_order()
	{
		returntomain = false;
		System.out.println("Confirm order:");
		
		//format billing/shipping addresses
		
		System.out.println("1. Place order");
		System.out.println("2. Correct this information (NOT YET IMPLEMENTED)");
		System.out.println("M. Main menu");
		System.out.println("X. Exit program\n");
		System.out.println("Please make a selection: ");
		
	} //end confirm_order

} //end menu class
