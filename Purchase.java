public class Purchase implements Payable {
    private Customer customer;
    private Food food;
    private double payment;
    private double finalPrice;
    private double change;

    public Purchase(Customer customer, Food food, double payment) {
        this.customer = customer;
        this.food = food;
        this.finalPrice = food.applyDiscount(food.getPrice());
        this.payment = payment;
        this.change = calculateChange(payment);
    }

    @Override
    public double calculateChange(double payment) {
        return payment - finalPrice;
    }

    public Customer getCustomer() { return customer; }
    public Food getFood() { return food; }
    public double getPayment() { return payment; }
    public double getFinalPrice() { return finalPrice; }
    public double getChange() { return change; }

    public void setCustomer(Customer customer) { this.customer = customer; }
    public void setFood(Food food) { this.food = food; }
    public void setPayment(double payment) { this.payment = payment; }
    public void setChange(double change) { this.change = change; }

    public void showReceipt() {
        System.out.println("\n----RECEIPT----");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Food: " + food.getName());
        System.out.println("Original Price: Rp " + food.getPrice());
        System.out.println("Discounted Price: Rp " + finalPrice);
        System.out.println("Payment: Rp " + payment);
        System.out.println("Change: Rp " + change);
        System.out.println("-----------");
    }
}
