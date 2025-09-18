public class Drink extends Food {
    private boolean isCold;

    public Drink(String name, double price, boolean isCold) {
        super(name, price);
        this.isCold = isCold;
    }

    public boolean isCold() { return isCold; }
    public void setCold(boolean isCold) { this.isCold = isCold; }

    // Apply 5% discount for drinks
    @Override
    public double applyDiscount(double price) {
        return price * 0.95;
    }
}
