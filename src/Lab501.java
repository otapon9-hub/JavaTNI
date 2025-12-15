import javax.swing.JOptionPane;

public class Lab501 {
    public static double cal_bmi(double weight, double height_cm) {
        double height_m = height_cm / 100.0;
        double bmi = weight / (height_m * height_m);

        return bmi;
    }


    public static String check_bmi(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 25.0) {
            return "Healthy Weight";
        } else if (bmi >= 25.0 && bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }


    public static void main(String[] args) {
        while (true) {
            int confirmResult = JOptionPane.showConfirmDialog(
                    null,
                    "Do you want to check your BMI?",
                    "Check BMI",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirmResult == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(
                        null,
                        "END PROGRAM!",
                        "Message",
                        JOptionPane.INFORMATION_MESSAGE
                );
                break;
            } else if (confirmResult == JOptionPane.YES_OPTION) {

                String weightInput = JOptionPane.showInputDialog(
                        "Enter your weight (kg.):",
                        ""
                );
                if (weightInput == null) {
                    continue;
                }
                double weight;
                try {
                    weight = Double.parseDouble(weightInput);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid weight input. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    continue;
                }

                String heightInput = JOptionPane.showInputDialog(
                        "Enter your height (cm.):",
                        ""
                );
                if (heightInput == null) {
                    continue;
                }
                double height_cm;
                try {
                    height_cm = Double.parseDouble(heightInput);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid height input. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    continue;
                }

                double bmi = cal_bmi(weight, height_cm);
                String bmiStatus = check_bmi(bmi);

                String resultMessage = String.format(
                        "Your BMI = %.2f\nYour BMI result = %s",
                        bmi,
                        bmiStatus
                );

                JOptionPane.showMessageDialog(
                        null,
                        resultMessage,
                        "Message", // Title
                        JOptionPane.INFORMATION_MESSAGE
                );


            }
        }
    }
}