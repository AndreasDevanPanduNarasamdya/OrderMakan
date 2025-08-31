import java.util.Scanner;

/**
 * Food class with encapsulation
 */
class Food {
    // Private attributes (Encapsulation)
    private String name;
    private double price;
    
    // Constructor
    public Food(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    // Getter methods
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    // Setter methods
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
}

/**
 * Customer class with encapsulation
 */
class Customer {
    // Private attributes (Encapsulation)
    private String name;
    
    // Constructor
    public Customer(String name) {
        this.name = name;
    }
    
    // Getter method
    public String getName() {
        return name;
    }
    
    // Setter method
    public void setName(String name) {
        this.name = name;
    }
}

/**
 * Purchase class with encapsulation
 */
class Purchase {
    // Private attributes (Encapsulation)
    private Customer customer;
    private Food food;
    private double payment;
    private double change;
    
    // Constructor
    public Purchase(Customer customer, Food food, double payment) {
        this.customer = customer;
        this.food = food;
        this.payment = payment;
        this.change = payment - food.getPrice();
    }
    
    // Getter methods
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
    
    // Display receipt
    public void showReceipt() {
        System.out.println("\n=== RECEIPT ===");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Food: " + food.getName());
        System.out.println("Price: Rp " + food.getPrice());
        System.out.println("Payment: Rp " + payment);
        System.out.println("Change: Rp " + change);
        System.out.println("===============");
    }
}

/**
 * Main class - Simple Kantin Ordering System
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Create food menu (Objects)
        Food[] menu = {
            new Food("Nasi Gudeg", 15000),
            new Food("Mie Ayam", 12000),
            new Food("Es Teh", 4000),
            new Food("Gorengan", 5000)
        };
        
        System.out.println("=== KANTIN PUJASERA POLBAN ===");
        
        // Main loop
        while (true) {
            System.out.println("\n1. Order Food");
            System.out.println("2. Show Encapsulation");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            int choice = input.nextInt();
            input.nextLine(); // Clear buffer
            
            if (choice == 0) {
                System.out.println("Thank you!");
                break;
            }
            
            if (choice == 1) {
                // Show menu
                System.out.println("\n=== MENU ===");
                for (int i = 0; i < menu.length; i++) {
                    System.out.println((i + 1) + ". " + menu[i].getName() + 
                                     " - Rp " + menu[i].getPrice());
                }
                
                // Get order
                System.out.print("Select food (1-" + menu.length + "): ");
                int foodChoice = input.nextInt() - 1;
                input.nextLine();
                
                if (foodChoice >= 0 && foodChoice < menu.length) {
                    Food selectedFood = menu[foodChoice];
                    
                    System.out.print("Enter your name: ");
                    String customerName = input.nextLine();
                    
                    // Create customer object
                    Customer customer = new Customer(customerName);
                    
                    System.out.println("Total: Rp " + selectedFood.getPrice());
                    System.out.print("Enter payment: Rp ");
                    double payment = input.nextDouble();
                    
                    if (payment >= selectedFood.getPrice()) {
                        // Create purchase object
                        Purchase purchase = new Purchase(customer, selectedFood, payment);
                        purchase.showReceipt();
                    } else {
                        System.out.println("❌ Insufficient payment!");
                    }
                } else {
                    System.out.println("❌ Invalid choice!");
                }
            }
            
            if (choice == 2) {
                // Demonstrate encapsulation
                System.out.println("\n=== ENCAPSULATION DEMO ===");
                Food demo = new Food("Demo Food", 10000);
                
                System.out.println("Using getter: " + demo.getName());
                System.out.println("Using getter: Rp " + demo.getPrice());
                
                demo.setName("Updated Food");
                demo.setPrice(15000);
                
                System.out.println("After setter: " + demo.getName());
                System.out.println("After setter: Rp " + demo.getPrice());
                System.out.println("✅ Encapsulation working!");
            }
        }
        
        input.close();
    }
}