package manytoone_uni.controller;

import java.util.Scanner;

public class BankMain {
	public static void main(String[] args) {
		boolean exit=true;
		Scanner scanner=new Scanner(System.in);
		while(exit)
		{
			System.out.println("enter the choice \n 1.insert into branch \n 2.update \n 3.delete \n 4.getinfo of one \n 5.get info  \n 6.insert into bank \\n 7.update \\n 8.delete \\n 9.getinfo of one \\n 10.get info");
			int choice=scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("enter the id");
				int id=scanner.nextInt();
				System.out.println("enter the ");
				String name=scanner.next();
				System.out.println("enter the id");
				String name=scanner.next();
				System.out.println("enter the id");
				String name=scanner.next();
				System.out.println("enter the id");
				String name=scanner.next();
				System.out.println("enter the id");
				String name=scanner.next();
				break;

			default:
				break;
			}
		}
	}
}
