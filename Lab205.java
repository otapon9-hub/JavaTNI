import javax.swing.JOptionPane;

public class Lab205 {
    public static void main(String[] args) {
        String inputStr = JOptionPane.showInputDialog("Input minutes:");

        int totalMinutes = Integer.parseInt(inputStr);

        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;

        String message = totalMinutes + " minutes is " + hours + " hour " + minutes + " minute";

        JOptionPane.showMessageDialog(null, message);
    }
}