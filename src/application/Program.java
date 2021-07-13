package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program  {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> list = new ArrayList<Product>();
		
		
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		System.out.println();
		
		
		for (int i=0; i<n; ++i ) {
			sc.nextLine();
			System.out.println("Product #" + (i+1) + "data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char choose = sc.next().charAt(0);
			sc.nextLine();

			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			
			Product product;
			if ( choose == 'c') {
				 product = new Product(name, price);
				list.add(product);
				System.out.println();
			}
			
			if ( choose == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());
				product = new UsedProduct(name, price, date);
				list.add(product);
				System.out.println();
			}
			
			if ( choose == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				product = new ImportedProduct(name, price, customsFee);
				list.add(product);
				System.out.println();
			}
			
			
			
		}
		
		
		sc.close();
	}

}
