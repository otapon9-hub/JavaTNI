import javax.swing.JOptionPane;

public class Lab505 {

    public static boolean is_palindrome(String word) {
        if (word == null || word.length() == 0) return false;

        String lowerWord = word.toLowerCase();

        int left = 0;
        int right = lowerWord.length() - 1;

        while (left < right) {
            if (lowerWord.charAt(left) != lowerWord.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String word = JOptionPane.showInputDialog(null,
                "Enter some word:",
                "Input",
                JOptionPane.QUESTION_MESSAGE);

        if (word != null) {
            boolean result = is_palindrome(word);

            if (result) {
                JOptionPane.showMessageDialog(null, word + " is Palindrome");
            } else {
                JOptionPane.showMessageDialog(null, word + " is NOT Palindrome");
            }
        }
    }
}