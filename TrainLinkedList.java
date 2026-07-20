public class TrainLinkedList {
    public static void main(String[] args) {
        // สร้าง Object ของ Class LinkedList ชื่อ greenline
        LinkedList greenline = new LinkedList();

        // ลำดับที่ 1-3: เพิ่มสถานี หมอชิต, อารีย์, สนามเป้า ต่อท้ายรายการ
        greenline.insert("Mo-chit");
        greenline.insert("Ari");
        greenline.insert("Sanam-Pao");

        // ลำดับที่ 4: แสดงรายการสถานีทั้งหมดที่เพิ่มเข้าโปรแกรม
        System.out.println("All Stations : " + greenline.traversal());

        // ลำดับที่ 5: แทรกสถานีราชครู (Rachakru) ระหว่างสถานี อารีย์ (index 1) กับ สนามเป้า (index 2) -> จึงแทรกที่ตำแหน่ง 2
        greenline.insert(2, "Rachakru");

        // ลำดับที่ 6: แสดงรายการสถานีทั้งหมด ณ ปัจจุบัน
        System.out.println("All Stations : " + greenline.traversal());

        // ลำดับที่ 7: แสดงจำนวนสถานีใน Linked List
        System.out.println("Total Station: " + greenline.length());

        // ลำดับที่ 8: แสดงชื่อสถานีแรกใน Linked List (ตำแหน่งที่ 0)
        System.out.println("First Station: " + greenline.get(0));

        // ลำดับที่ 9: สถานี หมอชิต เปลี่ยนชื่อเป็น Mo-Chit (Central Ladprao) -> แก้ไขข้อมูลตำแหน่งที่ 0
        greenline.set(0, "Mo-Chit (Central Ladprao)");

        // ลำดับที่ 10: แสดงรายการสถานีทั้งหมด ณ ปัจจุบัน
        System.out.println("All Stations : " + greenline.traversal());

        // ลำดับที่ 11: ยกเลิกสถานีราชครู -> ลบข้อมูลในตำแหน่งที่ 2
        greenline.remove(2);

        // ลำดับที่ 12: แสดงรายการสถานีทั้งหมด ณ ปัจจุบัน
        System.out.println("All Stations : " + greenline.traversal());

        // ลำดับที่ 13: ยกเลิกสถานีปลายทาง (ตัวสุดท้าย)
        greenline.removelastElement();

        // ลำดับที่ 14: แสดงรายการสถานีทั้งหมด ณ ปัจจุบัน
        System.out.println("All Stations : " + greenline.traversal());

        // ลำดับที่ 15: ยกเลิกสถานีรถไฟฟ้าสายสีเขียวทั้งหมด
        greenline.clear();

        // ลำดับที่ 16: แสดงจำนวนสถานีทั้งหมด หลังจากยกเลิกรถไฟฟ้าสายสีเขียว
        System.out.println("Total Station: " + greenline.length());

        // ลำดับที่ 17: แสดงรายการสถานีทั้งหมด ณ ปัจจุบัน
        System.out.println("All Stations : " + greenline.traversal());
    }
}