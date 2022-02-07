package com.asus.shoppingcart;

import java.util.ArrayList;
import java.util.Scanner;

public class Screen
{

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int option = 0;
		int numberOfChosen = 0;
		double basket = 0;
		boolean condition = true;
		int password;

		Coat coat = new Coat("Y�nl� kaban", "Bershka", "deri detayl�", 1, 200, numberOfChosen, "M");
		Dress dress = new Dress("Saten elbise", "Mango", "�i�ekli", 5, 149, numberOfChosen, "pembe", 34);
		Shoes shoe = new Shoes("Topuklu Ayakkabi", "NineWest", "rugan", 2, 250, numberOfChosen, 38);
		
		ArrayList<String> myBasket = new ArrayList<String>();


		System.out.println("Ho�geldiniz..");
		System.out.println("�ifrenizi giriniz:");
		password = scan.nextInt();
		System.out.println("****************************************************");


		if (password == User.password) {
			System.out.println("Ho�geldiniz " + User.userName);
			while (condition) {
				System.out.println("\n\nAlmak istediginiz �r�n� seciniz..");
				System.out.println("1.Kaban\n2.Elbise\n3.Ayakkabi\n4.Al�sverisi sonland�r");
				System.out.println("****************************************************");

				option = scan.nextInt();

				switch (option) {
				case 1:
					coat.print();
					if (coat.buy(scan)) {
						basket += coat.getNumberOfChosen() * coat.getRawPrice();
						myBasket.add("" + coat.getNumberOfChosen() + " adet " + coat.getProductName() + "="
								+ coat.getNumberOfChosen() * coat.getRawPrice());
						System.out.println("urun sepete eklendi.. sepet:  " + basket);

					} else {
						System.out.println("\nMaalesef stokta " + coat.getStock() + " adet �r�n bulunmakta..");
					}

					break;
				case 2:
					dress.print();
					if (dress.buy(scan)) {
						basket += dress.getNumberOfChosen() * dress.getRawPrice();
						myBasket.add("" + dress.getNumberOfChosen() + " adet " + dress.getProductName() + "="
								+ dress.getNumberOfChosen() * dress.getRawPrice());
						System.out.println("urun sepete eklendi.. SEPET: " + basket);

					} else {
						System.out.println("\nMaalesef stokta " + dress.getStock() + " adet �r�n bulunmakta..");
					}

					break;
				case 3:
					shoe.print();
					if (shoe.buy(scan)) {
						basket += shoe.getNumberOfChosen() * shoe.getRawPrice();
						myBasket.add("" + shoe.getNumberOfChosen() + " adet " + shoe.getProductName() + "="
								+ shoe.getNumberOfChosen() * shoe.getRawPrice() + "\n");
						System.out.println("urun sepete eklendi.. sepet: " + basket);

					} else {
						System.out.println("\nMaalesef stokta " + shoe.getStock() + " adet �r�n bulunmakta..");
					}
					break;
				case 4:
					System.out.println("///////////////////////////////////////////////////////\n\n");
					System.out.println(myBasket);
					System.out.println("�demeniz gereken tutar: " + basket);
					System.out.println("\n\n///////////////////////////////////////////////////////");
					condition = false;
					break;

				default:
					System.out.println("gecersiz islem");
				}

			}

		} else {
			System.out.println("mail veya �ifre hatal�..");
		}
		
	}
}

