import java.util.Scanner;

public class ProductMain2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        Product product1 = new Product();
        product1.name = "Pens";
        product1.price = 10.5;
        product1.quantity = 50;

        Product product2 = new Product();
        product2.name = "Notebooks";
        product2.price = 25.75;
        product2.quantity = 20;

        System.out.println("Welcome to Mini Shop");
        System.out.println("----------------------------------------");
        System.out.println("Press [1] to buy Pen");
        System.out.println("Press [2] to buy Notebook");

        int choice = 0;
        System.out.print("Enter a number: ");

        while (true) {
            choice = scan.nextInt();
            if (choice == 1 || choice == 2) {
                break;
            } else {
                System.out.print("Invalid number! Enter a number, again: ");
            }
        }

        System.out.println();

        Product selectedProduct = null;

        if (choice == 1) {
            selectedProduct = product1;
        } else if (choice == 2) {
            selectedProduct = product2;
        }

        selectedProduct.showInfo();

        System.out.print("How many " + selectedProduct.name + " do you want to buy? ");
        int buyAmount = scan.nextInt();

        selectedProduct.sell(buyAmount);

        selectedProduct.showInfo();
    }
}