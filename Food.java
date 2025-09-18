public class Food implements Discountable {
    protected String name;
    protected double price;

    public Food(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getters & Setters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }

    // Implement discount (default 0%)
    @Override
    public double applyDiscount(double price) {
        return price; // no discount by default
    }
}
