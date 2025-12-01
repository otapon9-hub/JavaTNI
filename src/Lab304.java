import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Lab304 {

    public static void main(String[] args) {
        // --- 1. รับค่าน้ำหนัก (kg) ---
       double weight = Double.parseDouble(JOptionPane.showInputDialog("Enter your weight(kg.):"));

        // --- 2. รับค่าส่วนสูง (cm) ---
        int height = Integer.parseInt(JOptionPane.showInputDialog("Enter your height(cm.):"));


        // ตรวจสอบและแปลงค่าที่รับมา
        double  height_cm;


        double height_m = height / 100.0;


        double bmi = weight / (height_m * height_m);


        String bmiResult;

        if (bmi < 18.5) {
            bmiResult = "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {

            bmiResult = "Healthy Weight";
        } else if (bmi >= 25.0 && bmi <= 29.9) {

            bmiResult = "Overweight";
        } else {
            bmiResult = "Obese";
        }

        DecimalFormat frm = new DecimalFormat("##.00");

        JOptionPane.showMessageDialog(
                null,"Your BMI is "+frm.format(bmi)+"\nBMI resuilt is "+bmiResult);

    }
}