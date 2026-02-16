package Banking;

import java.io.File;
// ลบ import java.io.IOException; ออกเพราะไม่ได้ใช้

public class Main {
    public static void main(String[] args) {
        // ตรวจสอบโฟลเดอร์
        File dir = new File("Banking");
        if (!dir.exists()) dir.mkdir();

        System.out.println("--- Testing OpenNewAccount ---");
        // 1. สร้างบัญชีใหม่
        OpenNewAccount newAcc1 = new OpenNewAccount("1001", 5000.0);
        System.out.println("Register 1001: " + newAcc1.recordAccount());

        // 2. สร้างซ้ำ
        OpenNewAccount newAcc2 = new OpenNewAccount("1001", 200.0);
        System.out.println("Register 1001 (Again): " + newAcc2.recordAccount());

        // 3. สร้างอีกบัญชี
        OpenNewAccount newAcc3 = new OpenNewAccount("1002", 10000.0);
        System.out.println("Register 1002: " + newAcc3.recordAccount());

        System.out.println("\n--- Testing AccountTransaction ---");
        // 4. ทดสอบธุรกรรม
        AccountTransaction trans = new AccountTransaction("1001");

        if (trans.hasAccountId()) {
            System.out.println("Account 1001 found in file.");

            // set เงินสมมติ (ตามที่คุณ comment ไว้ถูกต้องแล้วครับ เพราะคลาสนี้ไม่มีเมธอดโหลดเงิน)
            trans.setAccBalance(5000.0);

            // [แก้จุดที่ 1] สั่งปริ้นเพื่อให้เห็นยอดเงินตั้งต้น
            System.out.println("Start Balance: " + trans.checkBalance());

            trans.deposit(1000);
            trans.withdraw(2000);
            trans.withdraw(10000);

            System.out.println("Final Balance: " + trans.checkBalance());
        } else {
            System.out.println("Account 1001 not found.");
        }
    }
}