import java.util.Scanner;
/**
*class deque which is a generic type.
*/
class Deque<Item> {
	Node left = null;
	Node right = null;
	int size = 0;
	/**
	*Class node.
	*/
	class Node {
		Item data;
		Node next;
		/**
		*constructor.
		*@param inputdata input data.
		*/
		Node(Item inputdata) {
			this.data = inputdata;
		}
	}
	/**
	*checks if the queue is empty.
	*@return true or false.
	*/
	boolean isEmpty() {
		return size == 0;
	}
	/**
	*This method returns the size of the queue.
	*@return size.
	*/
	int size() {
		return size;
	}
	/**
	*This method pushes the immediate right element in a given queue.
	*/
	void pushLeft(Item inputitem) {
		Node newnode = new Node(inputitem);
		if(isEmpty()) {
			left = newnode;
			right = left;
			size++;
			print();
			return;
		}
		newnode.next = left;
		left = newnode;
		size++;
		print();
	}
	/**
	*This method pushes the immediate right element in a given queue.
	*/
	void pushRight(Item inputitem) {
		if (isEmpty()) {
			pushLeft(inputitem);
			return;
		}
		if (size == 1) {
			left = right;
		}
		Node newnode = new Node(inputitem);
		right.next = newnode;
		right = newnode;
		size++;
		print();
	}
	/**
	*This method removes the immediate left element in a given queue.
	*/
	public Item popLeft() {
		if (isEmpty()) {
			System.out.println("Deck is empty");
			return null;
		}
		Item leftout = left.data;
		left = left.next;
		size--;
		print();
		return leftout;
	}
	/**
	*This method removes the immediate right element in a given queue.
	*/
	public Item popRight() {
		if (isEmpty()) {
			System.out.println("Deck is empty");
			return null;
		}
		Item rightout = right.data;
		Node test = left;
		int counter = 1;
		while (counter < size - 1) {
			test = test.next;
			counter++;
		}
		right = test;
		right.next = null;
		size--;
		print();
		return rightout;
	}
	/**
	*this method is used to print.
	*/
    public void print() {
    	if (isEmpty()) {
    		System.out.println("[]");
    		return;
    	}
    	String str = "";
    	str = str + "[";
    	Node test = left;
    	while(test.next != null) {
    		str = str + test.data + ", ";
    		test = test.next;
    	}
    	str = str + right.data;
    	str = str + "]";
    	System.out.println(str);
    }
}
/**
*This class is to read the input from the testcases.
*/
class Solution {
	/**
	*deafult constructor.
	*/
	Solution() {
	}
	/**
	*main method is used to read the input.
	*@param args passing the arguments.
	*/
	public static void main(final String[] args) {
		Deque<Integer> dequeobj = new Deque<Integer>();
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String line = scan.nextLine();
			String[] tokens = line.split(" ");
			switch (tokens[0]) {
			case "pushLeft":
				dequeobj.pushLeft(Integer.parseInt(tokens[1]));
				break;
			case "pushRight":
				dequeobj.pushRight(Integer.parseInt(tokens[1]));
				break;
			case "size":
				System.out.println(dequeobj.size());
				break;
			case "popRight":
				dequeobj.popRight();
				break;
			case "popLeft":
				dequeobj.popLeft();
				break;
			default:
			}
		}
	}
}