
public class NumberLinkedList {

    public static void main(String[] args) {

        LinkedList numbers = new LinkedList();

        numbers.insert(0, 37);
        numbers.insert(0, 7);
        numbers.insert(0, 4);
        numbers.insert(0, 16);

        System.out.print(numbers.traversal());

    }

}