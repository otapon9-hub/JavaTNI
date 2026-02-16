package Banking;

import java.util.Scanner;

public class BankSystem1 {

    // ประกาศ Scanner เป็น static เพื่อให้ทุกเมธอดเรียกใช้ตัวเดียวกันได้
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // 1. รับค่าเลขบัญชี
        String account_bank = input_account_id();

        // 2. รับค่ายอดเงินเริ่มต้น
        double initial_balance = input_initial_balance();

        // 3. สร้าง Object เพื่อเปิดบัญชี (เชื่อมโยงกับไฟล์ OpenNewAccount.java)
        OpenNewAccount account = new OpenNewAccount(account_bank, initial_balance);

        // 4. บันทึกข้อมูลและแสดงผลลัพธ์
        System.out.println(account.recordAccount());
    }

    // เมธอดรับและตรวจสอบเลขบัญชี
    public static String input_account_id() {
        String accId = "";
        while (true) {
            System.out.print("Enter account id: ");
            accId = scan.nextLine();

            // ตรวจสอบว่ามีความยาวครบ 10 ตัวหรือไม่
            if (accId.length() == 10) {
                return accId; // ถ้าครบ 10 ตัว ให้ส่งค่ากลับ
            } else {
                // ถ้าไม่ครบ วนลูปถามใหม่ (ตามโจทย์ไม่ได้ระบุข้อความ error message ชัดเจนในส่วนนี้ แต่ใส่เพื่อให้รู้ว่าผิด)
                // หรือแค่ปล่อยว่างไว้แล้วถามใหม่ตามตัวอย่าง Output
            }
        }
    }

    // เมธอดรับและตรวจสอบยอดเงิน
    public static double input_initial_balance() {
        double balance = 0.0;
        while (true) {
            System.out.print("Enter your initial deposit amount: ");

            // ตรวจสอบว่าเป็นตัวเลขหรือไม่ (ป้องกันการใส่ abc หรืออักขระพิเศษ)
            if (scan.hasNextDouble()) {
                balance = scan.nextDouble();
                scan.nextLine(); // เคลียร์ Newline ที่ค้างใน Buffer
                return balance;
            } else {
                // ถ้าไม่ใช่ตัวเลข (เช่นใส่ abc)
                String junk = scan.next(); // อ่านค่าขยะทิ้งไป
                System.out.print("Try again!! ");
                // Loop จะวนกลับไปถามบรรทัด "Enter your initial..." ใหม่
            }
        }
    }
}