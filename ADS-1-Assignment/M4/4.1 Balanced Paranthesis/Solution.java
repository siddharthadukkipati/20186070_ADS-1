/**
*importing Scanner class from java.util.Scanner.
*/
import java.util.Scanner;
/**
*Linked Stack of Strings.
*/
class LinkedStackOfStrings {
    /**
    *Deafult constructor.
    */
    LinkedStackOfStrings() {
    }
    /**
    *Declaring a node.
    */
    private Node first = null;
    /**
    *Node class.
    */
    private class Node {
        /**
        *character type data type.
        */
        private char item;
        /**
        *Node.
        */
        private Node nextAddress;
    }
    /**
    *Top which return the top value.
    *@return first.item which returns first item.
    */
    public char top() {
        return first.item;
    }
    /**
    *checks if the Stack is empty.
    *@return returns true if the stack is empty.
    */
    public boolean isEmpty() {
        return first == null;
    }
    /**
    *Pushes the item into the stack.
    *@param item characters data type which we push into the stack.
    */
    public void push(final char item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.nextAddress = oldfirst;
    }
    /**
    *pop which removes the last element from the stack.
    *@return item which is of type character.
    */
    public char pop() {
        char item = first.item;
        first = first.nextAddress;
        return item;
    }
}
/**
*Soultion class which helps to read the main method based on input.
*/
public final class Solution {

    /**
    *checks the paranthesis.
    *returns a boolean value if the paranthesis is followed.
    */
    private Solution() {

    }
    /**
    *checks the paranthesis.
    *returns a boolean value if the paranthesis is followed.
    *@param s String type which is the input.
    *@return returns the true if the condition satisfies.
    */
    public static boolean checkParanthesis(final String s) {
        LinkedStackOfStrings obj = new LinkedStackOfStrings();
        int sLength = s.length();
        for (int i = 0; i < sLength; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                obj.push(ch);
            } else {
                if(obj.isEmpty()) return false;
                if (ch == ')' && obj.top() == '(') {
                obj.pop();
                } else if (ch == '}' && obj.top() == '{') {
                obj.pop();
                } else if (ch == ']' && obj.top() == '[') {
                obj.pop();
                } else {
                    return false;
                }
            }
        }
    return obj.isEmpty();
    }
    /**
    *main method which stores the main method.
    *@param args String data type.
    */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < size; i++) {
            String line = sc.next();
            if (checkParanthesis(line)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
