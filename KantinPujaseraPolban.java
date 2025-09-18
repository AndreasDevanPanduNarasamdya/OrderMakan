import java.util.ArrayList;
import java.util.Scanner;

public class KantinPujaseraPolban {
    private static ArrayList<Purchase> purchaseHistory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Food[] menu = {
            new MainCourse("Nasi Gudeg", 15000, "Large"),
            new MainCourse("Mie Ayam", 12000, "Medium"),
            new Drink("Es Teh", 4000, true),
            new Drink("Es Jeruk", 5000, true)
        };

        System.out.println("----KANTIN PUJASERA POLBAN----");

        while (true) {
            System.out.println("\n1. Order Food");
            System.out.println("2. View Purchase History");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 0) {
                System.out.println("Thank you!");
                break;
            }

            if (choice == 1) {
                System.out.println("\nMENU");
                for (int i = 0; i < menu.length; i++) {
                    System.out.println((i + 1) + ". " + menu[i].getName() +
                                       " - Rp " + menu[i].getPrice());
                }

                System.out.print("Select food (1-" + menu.length + "): ");
                int foodChoice = input.nextInt() - 1;
                input.nextLine();

                if (foodChoice >= 0 && foodChoice < menu.length) {
                    Food selectedFood = menu[foodChoice];

                    System.out.print("Enter your name: ");
                    String customerName = input.nextLine();

                    Customer customer = new Customer(customerName);

                    double discountedPrice = selectedFood.applyDiscount(selectedFood.getPrice());
                    System.out.println("Total after discount: Rp " + discountedPrice);
                    System.out.print("Enter payment: Rp ");
                    double payment = input.nextDouble();

                    if (payment >= discountedPrice) {
                        Purchase purchase = new Purchase(customer, selectedFood, payment);
                        purchase.showReceipt();
                        purchaseHistory.add(purchase);
                    } else {
                        System.out.println("Insufficient payment!");
                    }
                } else {
                    System.out.println("Invalid choice!");
                }
            }

            if (choice == 2) {
                System.out.println("\n=== PURCHASE HISTORY ===");
                if (purchaseHistory.isEmpty()) {
                    System.out.println("No purchases yet.");
                } else {
                    for (int i = 0; i < purchaseHistory.size(); i++) {
                        System.out.println("\nPurchase #" + (i + 1) + ":");
                        purchaseHistory.get(i).showReceipt();
                    }
                    System.out.println("\nTotal purchases: " + purchaseHistory.size());
                }
            }
        }

        input.close();
    }
}
