package invoiceApplication;

import java.util.*;

public class Invoices {

	public static void main(String[] args) {

		String input; 
		double taxRate = 0.00; 
		double totalAmt = 0.00; 
		int counter = 0; 
		double taxCharged = 0.00; 
		double subtotal = 0.00; 

		Scanner scan = new Scanner(System.in); 
		
		ArrayList <Products> itemsToPurchase = new ArrayList <Products>();  
		
		String PROMPT = "Would you like to continue? Y or N";

		Products product;
		
		//loop starts here
		do {
			product  = new Products();
					
			System.out.println("Enter the name of your item: ");
			product.setName(scan.nextLine());  

			System.out.println("Enter the price of your item: ");
			product.setPrice(scan.nextDouble());
			
			/*System.out.println("Enter the description of your item: ");
			product.setDescription(scan.nextLine());*/
			
			itemsToPurchase.add(product); 
			scan.nextLine(); 
			
			System.out.println(PROMPT);
			input = scan.nextLine(); 

			if (!input.equalsIgnoreCase("n") && !input.equalsIgnoreCase("y")) {
				System.out.println("Invalid entry. Please enter 'y' or 'n' only!");
			}

		} while (input.equalsIgnoreCase("y") || !input.equalsIgnoreCase("n"));
				
		System.out.println("Enter the tax rate: "); 
		taxRate = scan.nextDouble(); 

				System.out.println("Thank you for ordering products with us."); 
		System.out.println("The list of items you purchased is below: ");

		for(Products item : itemsToPurchase) {
			System.out.println(item.getName() + " " + item.getPrice());
			subtotal += item.getPrice(); 
		}

		taxCharged = subtotal * taxRate; 
		totalAmt = subtotal + taxCharged;

		System.out.println("Tax Rate: " + taxRate);
		System.out.println("Tax Charged: " + taxCharged);
		System.out.println("Total Amount Due: " + totalAmt);

	scan.close();
	}

}
