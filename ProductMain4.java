import java.util.Scanner;

public class ProductMain4 {

    public static void setting_product(Product... products) {
        String[] names = {"Pens", "Pencils", "Markers", "Highlighters"};
        double[] prices = {25.5, 17.25, 30, 35};
        int[] quantities = {20, 35, 10, 40};

        for (int i = 0; i < products.length; i++) {
            products[i] = new Product();
            products[i].name = names[i];
            products[i].price = prices[i];
            products[i].quantity = quantities[i];
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Product[] products = new Product[4];
        setting_product(products);

        System.out.println("Welcome to MINI SHOP!!");
        System.out.println("----------------------------------------");

        for (int i = 0; i < products.length; i++) {
            System.out.println("Press " + (i + 1) + " to buy " + products[i].name +
                    " (items=" + products[i].quantity + ")");
        }

        System.out.println("----------------------------------------");

        System.out.print("Enter a number: ");
        int index = -1;

        while (true) {
            index = scan.nextInt();

            if (index >= 1 && index <= 4) {
                break;
            } else {
                System.out.print("Invalid!! Enter a number: ");
            }
        }

        System.out.println("----------------------------------------");

        Product selectedProduct = products[index - 1];

        System.out.print("How many " + selectedProduct.name + " do you want to buy? ");
        int amount = scan.nextInt();

        selectedProduct.sell(amount);

        selectedProduct.showInfo();
    }
}