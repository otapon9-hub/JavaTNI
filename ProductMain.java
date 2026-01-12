import javax.swing.JOptionPane;

public class ProductMain {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to Product Stock System");

        String name = JOptionPane.showInputDialog("Enter product name:");

        String priceInput = JOptionPane.showInputDialog("Enter product price per item:");
        double price = Double.parseDouble(priceInput);

        String stockInput = JOptionPane.showInputDialog("Enter product stock:");
        int quantity = Integer.parseInt(stockInput);

        Product product = new Product(name, price, quantity);

        product.printDetails();

        int confirmStock = JOptionPane.showConfirmDialog(null,
                "Do you want to add more item?",
                "Select an Option",
                JOptionPane.YES_NO_CANCEL_OPTION);

        if (confirmStock == JOptionPane.YES_OPTION) {
            String addStockInput = JOptionPane.showInputDialog("How many items to add in stock?");
            int amountToAdd = Integer.parseInt(addStockInput);

            product.addStock(amountToAdd);

            System.out.println("Added " + amountToAdd + " items to stock");
        }

        int confirmPrice = JOptionPane.showConfirmDialog(null,
                "Do you want to change price?",
                "Select an Option",
                JOptionPane.YES_NO_CANCEL_OPTION);

        if (confirmPrice == JOptionPane.YES_OPTION) {
            String newPriceInput = JOptionPane.showInputDialog("How much is the new price per item?");
            double newPrice = Double.parseDouble(newPriceInput);

            product.changePrice(newPrice);

            System.out.println("Change price to " + newPrice + " baht");
        }

        System.out.println();

        product.printDetails();
    }
}