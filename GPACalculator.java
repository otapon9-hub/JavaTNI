import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// คลาสเก็บข้อมูลวิชา (เหมือนเดิม)
class Course {
    String name;
    double credits;
    String grade;
    double gradePoint;

    public Course(String name, double credits, String grade) {
        this.name = name;
        this.credits = credits;
        this.grade = grade;
        this.gradePoint = convertGradeToPoint(grade);
    }

    private double convertGradeToPoint(String g) {
        switch (g) {
            case "A": return 4.0;
            case "B+": return 3.5;
            case "B": return 3.0;
            case "C+": return 2.5;
            case "C": return 2.0;
            case "D+": return 1.5;
            case "D": return 1.0;
            case "F": return 0.0;
            default: return 0.0;
        }
    }
}

public class GPACalculator extends JFrame {
    private JTextField courseNameField;
    private JTextField creditsField;
    private JComboBox<String> gradeComboBox;
    private JTextArea displayArea;
    private JLabel resultLabel;

    private ArrayList<Course> courseList = new ArrayList<>();

    public GPACalculator() {
        setTitle("ระบบคำนวณเกรดเฉลี่ย (GPA Calculator)");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        inputPanel.add(new JLabel("วิชา:"));
        courseNameField = new JTextField(10);
        inputPanel.add(courseNameField);

        inputPanel.add(new JLabel("หน่วยกิต:"));
        creditsField = new JTextField(5);
        inputPanel.add(creditsField);

        inputPanel.add(new JLabel("เกรด:"));
        String[] grades = {"A", "B+", "B", "C+", "C", "D+", "D", "F"};
        gradeComboBox = new JComboBox<>(grades);
        inputPanel.add(gradeComboBox);

        JButton addButton = new JButton("เพิ่มวิชา");
        inputPanel.add(addButton);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        // เปลี่ยนฟอนต์ในกล่องข้อความให้เป็น Tahoma ด้วย
        displayArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(displayArea);
        displayArea.setText("รายการวิชาที่เพิ่ม:\n--------------------------------------------------\n");

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());

        JButton calcButton = new JButton("คำนวณเกรดเฉลี่ย");
        resultLabel = new JLabel("GPA: 0.00 (หน่วยกิตรวม: 0.0)");
        resultLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        resultLabel.setForeground(Color.BLUE);

        bottomPanel.add(calcButton);
        bottomPanel.add(resultLabel);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCourse();
            }
        });

        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateGPA();
            }
        });
    }

    private void addCourse() {
        String name = courseNameField.getText();
        String creditsStr = creditsField.getText();
        String grade = (String) gradeComboBox.getSelectedItem();

        if (name.isEmpty() || creditsStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "กรุณากรอกชื่อวิชาและหน่วยกิตให้ครบถ้วน!", "ข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double credits = Double.parseDouble(creditsStr);
            Course newCourse = new Course(name, credits, grade);
            courseList.add(newCourse);

            displayArea.append(String.format("วิชา: %-15s หน่วยกิต: %-5.1f เกรด: %s\n", name, credits, grade));

            courseNameField.setText("");
            creditsField.setText("");
            courseNameField.requestFocus();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "หน่วยกิตต้องเป็นตัวเลขเท่านั้น!", "ข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calculateGPA() {
        if (courseList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ยังไม่มีข้อมูลวิชาสำหรับคำนวณ", "แจ้งเตือน", JOptionPane.WARNING_MESSAGE);
            return;
        }

        double totalCredits = 0;
        double totalPoints = 0;

        for (Course c : courseList) {
            totalCredits += c.credits;
            totalPoints += (c.credits * c.gradePoint);
        }

        double gpa = totalPoints / totalCredits;
        resultLabel.setText(String.format("GPA: %.2f (หน่วยกิตรวม: %.1f)", gpa, totalCredits));
    }

    // --- ฟังก์ชันสำหรับตั้งค่าฟอนต์ภาษาไทย ---
    public static void setThaiFont() {
        Font thaiFont = new Font("Tahoma", Font.PLAIN, 14);
        UIManager.put("Label.font", thaiFont);
        UIManager.put("Button.font", thaiFont);
        UIManager.put("TextField.font", thaiFont);
        UIManager.put("ComboBox.font", thaiFont);
        UIManager.put("OptionPane.messageFont", thaiFont);
        UIManager.put("OptionPane.buttonFont", thaiFont);
    }

    public static void main(String[] args) {
        // เรียกใช้ฟังก์ชันตั้งค่าฟอนต์ก่อนเปิดหน้าต่างโปรแกรม
        setThaiFont();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GPACalculator().setVisible(true);
            }
        });
    }
}