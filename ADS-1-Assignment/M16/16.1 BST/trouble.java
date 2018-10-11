import java.util.Scanner;
/**
 * Class for book details.
 */
class BookDetails implements Comparable {
    /**
     * { var_description }.
     */
    private String name;
    /**
     * { var_description }.
     */
    private String author;
    /**
     * { var_description }.
     */
    private float price;
    /**
     * Constructs the object.
     *
     * @param      bookname    The bookname
     * @param      bookauthor  The bookauthor
     * @param      bookprice   The bookprice
     */
    BookDetails(final String bookname, final String bookauthor,
        final float bookprice) {
        this.name = bookname;
        this.author = bookauthor;
        this.price = bookprice;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Gets the author.
     *
     * @return     The author.
     */
    public String getAuthor() {
        return this.author;
    }
    /**
     * Gets the price.
     *
     * @return     The price.
     */
    public float getPrice() {
        return this.price;
    }
    /**
     * { function_description }.
     *
     * @param      object  The object
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Object object) {
        BookDetails that = (BookDetails) object;
        return this.name.compareTo(that.name);
    }
}
/**
 * Class for node.
 */
class Node {
    /**
     * { var_description }.
     */
    public BookDetails key;
    /**
     * { var_description }.
     */
    public int val;
    /**
     * { item_description }.
     */
    public Node left, right;
    /**
     * Constructs the object.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public Node(final BookDetails key, final int val) {
        this.key = key;
        this.val = val;
        left = null;
        right = null;
        //this.size = size;
    }
}
/**
 * Class for binary search tree.
 */
class BinarySearchTree {
    /**
     * { var_description }.
     */
    private Node root;
    /**
     * Constructs the object.
     */
    BinarySearchTree() {
        root = null;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public Node root() {
        return root;
    }
    /**
     * { function_description }.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public int get(final BookDetails key) {
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
    /**
     * { function_description.
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final BookDetails key, final int val) {
        //System.out.println(key.getName()+"put 2 ints "+val);
        root = put(root, key, val);
    }
    /**
     * { function_description }.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     * @param      val   The value
     *
     * @return     { description_of_the_return_value }
     */
    private Node put(final Node x, final BookDetails key, final int val) {
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
/**
 * { item_description }.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree bstobj = new BinarySearchTree();
        while (sc.hasNextLine()) {
            String[] tokens = sc.nextLine().split(",");
            switch (tokens[0]) {
            case "put":
                BookDetails deobj = new BookDetails(tokens[1], tokens[2],
                    Float.parseFloat(tokens[2 + 1]));
                bstobj.put(deobj, Integer.parseInt(tokens[2 + 2]));
                break;
            case "get":
                //bstobj.get(deobj);
                deobj = new BookDetails(tokens[1], tokens[2],
                    Float.parseFloat(tokens[2 + 1]));
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
