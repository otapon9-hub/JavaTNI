public class Product {
    public String name;
    public double price;
    public int quantity;


    public Product() {
    }

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


    public void addStock(int amount) {
        if (amount > 0) {
            this.quantity += amount;
        }
    }

    public void changePrice(double newPrice) {
        if (newPrice > 0) {
            this.price = newPrice;
        }
    }

    public void printDetails() {
        System.out.println("Name  : " + name);
        System.out.println("Price : " + price + " Baht/Item");
        System.out.println("Stock : " + quantity + " Items");
        System.out.println("Stock Value: " + getStockValue() + " Baht");
        System.out.println();
    }

    public double getStockValue() {
        return this.price * this.quantity;
    }


    public void showInfo() {
        System.out.println("Name  : " + name);
        System.out.println("Price : " + price + " Baht/Item");
        System.out.println("Stock : " + quantity + " Items");
        System.out.println("Stock Value: " + getStockValue() + " Baht");
        System.out.println("----------------------------------------");
    }

    public void sell(int amount) {
        if (amount > 0 && amount <= quantity) {
            this.quantity = this.quantity - amount;
            System.out.println("Sold " + amount + " items");
        } else {
            System.out.println("Not enough items in stock...");
        }
        System.out.println("----------------------------------------");
    }
}