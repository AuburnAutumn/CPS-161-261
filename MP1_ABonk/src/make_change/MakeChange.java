package make_change;

import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		
		int priceDollar;
		int priceCents;
		int totalPrice;
		int dollarsPaid; 
		int centsPaid;
		int totalPaid;
		int moneyLeft;
		
		int dollarValue = 100;
		int quarterValue = 25;
		int dimeValue = 10;
		int nickelValue = 5;
		//int pennyValue = 1;
		//I didn't end up using this variable since it was literally just dividing by one. 
		
		int dollarAmount;
		int quarterAmount;
		int dimeAmount;
		int nickelAmount;
		int pennyAmount;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter price dollars: ");
		priceDollar = scan.nextInt();
		System.out.println("Enter price cents: ");
		priceCents = scan.nextInt();
		System.out.println();
		System.out.println("Enter dollars received: ");
		dollarsPaid = scan.nextInt();
		System.out.println("Enter cents received: ");
		centsPaid = scan.nextInt();
		System.out.println();
		totalPrice = (priceDollar*100) + priceCents;
		totalPaid = (dollarsPaid*100) + centsPaid;
		moneyLeft = totalPaid - totalPrice;
		dollarAmount = moneyLeft/dollarValue;
		moneyLeft = moneyLeft%dollarValue;
		quarterAmount = moneyLeft/quarterValue;
		moneyLeft = moneyLeft%quarterValue;
		dimeAmount = moneyLeft/dimeValue;
		moneyLeft = moneyLeft%dimeValue;
		nickelAmount = moneyLeft/nickelValue;
		moneyLeft = moneyLeft%nickelValue;
		pennyAmount = moneyLeft;
		System.out.println("Your change is:");
		System.out.println (dollarAmount + " dollars");
		System.out.println (quarterAmount + " quarters");
		System.out.println (dimeAmount + " dimes");
		System.out.println(nickelAmount + " nickels");
		System.out.println(pennyAmount + " pennies");
		
		scan.close();

		
		//System.out.println(totalPaid + " " + totalPrice);
		//Making sure my variables work
		


//		int dollarNumb;
//		int centsNumb;
//		int moneyLeft;
//		
//		System.out.println("How many dollars?");
//		dollarNumb = scan.nextInt();
//		System.out.println("How many cents?");
//		centsNumb = scan.nextInt();
//I misread the instructions rip
		

	}

}
