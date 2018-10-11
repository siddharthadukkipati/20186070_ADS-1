import java.util.Scanner;
class BookDetails implements Comparable {
	private String name;
	private String author;
	private float price;

	BookDetails(String bookname, String bookauthor, float bookprice) {
		this.name = bookname;
		this.author = bookauthor;
		this.price = bookprice;
	}
	public String getName() {
		return this.name;
	}
	public String getAuthor() {
		return this.author;
	}
	public float getPrice() {
		return this.price;
	}
	public int compareTo(Object object) {
		BookDetails that = (BookDetails) object;
		return this.name.compareTo(that.name);
	}
}


class Node {
	public BookDetails key;
	public int val;
	public Node left, right;
	//private int size;

	public Node(BookDetails key, int val) {
		this.key = key;
		this.val = val;
		left = null;
		right = null;
		//this.size = size;
	}
}

class BinarySearchTree {
	//BookDetails dobj = new BookDetails();
	private Node root;

	BinarySearchTree() {
		root = null;
	}
	public Node root() {
		return root;
	}
	public int get(BookDetails key) {
		//System.out.println("hello");
		Node x = root;
		while (x != null) {
			int cmp = key.compareTo(x.key);
			if (cmp < 0) {
				x = x.left;
			} else if (cmp > 0) {
				x = x.right;
			} else if (cmp == 0) {
				return x.val;
			}
		}
		return -1;
	}
	public void put(BookDetails key, int val) {
		//System.out.println(key.getName()+"put 2 ints "+val);
		root = put(root, key, val);
	}
	private Node put(Node x, BookDetails key, int val) {
		if (x == null) {
			return new Node(key, val);
			//break;
		}
		// System.out.println(key+" "+x.key);
		int cmp = key.compareTo(x.key);
		//System.out.println(cmp);
		if (cmp < 0) {
			x.left = put(x.left, key, val);
		} else if (cmp > 0) {
			x.right = put(x.right, key, val);
		} else if (cmp == 0) {
			x.val = val;
			//System.out.println("Replaced");
		}
		return x;
	}


}
public final class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinarySearchTree bstobj = new BinarySearchTree();
		while (sc.hasNextLine()) {
			String[] tokens = sc.nextLine().split(",");
			switch (tokens[0]) {
			case "put":
				BookDetails deobj = new BookDetails(tokens[1], tokens[2], Float.parseFloat(tokens[2 + 1]));
				bstobj.put(deobj, Integer.parseInt(tokens[2 + 2]));
				break;
			case "get":
				//bstobj.get(deobj);
				deobj = new BookDetails(tokens[1], tokens[2], Float.parseFloat(tokens[2 + 1]));
				if (bstobj.get(deobj) == -1) {
					System.out.println("null");
				} else {
					System.out.println(bstobj.get(deobj));
				}
				break;
			default:
				break;
			}
		}
	}
}
