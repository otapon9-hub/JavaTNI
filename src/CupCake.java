public class CupCake extends Bakery {
    private int piece;

    // แก้ไข flvaor เป็น flavor
    public CupCake(int piece, String flavor, double unitPrice) {
        super(flavor, unitPrice);
        this.piece = piece;
    }

    public boolean isPackingBox() {
        return this.piece >= 6; // Logic นี้ถูกต้องแล้วครับ (ตามหลักทั่วไป) แต่อาจต้องเช็คโจทย์ว่าขั้นต่ำกี่ชิ้น
    }

    public int getBoxNumber() {
        if (isPackingBox()) {
            return piece / 6; // หารตัดเศษเพื่อหาจำนวนกล่อง
        }
        return 0;
    }

    public int getBagNumber() {
        return this.piece % 6; // หาเศษที่เหลือใส่ถุง
    }

    public String toString() {
        // ลบ ; หลัง super.toString() ออก และเชื่อมประโยคด้วย +
        return super.toString() +
                "\nCupCake (" + getFlavor() + " with " +
                getBoxNumber() + " Box(es) " + getBagNumber() + " Bag" +
                "\nTotal price of Cup Cake = " + (this.piece * getUnitPrice());
    }
}