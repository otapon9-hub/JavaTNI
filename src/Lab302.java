import javax.swing.JOptionPane;

public class Lab302 {

    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog(null, "Input your name:", "Input", JOptionPane.QUESTION_MESSAGE);

        String heightStr = JOptionPane.showInputDialog(null, "Enter your height (cm.):", "Input", JOptionPane.QUESTION_MESSAGE);

        double height = 0;
        try {
            height = Double.parseDouble(heightStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid height input. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int maleOption = JOptionPane.showConfirmDialog(
                null,
                "Are your biological gender is Male?",
                "Gender",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (maleOption == JOptionPane.YES_OPTION) {

            double standardWeight = height - 100;

            String message = String.format(
                    "Hello, Mr.%s\nIf your height is %.1f cm.\nYour weight should be %.1f kg.",
                    name,
                    height,
                    standardWeight
            );

            JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);

        } else {

            int femaleOption = JOptionPane.showConfirmDialog(
                    null,
                    "Are your biological gender is Female?",
                    "Gender",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (femaleOption == JOptionPane.YES_OPTION) {

                double standardWeight = height - 110;

                String message = String.format(
                        "Hello, Ms.%s\nIf your height is %.1f cm.\nYour weight should be %.1f kg.",
                        name,
                        height,
                        standardWeight
                );

                JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);

            } else {

                String message = "You can use BMI to measure your weight and height.";
                JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}