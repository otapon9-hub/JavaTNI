public class Donut extends Bakery {
    private int quantity;

    public Donut(String flavor, double unitPrice, int quantity) {
        super(flavor, unitPrice);
        this.quantity = quantity;
    }

    public boolean needsNapkin() {
        return true;
    }

    public int getTo() {
        return this.quantity;
    }

    public String getFlavor() {
        return "Soft & Sweet " + super.getFlavor();
    }

    public String toString() {
        return super.toString() +
                "\nDonut (" + getFlavor() + ") x " + this.quantity + " pcs" +
                "\nTotal price of Donut = " + (this.quantity * getUnitPrice());
    }
}