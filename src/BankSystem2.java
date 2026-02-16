package Banking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BankSystem2 {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // 1. รับค่าเลขบัญชี
        System.out.print("Enter your bank account: ");
        String inputId = scan.nextLine();

        // 2. สร้าง Object AccountTransaction
        AccountTransaction account = new AccountTransaction(inputId);

        // 3. ตรวจสอบว่ามีบัญชีในไฟล์หรือไม่
        if (account.hasAccountId()) {

            // [เพิ่มเติม] โหลดเงินล่าสุดจากไฟล์มาใส่ใน Object เพื่อให้คำนวณถูกต้อง
            loadUserBalance(account);

            // แสดงเมนูคำสั่ง
            printMenu();

            boolean isRunning = true;
            while (isRunning) {
                System.out.print("\nEnter a menu: ");

                // ตรวจสอบว่าสิ่งที่ป้อนเป็นตัวเลขหรือไม่
                if (scan.hasNextInt()) {
                    int menu = scan.nextInt();

                    switch (menu) {
                        case 1: // ฝากเงิน
                            System.out.print("Enter amount to deposit: ");
                            double depAmount = scan.nextDouble();
                            account.deposit(depAmount);
                            System.out.println("Your balance = " + account.checkBalance());
                            break;

                        case 2: // ถอนเงิน
                            System.out.print("Enter amount to withdraw: ");
                            double wdAmount = scan.nextDouble();
                            account.withdraw(wdAmount);
                            System.out.println("Your balance = " + account.checkBalance());
                            break;

                        case 3: // ดูยอดเงิน
                            System.out.println("Your balance = " + account.checkBalance());
                            break;

                        case 4: // จบการทำงาน
                            // ไม่ต้อง print อะไรเพิ่มเติมตามตัวอย่าง Output ในรูปสุดท้าย
                            isRunning = false;
                            break;

                        default: // ถ้ากดเลขอื่นนอกเหนือจาก 1-4
                            // วนลูปรับค่าใหม่ (ไม่ต้องทำอะไร โปรแกรมจะวนกลับไปบรรทัด Enter a menu)
                    }
                } else {
                    // ถ้าผู้ใช้พิมพ์ตัวอักษร ให้เคลียร์ทิ้งแล้วรับใหม่
                    scan.next();
                }
            }

            System.out.println("Process finished with exit code 0");

        } else {
            // กรณีไม่พบบัญชี
            System.out.println("Bank account not found...");
        }
    }

    // เมธอดแสดงเมนู (แยกออกมาเพื่อให้โค้ดอ่านง่าย)
    private static void printMenu() {
        System.out.println("\nPress 1 to deposit");
        System.out.println("Press 2 to withdraw");
        System.out.println("Press 3 to check balance");
        System.out.println("Press 4 to exit");
    }

    // [เพิ่มเติม] เมธอดสำหรับอ่านยอดเงินจากไฟล์ users_account.txt มาตั้งค่าให้ Object
    private static void loadUserBalance(AccountTransaction acc) {
        File file = new File("Banking/users_account.txt"); // ต้องตรงกับ path ใน BankAccount
        try (Scanner fileScan = new Scanner(file)) {
            while (fileScan.hasNextLine()) {
                String line = fileScan.nextLine();
                String[] parts = line.split(",");
                // ถ้าเจอ ID ที่ตรงกัน ให้อ่านค่าเงิน (parts[1]) มาใส่ใน acc
                if (parts.length >= 2 && parts[0].trim().equals(acc.getAccId())) {
                    double currentBalance = Double.parseDouble(parts[1].trim());
                    acc.setAccBalance(currentBalance);
                    break;
                }
            }
        } catch (FileNotFoundException | NumberFormatException e) {
            // กรณีไฟล์มีปัญหา หรือแปลงตัวเลขไม่ได้ ให้ยอดเงินเป็น 0 โดยอัตโนมัติ
        }
    }
}