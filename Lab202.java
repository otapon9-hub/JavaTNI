import java.util.Scanner;

public class Lab202 {
    public static void main(String[] args) {

        Scanner sn= new Scanner(System.in);

        System.out.print("Enter number 1: ");
        double namber1 = sn.nextDouble();

        System.out.print("Enter number 2: ");
        double number2 = sn.nextDouble();

        System.out.println("Summation = " + (namber1 + number2));
        System.out.println("Subtraction = " + (namber1 - number2));
        System.out.println("Multiplication = " + (namber1 * number2));
        System.out.println("Division = " + (namber1 / number2));
        System.out.println("Modulus = " + (namber1 % number2));

        sn.close();
    }
}