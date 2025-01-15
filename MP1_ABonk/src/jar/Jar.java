package jar;

import java.util.Scanner;

public class Jar {

	public static void main(String[] args) {

		int quarterValue = 25;
		int dimeValue = 10;
		int nickelValue =  5;
		int pennyValue = 1;
		int quarterAmount;
		int dimeAmount;
		int nickelAmount;
		int pennyAmount;
		int totalValue;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("How many quarters are in the jar? ");
		quarterAmount = scan.nextInt();
		System.out.print("How many dimes are in the jar? ");
		dimeAmount = scan.nextInt();
		System.out.print("How many nickels are in the jar? ");
		nickelAmount = scan.nextInt();
		System.out.print("How many pennies are in the jar? ");
		pennyAmount = scan.nextInt();
		totalValue = (quarterValue*quarterAmount) + (dimeValue*dimeAmount) + (nickelValue*nickelAmount) + (pennyValue*pennyAmount);
		System.out.println("");
		System.out.println("The jar contains " + totalValue + " cents.");
		
		scan.close();
		//I know I don't have to close the scanner, but I don't like how the yellow line looks

	}

}
