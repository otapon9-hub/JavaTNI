import javax.swing.JOptionPane;

public class Lab307 {

    public static void main(String[] args) {
        double totalPrice = 0.0;
        double price = 0.0;

        do {
            String input = JOptionPane.showInputDialog(
                    null,
                    "Input price [press 0 to stop]:",
                    "Input",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (input == null) {
                price = 0;
                continue;
            }

            try {
                price = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Invalid price!!",
                        "Input",
                        JOptionPane.WARNING_MESSAGE
                );
                price = 1;
                continue;
            }

            if (price == 0) {
                break;

            } else if (price < 0) {
                JOptionPane.showMessageDialog(
                        null,
                        "Invalid price!!",
                        "Input",
                        JOptionPane.WARNING_MESSAGE
                );

            } else {
                // 3. ถ้าป้อนค่าเป็นบวก (> 0): นำไปรวมใน totalPrice
                totalPrice += price;
            }

        } while (price != 0);

        if (totalPrice > 0 || price == 0) {
            String resultMessage = String.format(
                    "Total price is %.1f baht.",
                    totalPrice
            );

            JOptionPane.showMessageDialog(
                    null,
                    resultMessage,
                    "Message",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
}