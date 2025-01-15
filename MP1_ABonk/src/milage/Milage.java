package milage;

import java.util.Scanner;

public class Milage {

	public static void main(String[] args) {
		
		double numGallons; 
		double milesTraveled;
		//numGallons = 12.3;
		//milesTraveled = 300.0;
		//Homework started before I could do input, numbers used to be hardcoded.
		
		System.out.println("How many miles traveled? Enter as a double value:");
		Scanner scan = new Scanner(System.in);
		milesTraveled = scan.nextDouble();
		System.out.println("How much gas was used? Enter as a double value:");
		numGallons = scan.nextDouble();
		System.out.println("Your miles per gallon is: " + (milesTraveled/numGallons));

		scan.close();
	}

}
