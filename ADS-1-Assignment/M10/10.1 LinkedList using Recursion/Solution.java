import java.util.Scanner;
/**
 * Class for node.
 */
class Node {
    /**
     * variable declarartion.
     */
    private int item;
    /**
     * variable declarartion.
     */
    private Node next;
    /**
     * Constructs the object.
     *
     * @param      data  The data
     */
    Node(final int data) {
        item = data;
        next = null;
    }
    /**
     * Gets the item.
     *
     * @return     The item.
     */
    public int getItem() {
        return item;
    }
    /**
     * Gets the next.
     *
     * @return     The next.
     */
    public Node getNext() {
        return next;
    }
    /**.
     * Sets the next.
     *
     * @param      item1  The item
     */
    public void setNext(final Node item1) {
        this.next = item1;
    }
}
/**
 * List of linkeds.
 */
class LinkedList {
    /**
     * variable declaration.
     */
    private Node head;
    /**
     * variable declaration.
     */
    private int size;
    /**
     * Constructs the object.
     */
    LinkedList() {
        head = null;
        size = 0;
    }
    /**
     *size of list.
     *
     * @return length.
     */
    public int length() {
        return size;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }
    /**
     * insert at position.
     *
     * @param      position  The position
     * @param      item1     The item 1
     */
    public void insertAt(final int position, final int item1) {
        insertAt(head, position, item1);
    }
    /**
     * insert at position.
     *
     * @param      node      The node
     * @param      position  The position
     * @param      item1     The item 1
     */
    private void insertAt(final Node node,
                          final int position, final int item1) {
        if (position == 0 && head == null) {
            head = new Node(item1);
        } else if (position == 0 && head != null) {
            Node oldhead = head;
            head = new Node(item1);
            head.setNext(oldhead);
        } else {
            Node temp = head;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.getNext();
            }
            Node nextNode = temp.getNext();
            Node node1 = new Node(item1);
            temp.setNext(node1);
            node1.setNext(nextNode);
        }
        size++;
    }
    /**
     * reverse.
     */
    public void reverse() {
        head = reverse(head);
    }
    /**
     *reverse of list.
     *
     * @param      head1  The head
     *
     * @return  node.
     */
    private Node reverse(final Node head1) {
        if (head1 == null || head1.getNext() == null) {
            return head1;
        }
        Node temp = reverse(head1.getNext());
        head1.getNext().setNext(head1);
        head1.setNext(null);
        return temp;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        if (size != 0) {
            Node temp = head;
            while (temp != null) {
                s += temp.getItem() + ", ";
                temp = temp.getNext();
            }
        }
        return s.substring(0, s.length() - 2);
    }

}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * client program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList llobj = new LinkedList();
        while (sc.hasNext()) {
            String[] tokens = sc.nextLine().split(" ");
            switch (tokens[0]) {
            case "insertAt":
                if (Integer.parseInt(tokens[1]) < 0 || Integer.parseInt(
                            tokens[1]) > llobj.length() + 1) {
                    System.out.println("Can't insert at this position.");
                } else {
                    llobj.insertAt(Integer.parseInt(tokens[1]),
                                   Integer.parseInt(tokens[2]));
                    System.out.println(llobj.toString());
                }
                break;
            case "reverse":
                if (!llobj.isEmpty()) {
                    llobj.reverse();
                    System.out.println(llobj.toString());
                } else {
                    System.out.println("No elements to reverse.");
                    break;
                }
            default:
                break;
            }
        }

    }
}
