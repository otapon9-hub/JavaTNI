import java.util.Scanner;

public class Lab308 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many number to input: ");
        int howMany = scanner.nextInt();

        int maximum = 0;
        int minimum = 0;
        int evenCount = 0;
        int oddCount = 0;

        int currentNumber;


        for (int i = 1; i <= howMany; i++) {
            System.out.print("Enter number " + i + ": ");
            currentNumber = scanner.nextInt();

            if (i == 1) {
                maximum = currentNumber;
                minimum = currentNumber;
            } else {
                if (currentNumber > maximum) {
                    maximum = currentNumber;
                }
                if (currentNumber < minimum) {
                    minimum = currentNumber;
                }
            }

            if (currentNumber % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("-------------------------"); // เพิ่มเส้นแบ่งเพื่อให้ดูง่าย
        System.out.println("Maximum = " + maximum);
        System.out.println("Minimum = " + minimum);
        System.out.println("Even number = " + evenCount);
        System.out.println("Odd number = " + oddCount);

        scanner.close();
    }
}