import java.util.Scanner;

public class Lab503 {

    public static int count_vowel(String message, char letter) {
        int count = 0;
        char target = Character.toLowerCase(letter);

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (Character.toLowerCase(c) == target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a message: ");
        String message = scan.nextLine();

        System.out.println("\nList of vowel in \"" + message + "\"");

        char[] vowels = {'A', 'E', 'I', 'O', 'U'};

        for (char v : vowels) {
            int count = count_vowel(message, v);

            System.out.println("The letter '" + v + "' appears " + count + " time(s).");
        }

        scan.close();
    }
}