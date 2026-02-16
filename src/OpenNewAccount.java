package Banking;

import java.io.*;
import java.util.Scanner;

public class OpenNewAccount extends BankAccount {

    // Constructor
    public OpenNewAccount(String accId, double accBalance) {
        super(accId, accBalance);
    }

    // เมธอดตรวจสอบว่ามีเลขบัญชีนี้ในไฟล์หรือยัง
    private boolean isExistingAccount(String account_name) {
        File file = new File(getFilename());
        if (!file.exists()) {
            return false;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].trim().equals(account_name)) {
                    return true; // พบเลขบัญชีซ้ำ
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false; // ไม่พบเลขบัญชีซ้ำ
    }

    // เมธอดบันทึกข้อมูลลงไฟล์
    public String recordAccount() {
        // ตรวจสอบก่อนว่าซ้ำไหม
        if (isExistingAccount(getAccId())) {
            return "This account has been created!!";
        } else {
            // ถ้าไม่ซ้ำ ให้เขียนลงไฟล์ (append mode)
            try (FileWriter fw = new FileWriter(getFilename(), true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)) {

                // เขียนข้อมูลจาก toString() ลงไฟล์
                out.println(this.toString());
                return "Created account success!!";

            } catch (IOException e) {
                return "Error writing to file: " + e.getMessage();
            }
        }
    }
}