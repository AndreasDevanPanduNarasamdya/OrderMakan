public class MainCourse extends Food {
    private String portionSize;

    public MainCourse(String name, double price, String portionSize) {
        super(name, price);
        this.portionSize = portionSize;
    }

    public String getPortionSize() { return portionSize; }
    public void setPortionSize(String portionSize) { this.portionSize = portionSize; }

    @Override
    public double applyDiscount(double price) {
        return price * 0.90;
    }
}
