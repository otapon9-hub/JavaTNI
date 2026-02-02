public class Bakery {
    private String flavor;
    private double unitPrice;
    private  int packingcost = 5;

    public Bakery (String flavor, double unitPrice) {
        this.flavor = flavor;
        this.unitPrice = unitPrice;
    }
    public Bakery () {
        this("", 0.0);
    }
    public String getFlavor() {
        return  this.flavor;
    }
    public double getUnitPrice() {
        return this.unitPrice;
    }
    public String toString() {
        return "Thank you for your order!";
    }
}