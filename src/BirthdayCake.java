public class BirthdayCake extends Bakery {
    private String message; // แก้จาก massage
    private double pound;

    // แก้ไข uniPrice เป็น unitPrice
    public BirthdayCake(String message, double pound, String flavor, double unitPrice) {
        super(flavor, unitPrice);
        this.message = message;
        this.pound = pound;
    }

    public String getMessage() {
        return this.message;
    }

    public void changeMessage(String new_message) {
        this.message = new_message;
    }

    // แก้ Public เป็น public
    public String toString() {
        // แก้ไขการ return ให้ต่อกันเป็นก้อนเดียว
        return super.toString() +
                "\n" + getFlavor() + " birthday cake (message=" + this.message + ")" +
                "\nTotal price of Birthday Cake = " + (getUnitPrice() * this.pound);
    }
}