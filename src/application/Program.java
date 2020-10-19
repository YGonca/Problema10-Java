package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.next();
		System.out.print("How many items to this order? ");
		int numOrder = sc.nextInt();
		Order order = new Order(new Date(), OrderStatus.valueOf(status), new Client(name, email, birthDate));
		
		for(int i = 1; i <= numOrder; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String prodName = sc.nextLine();
			System.out.print("Product price: ");
			double prodPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int prodQuantity = sc.nextInt();
			order.addItem(new OrderItem(prodQuantity, prodPrice, new Product(prodName, prodPrice)));
		}
		System.out.println("\nORDER SUMMARY:");
		System.out.println(order);
		
		sc.close();
	}

}
