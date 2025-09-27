public class Food implements Discountable {
    protected String name;
    protected double price;

    public Food(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public double applyDiscount(double price) {
        return price;
    }
}