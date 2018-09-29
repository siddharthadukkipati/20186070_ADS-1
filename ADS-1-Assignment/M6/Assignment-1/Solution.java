import java.util.Scanner;
/**
*Class linked list.
*/
class LinkedList {
    /**
    *Default constructor of the above class.
    */
    LinkedList() {
    }
    /**
    *Creating a Node and assigning value to it.
    */
    private Node first = null;
    /**
    *Class Node.
    */
    public class Node {
        /**
        *A default constructor.
        */
        Node() {
        }
        /**
        *Declaring an integer data type.
        */
        private int item;
        /**
        *Creating a node.
        */
        private Node next;
        /**
        *Over ridden constructor.
        *@param inputItem input item.
        */
        Node(final int inputItem) {
            this.item = inputItem;
        }
    }
    /**
    *get the top element in the stack.
    *@return item.
    */
    public int top() {
        return first.item;
    }
    /**
    *pushes the element or item into the stack.
    *@param item input.
    */
    public void push(final int item) {
        Node nextAddress = new Node(item);
        nextAddress.next = first;
        first = nextAddress;
    }
    /**
    *removes the element.
    *@return output.
    */
    public int pop() {
        int output = first.item;
        first = first.next;
        return output;
    }
    /**
    *This method checks if the list is empty.
    *@return true or false.
    */
    public boolean isEmpty() {
        return first == null;
    }
    /**
    *This method converts from digits to numbers.
    *@return Storge which is the converted.
    */
    public String toString() {
        Node head = first;
        String storage = "";
        while (head != null) {
            storage = storage + head.item;
            head = head.next;
        }
        return storage;
    }
}
/**
*this class adds the large numbers.
*/
class AddLargeNumbers {
    /**
    *A deafult constructor.
    */
    private AddLargeNumbers() {
    }
    /**
    *This method reverse's the numbers and Stroe in digits from and retuns.
    *@param number input is given in the form of number.
    *@return numbers in from of digits.
    */
    public static LinkedList numberToDigits(final String number) {
        LinkedList numberToDigits = new LinkedList();
        for (int i = number.length() - 1; i >= 0; i--) {
            String digitConverstion = "" + number.charAt(i);
            numberToDigits.push(Integer.parseInt(digitConverstion));
        }
        return numberToDigits;
    }
    /**
    *this methods retruns the converstion from digits to Number.
    *@param list sends the LinkedList.
    *@return list.
    */
    public static String digitsToNumber(final LinkedList list) {
        return list.toString();
    }
    /**
    *This method should help the adding both the lists.
    */
    // public static LinkedList addLargeNumbers(final LinkedList list1,
    //     final LinkedList list2) {

    // }
}
/**
*This class is used to read the input.
*/
public final class Solution {
    /**
    *A daefult constructor.
    */
    private Solution() {
    }
    /**
    *main method is used to read the inut from the test cases.
    @param args arguments.
    */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;
            // case "addLargeNumbers":
            //     pDigits = AddLargeNumbers.numberToDigits(p);
            //     qDigits = AddLargeNumbers.numberToDigits(q);
                // LinkedList result =
                // AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
            //     System.out.println(AddLargeNumbers.digitsToNumber(result));
            //     break;
            default:
                    break;
        }
    }
}