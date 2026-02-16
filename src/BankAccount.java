package Banking;

public class BankAccount {
    private String accId;
    private double accBalance;
    // กำหนด path ของไฟล์ ให้เก็บอยู่ในโฟลเดอร์ Banking (ต้องสร้างโฟลเดอร์ Banking ในโปรเจกต์ด้วย)
    private final String filename = "src/Banking";

    // Constructor 1: รับทั้ง ID และ Balance
    public BankAccount(String accId, double accBalance) {
        this.accId = accId;
        this.accBalance = accBalance;
    }

    // Constructor 2: รับแค่ ID
    public BankAccount(String accId) {
        this.accId = accId;
        this.accBalance = 0.0;
    }

    // Constructor 3: ไม่รับค่า
    public BankAccount() {
    }

    // Getter & Setter
    public String getAccId() {
        return accId;
    }

    public void setAccBalance(double accBalance) {
        this.accBalance = accBalance;
    }

    public double getAccBalance() {
        return accBalance;
    }

    public String getFilename() {
        return filename;
    }

    // toString คืนค่ารูปแบบ [accId],[accBalance]
    // หมายเหตุ: ใช้เครื่องหมาย , คั่นเพื่อให้ง่ายต่อการอ่านไฟล์ภายหลัง
    @Override
    public String toString() {
        return accId + "," + accBalance;
    }
}