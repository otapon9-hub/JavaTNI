public class Node {
    // Attributes (ตัวแปรเก็บข้อมูลและตัวชี้ตำแหน่งถัดไป)
    public Object data;   // เก็บข้อมูลของ Node
    public Node next;     // ชี้ไปยัง Node ถัดไปในลิสต์

    // Constructor (สำหรับสร้าง Node ใหม่โดยรับค่า data เข้ามา)
    public Node(Object data) {
        this.data = data;
        this.next = null;
    }

    // Method ดึงค่า Address ของตัว object เอง (Instance Method)
    public String getAddress() {
        return "" + Integer.toHexString(System.identityHashCode(this));
    }

    // Static Method สำหรับดึงค่า Address โดยรับพารามิเตอร์เป็น Node
    public static String getAddress(Node node) {
        return (node == null) ? "null" : node.getAddress();
    }
}