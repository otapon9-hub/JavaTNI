public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    // ข้อ 1: Method สำหรับแปลงข้อมูลในลิสต์เป็น String เพื่อแสดงผล
    public String traversal() {
        Node current_node = head;
        String result = "[";
        boolean first = true;
        while (current_node != null) {
            result += (!first ? ", " : "") + current_node.data;
            first = false;
            current_node = current_node.next;
        }
        result += "]";
        return result;
    }

    // ข้อ 2, 3: Method สำหรับแทรกข้อมูลตามตำแหน่งที่กำหนด (position)
    public void insert(int position, Object value) {
        Node new_node = new Node(value);

        if (head == null) {
            head = new_node;
        } else if (position == 0) {
            new_node.next = head;
            head = new_node;
        } else {
            Node current_node = head;
            int current_position = 0;
            while (current_node != null && current_position < position - 1) {
                current_node = current_node.next;
                current_position++;
            }
            if (current_node != null) {
                new_node.next = current_node.next;
                current_node.next = new_node;
            }
        }
    }

    // ข้อ 4: Method สำหรับต่อท้ายข้อมูลที่ปลายสุดของลิสต์
    public void insert(Object value) {
        Node new_node = new Node(value);

        if (head == null) {
            head = new_node;
        } else {
            Node current_node = head;
            while (current_node.next != null) {
                current_node = current_node.next;
            }
            current_node.next = new_node;
        }
    }

    // ข้อ 5, 6: Method สำหรับลบข้อมูลตามตำแหน่งที่กำหนด (position)
    public void remove(int position) {
        if (head == null) {
            return;
        }

        if (position == 0) {
            head = head.next;
        } else {
            Node current_node = head;
            int current_position = 0;
            while (current_node.next != null && current_position < position - 1) {
                current_node = current_node.next;
                current_position++;
            }
            if (current_node.next != null) {
                current_node.next = current_node.next.next;
            }
        }
    }

    // ข้อ 7: Method สำหรับลบข้อมูลตัวสุดท้ายของลิสต์
    public void removelastElement() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
        } else {
            Node current_node = head;
            while (current_node.next.next != null) {
                current_node = current_node.next;
            }
            current_node.next = null;
        }
    }

    // ข้อ 8: Method สำหรับนับจำนวนสมาชิกทั้งหมดในลิสต์
    public int length() {
        int count = 0;
        Node current_node = head;
        while (current_node != null) {
            count++;
            current_node = current_node.next;
        }
        return count;
    }

    // ข้อ 9: Method สำหรับดึงค่าข้อมูล (data) ตามตำแหน่งที่กำหนด
    public Object get(int position) {
        if (head == null || position < 0) {
            return null;
        }
        Node current_node = head;
        int current_position = 0;
        while (current_node != null && current_position < position) {
            current_node = current_node.next;
            current_position++;
        }
        if (current_node != null) {
            return current_node.data;
        }
        return null;
    }

    // ==========================================
    // 💡 ตรงนี้คือส่วนที่เพิ่มเข้าไปใหม่ครับ (ข้อ 10 และ 11)
    // ==========================================

    // ข้อ 10: Method สำหรับแก้ไขข้อมูลตามตำแหน่งที่กำหนด
    public void set(int position, Object value) {
        Node current_node = head;
        int current_position = 0;
        while (current_node != null && current_position < position) {
            current_node = current_node.next;
            current_position++;
        }
        if (current_node != null) {
            current_node.data = value; // เปลี่ยนค่าข้อมูลใหม่
        }
    }

    // ข้อ 11: Method สำหรับลบข้อมูลทั้งหมดทิ้ง
    public void clear() {
        head = null; // ตัดการเชื่อมต่อตัวแรก ข้อมูลทั้งหมดจะถูกล้างทิ้ง
    }

} // <- ต้องอยู่ก่อนปีกกาปิดตัวสุดท้ายของ Class นี้ครับ