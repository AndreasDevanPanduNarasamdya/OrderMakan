import java.util.Scanner;
import java.util.ArrayList;

class Food {
    private String name;
    private double price;
    
    public Food(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
}

class Customer {
    private String name;
    
    public Customer(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}

class Purchase {
    private Customer customer;
    private Food food;
    private double payment;
    private double change;
    
    public Purchase(Customer customer, Food food, double payment) {
        this.customer = customer;
        this.food = food;
        this.payment = payment;
        this.change = payment - food.getPrice();
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public Food getFood() {
        return food;
    }
    
    public double getPayment() {
        return payment;
    }
    
    public double getChange() {
        return change;
    }
    
    public void showReceipt() {
        System.out.println("\n----RECEIPT----");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Food: " + food.getName());
        System.out.println("Price: Rp " + food.getPrice());
        System.out.println("Payment: Rp " + payment);
        System.out.println("Change: Rp " + change);
        System.out.println("-----------");
    }
}

public class KantinPujaseraPolban {
    private static ArrayList<Purchase> purchaseHistory = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        Food[] menu = {
            new Food("Nasi Gudeg", 15000),
            new Food("Mie Ayam", 12000),
            new Food("Es Teh", 4000),
            new Food("Es Jeruk", 5000)
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
                    
                    System.out.println("Total: Rp " + selectedFood.getPrice());
                    System.out.print("Enter payment: Rp ");
                    double payment = input.nextDouble();
                    
                    if (payment >= selectedFood.getPrice()) {
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