import javax.swing.JOptionPane;

public class Lab306 {

    public static void main(String[] args) {
        String inputStr = JOptionPane.showInputDialog(
                null,
                "Enter an integer number:",
                "Input",
                JOptionPane.QUESTION_MESSAGE
        );

        if (inputStr == null) {
            return;
        }

        int N = 0;
        try {
            N = Integer.parseInt(inputStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Invalid input. Please enter an integer.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        long summation = 0;

        for (int i = 1; i <= N; i++) {
            summation += i;
        }

        String message = String.format(
                "Summation of 1 to %d is %d",
                N,
                summation
        );

        JOptionPane.showMessageDialog(
                null,
                message,
                "Message",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}