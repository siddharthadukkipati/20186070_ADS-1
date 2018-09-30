import java.util.Scanner;
//import java.util.Arrays;
/**
 * Class for node.
 */
class Node {
    /**
     * variable.
     */
    int data;
    /**
     * variable.
     */
    Node next;
    /**
     * Constructs the object.
     *
     * @param      value  The value
     */
    Node(final int value) {
        data = value;
        next = null;
    }
    /**
     * Gets the address.
     *
     * @return     The address.
     */
    public Node getAddress() {
        return next;
    }
    /**
     * Sets the address.
     *
     * @param      address  The address
     */
    public void setAddress(final Node address) {
        next = address;
    }
    /**
     * set data.
     *
     * @param      data1  The data 1
     */
    public void setdata(final int data1) {
        data = data1;
    }
}
/**
 * Class for operations.
 */
class Operations {
    /**
     * variable.
     */
     Node head;
    /**
     * variable.
     */
     Node tail;
    /**
     * variable.
     */
     int size;
    /**
     * insert at beginning.
     *
     * @param      data  The data
     */
    public void insertAtHead(final int data) {
        Node start = new Node(data);
        size++;
        if (head == null) {
            head = start;
            tail = start;
            // System.out.println(printList());
            return;
        }
        start.setAddress(head);
        head = start;
        // System.out.println(printList());
        return;
    }
    /**
     * int at position.
     *
     * @param      data     The data
     * @param      element  The element
     */
    public void insertAfterElement(final int data, final int element) {
        Node ins = new Node(element);
        Node temp1 = head;
        int flag = 0;
        while (temp1.data != data) {
            temp1 = temp1.getAddress();
            if (temp1.data == data) {
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            Node temp2 = temp1.getAddress();
            temp1.setAddress(ins);
            ins.setAddress(temp2);
            size++;
        }
    }
    /**
     * insert at end.
     *
     * @param      data  The data
     */
    public void insertAtTail(final int data) {
        Node end = new Node(data);
        size++;
        if (head == null) {
            head = end;
            tail = end;
            return;
        }
        tail.next = end;
        tail = end;
        return;
        // System.out.println(printList());
    }
    /**
     * remove at first.
     */
    public void popAtHead() {
        if (size == 0) {
            System.out.println("Deck is empty");
            return;
        }
        Node temp = head;
        head = head.getAddress();
        temp = null;
        size--;
    }
    /**
     * remove at end.
     */
    public void popAtTail() {
        if (size == 0) {
            System.out.println("Deck is empty");
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.getAddress();
        }
        tail = temp;
        temp.next = null;
        size--;
        // System.out.println(printList());
    }
    /**
     * delete.
     *
     * @param      data  The data
     */
    public void deleteAfterElement(final int data) {
        Node temp = head;
        while (temp.data != data) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }
    /**
     * print.
     *
     * @return string
     */
    public String printList() {
        Node temp = head;
        String str = "[";
        if (size > 0) {
            while (temp.next != null) {
                str += temp.data + ", ";
                temp = temp.getAddress();
            }
            str += temp.data;
        }
        str += "]";
        return str;
    }
    /**
     * size.
     *
     * @return size
     */
    public int size() {
        return size;
    }
    /**
     * int array.
     *
     * @param      m   int
     * @param      size1  The size
     *
     * @return   array
     */
    public int[] josephus(final int m, final int size1) {
        int[] arr = new int[size1];
        Node temp = head;
        int counter = 1;
        int i = 0;
        while (temp.next != null) {
            while (counter != m) {
                insertAtTail(temp.data);
                temp = temp.next;
                popAtHead();
                counter++;
            }
            arr[i++] = temp.data;
            temp = temp.next;
            counter = 1;
            popAtHead();
        }
        arr[i++] = temp.data;
        return arr;
    }
}