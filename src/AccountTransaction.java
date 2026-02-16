package Banking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AccountTransaction extends BankAccount implements Transactionable {

    // Constructor รับแค่ ID (เพื่อมาตรวจสอบหรือทำรายการ)
    public AccountTransaction(String accId) {
        super(accId);
    }

    // ตรวจสอบว่ามีบัญชีนี้อยู่ในไฟล์หรือไม่
    public boolean hasAccountId() {
        File file = new File(getFilename());
        if (!file.exists()) {
            return false;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].trim().equals(getAccId())) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void deposit(double amount) {
        // ฝากเงินเพิ่มผ่าน setAccBalance
        setAccBalance(getAccBalance() + amount);
        System.out.println("Deposit: " + amount + " | Current Balance: " + getAccBalance());
    }

    @Override
    public void withdraw(double amount) {
        // ตรวจสอบว่าเงินพอถอนหรือไม่
        if (getAccBalance() >= amount) {
            setAccBalance(getAccBalance() - amount);
            System.out.println("Withdraw: " + amount + " | Current Balance: " + getAccBalance());
        } else {
            // ถ้าไม่พอ ไม่ต้องทำอะไร (อาจจะปริ้นแจ้งเตือนก็ได้ แต่โจทย์บอกไม่ต้องทำงานอะไร)
            System.out.println("Insufficient funds for withdrawal.");
        }
    }

    @Override
    public double checkBalance() {
        return getAccBalance();
    }
}