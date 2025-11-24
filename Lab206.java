import javax.swing.JOptionPane;

public class Lab206 {
    public static void main(String[] args) {
        final int PRICE_PER_CUSTOMER = 299;

        String inputCustomerStr = JOptionPane.showInputDialog("How many customer?");
        int customers = Integer.parseInt(inputCustomerStr);

        double subTotal = customers * PRICE_PER_CUSTOMER;
        double Net = subTotal + (subTotal * 7.0 / 100.0);

        String pyStep2 = String.format("Price with NET is %.2f baht.\nHow much of discount (%%) on your coupon?", Net);
        String inputDiscountStr = JOptionPane.showInputDialog(pyStep2);
        double discountPercent = Double.parseDouble(inputDiscountStr);

        double discountAmount = Net * (discountPercent / 100.0);
        double finalPrice = Net - discountAmount;

        String pyStep3 = String.format("Total price is %.2f baht.\nEnter the amount the customer paid:", finalPrice);
        String inputPaidStr = JOptionPane.showInputDialog(pyStep3);
        double amountPaid = Double.parseDouble(inputPaidStr);

        double change = amountPaid - finalPrice;

        String finalMessage = String.format("Total price is %.2f baht.\nCustomer paid %.2f baht.\nGet change %.2f baht.",
                finalPrice, amountPaid, change);

        JOptionPane.showMessageDialog(null, finalMessage);
    }
}
