package bill;

import java.util.Scanner;

public class Bill {

	public static void main(String[] args) {
		
		String dishOne;
		String dishTwo;
		String dishThree;
		double priceOne;
		double priceTwo;
		double priceThree;
		int quantOne;
		int quantTwo;
		int quantThree;
		double dishOneTotal;
		double dishTwoTotal;
		double dishThreeTotal;
		double totalPrice;
		double tip;
		double tax; 
		double total;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Input name of dish 1:");
		dishOne = scan.nextLine();
		System.out.println("Input quantity of dish 1 as an int: ");
		quantOne = scan.nextInt();
		System.out.println("Input price of dish 1 as a double: ");
		priceOne = scan.nextDouble();
		
		scan.nextLine();
		System.out.println("Input name of dish 2:");
		dishTwo = scan.nextLine();
		System.out.println("Input quantity of dish 2 as an int: ");
		quantTwo = scan.nextInt();
		System.out.println("Input price of dish 2 as a double: ");
		priceTwo = scan.nextDouble();
		
		scan.nextLine();		
		System.out.println("Input name of dish 3:");
		dishThree = scan.nextLine();
		System.out.println("Input quantity of dish 3 as an int: ");
		quantThree = scan.nextInt();
		System.out.println("Input price of dish 3 as a double: ");
		priceThree = scan.nextDouble();
		
		dishOneTotal = quantOne*priceOne;
		dishTwoTotal = quantTwo*priceTwo;
		dishThreeTotal = quantThree*priceThree;
		
		System.out.println();
		System.out.println("Your bill:");
//		System.out.print("Dish");
		System.out.printf("%-30s %-5s %-10s %-10s", "Dish", "Quantity", "Price", "Total");
		System.out.println();
		System.out.printf("%-30s %-5d %-10.2f %-10.2f", dishOne, quantOne, priceOne, dishOneTotal);
		System.out.println();
		System.out.printf("%-30s %-5d %-10.2f %-10.2f", dishTwo, quantTwo, priceTwo, dishTwoTotal);
		System.out.println();
		System.out.printf("%-30s %-5d %-10.2f %-10.2f", dishThree, quantThree, priceThree, dishThreeTotal);
		totalPrice = dishOneTotal + dishTwoTotal + dishThreeTotal;
		System.out.println();
		System.out.printf("%-30s %-10.2f", "Subtotal", totalPrice);
		tip = totalPrice*0.18;
		System.out.println();
		System.out.printf("%-30s %-10.2f", "18% Tip (before tax):", tip);
		tax = totalPrice*0.06;
		System.out.println();
		System.out.printf("%-30s %-10.2f", "6.00% sales tax:", tax);
		total = totalPrice + tip + tax;
		System.out.println();
		System.out.printf("%-30s %-10.2f", "Total:", total);

		scan.close();
		
	}

}
