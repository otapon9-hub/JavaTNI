import java.util.Scanner;

public class CakeOrder {
    public static void main(String[] args) {
        // 1. แก้คำผิด Sacanner -> Scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("Birthday Cake's Details:");
        System.out.print("Enter a message on cake: ");
        // 2. เปลี่ยน System -> String (สำคัญมาก!)
        String message = scanner.nextLine();

        System.out.print("Enter a flavor: ");
        // 2. เปลี่ยน System -> String
        String flavor = scanner.next();

        System.out.print("How many pounds: ");
        double pound = scanner.nextDouble();

        // 3. ลบ uniPrice: ออก ใส่แค่ตัวเลข
        BirthdayCake order1 = new BirthdayCake(message, pound, flavor, 350);

        System.out.println(order1);

        System.out.println("Cup Cake's Details:");
        System.out.print("Enter a flavor: ");
        // 2. เปลี่ยน System -> String
        String cup_flavor = scanner.next();

        System.out.print("How many pieces: ");
        int piece = scanner.nextInt();

        // 3. ลบ uniPrice: ออก ใส่แค่ตัวเลข
        CupCake order2 = new CupCake(piece, cup_flavor, 65);

        System.out.println(order2);

        System.out.println("Donut's Details:");
        System.out.print("Enter a flavor: ");
        String donut_flavor = scanner.next();

        System.out.print("How many donuts: ");
        int donut_quantity = scanner.nextInt();

        Donut order3 = new Donut(donut_flavor, 30, donut_quantity);
        System.out.println(order3);

        // 4. ย้ายวงเล็บปิดไปไว้ท้ายสุด
        System.out.println("Total price = " +
                (order1.getUnitPrice() * pound + order2.getUnitPrice() * piece + order3.getUnitPrice() * order3.getTo()));
    }
}