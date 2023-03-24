package kebabMaster;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class KebabMaster {

	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	
	ArrayList<String> nameList = new ArrayList<String>();
	ArrayList<String> toppingList = new ArrayList<String>();
	ArrayList<Integer> priceList = new ArrayList<Integer>();
	
	String name;
	String topping;
	Integer price;
	
	public KebabMaster() {
		Menu();
	}
	
	public void Menu() {
		
		int choose = 0;

		do {
			try {
				System.out.println("Kebab Master");
				System.out.println("============");
				System.out.println("1. Add new Kebab");
				System.out.println("2. View all Kebab");
				System.out.println("3. Delete the most expensive kebab");
				System.out.println("4. Delete all Kebab");
				System.out.println("5. Exit");
				System.out.print(">> ");
				choose = scan.nextInt();
				if (choose == 1) {
					add();
				} else if (choose == 2) {
					view();
				} else if (choose == 3) {
					delExp();
				} else if (choose == 4) {
					delAll();
				} else if (choose == 5) {
					System.exit(0);
				}
			} catch (Exception e) {
				choose = Integer.MIN_VALUE;
			} scan.nextLine();
		} while (choose > 4 || choose < 1);
	}
	
	public void add() {
		
		Integer randNum1 = (int)(Math.random() * 50 + 1);
		Integer randNum2 = (int)(Math.random() * 50 + 1);
		Integer captcha;
		Integer inputCaptcha  = (int) (randNum1 + randNum2);
		
		do {
			System.out.print("Input kebab name [must starts with 'Kebab ' & less than 20 characters]: ");
			name = scan.nextLine();
		} while (!name.startsWith("Kebab "));
		nameList.add(name);
		
		do {
			System.out.print("Input kebab topping [Beef|Chicken|Mix] (Case Insensitive): ");
			topping = scan.nextLine();
		} while (!(topping.equalsIgnoreCase("Beef")) && !(topping.equalsIgnoreCase("Chicken")) && !(topping.equalsIgnoreCase("Mix")));
		toppingList.add(topping);
		
		do {
			System.out.print("Input kebab price [price must be less than Rp.30000]: ");
			price = scan.nextInt(); scan.nextLine();
		} while (price > 30000 || price < 0);
		priceList.add(price);
		
		do {
			System.out.print("Input captcha " + randNum1 + " + " + randNum2 + ": ");
			captcha = scan.nextInt(); scan.nextLine();
			inputCaptcha = randNum1 + randNum2;
		} while (!(captcha == inputCaptcha));
		
		System.out.println();
		System.out.println("New Kebab has been added!");
		System.out.println("Name: " + name);
		System.out.println("Topping: " + topping);
		System.out.println("Price: " + price);
		System.out.println("Press enter to continue...");
		scan.nextLine();
		Menu();
	}
	
	public void ascendingSort() {
		for (int i = 0; i < nameList.size() - 1; i++) {
			for (int j = 0; j < nameList.size() - i - 1; j++) {
				if (priceList.get(j) > priceList.get(j+1)) {
					int tempPrice = priceList.get(j);
					priceList.set(j, priceList.get(j+1));
					priceList.set(j+1, tempPrice);
					String tempTop = toppingList.get(j);
					toppingList.set(j, toppingList.get(j+1));
					toppingList.set(j+1, tempTop);
					String tempName = nameList.get(j);
					nameList.set(j, nameList.get(j+1));
					nameList.set(j+1, tempName);
				}
			}
		}
	}
	
	public void view() {
		if (nameList.isEmpty()) {
			System.out.println("There isn't any kebab on the menu!");
			System.out.println("Press enter to continue...");
			scan.nextLine();
			Menu();
		} else {
			
			System.out.println("=================================================================");
			System.out.printf("| %-5s | %-30s | %-10s | %-10s |\n", "No", "Kebab Name", "Topping", "Price");
			System.out.println("=======================================================");
			for (int i = 0; i < nameList.size(); i++) {
				System.out.printf("| %-5d | %-30s | %-10s | %-10d |\n", (i+1), nameList.get(i), toppingList.get(i), priceList.get(i));
			}
			System.out.println("=================================================================");
			System.out.println("Press enter to continue..");
			scan.nextLine();
			Menu();
		}
	}
	
	public void delExp() {
		
	if (nameList.isEmpty()) {
		System.out.println("There isn't any kebab on the menu!");
		System.out.println("Press enter to continue...");
		scan.nextLine();
		Menu();
	} else {
		priceList.remove(priceList.size() - 1);
		toppingList.remove(toppingList.size() - 1);
		nameList.remove(nameList.size() - 1);
		
		Menu();
		
	}
	}
	
	public void delAll() {
		
		if (nameList.isEmpty()) {
			System.out.println("there isn't any kebab on the menu!");
			System.out.println("Press enter to continue...");
			scan.nextLine();
			Menu();
		} else {
			
			nameList.clear();
			toppingList.clear();
			priceList.clear();
			
			System.out.println("All kebab has been deleted!");
			System.out.println("press enter to continue..");
			scan.nextLine();
			Menu();
		}
	}

	public static void main(String[] args) {
		new KebabMaster();

	}

}
