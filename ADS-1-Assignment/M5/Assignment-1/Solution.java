import java.util.Scanner;

class LinkedList {
	LinkedList() {
	}
	Node first = null;
	public class Node {
		Node() {
		}
		int item;
		Node next;
		Node(int inputItem) {
			this.item = inputItem;
		}
	}
	public int top() {
		return first.item;
	}
	public void push(int item) {
		Node nextAddress = new Node(item);
		nextAddress.next = first;
		first = nextAddress;
	}
	public int pop() {
		int output = first.item;
		first = first.next;
		return output;
	}

	public boolean isEmpty() {
		return first == null;
	}
	public String print() {
		Node head = first;
		String storage = "";
		while(head != null) {
			storage = storage + head.item;
			head = head.next;
		}
		return storage;
	}

}

class AddLargeNumbers {
    
    public static LinkedList numberToDigits(final String number) {
    	LinkedList numberToDigits = new LinkedList();
    	for(int i = number.length()-1; i >= 0; i--) {
    		String elementConverstion = "" + number.charAt(i);
    		numberToDigits.push(Integer.parseInt(elementConverstion));
    	}
    	return numberToDigits;
    }

    public static String digitsToNumber(final LinkedList list) {
    	return list.print();
    }

    // public static LinkedList addLargeNumbers(final LinkedList list1, final LinkedList list2) {

    // }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            // case "addLargeNumbers":
            //     pDigits = AddLargeNumbers.numberToDigits(p);
            //     qDigits = AddLargeNumbers.numberToDigits(q);
            //     LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
            //     System.out.println(AddLargeNumbers.digitsToNumber(result));
            //     break;
        }
    }
    
}
