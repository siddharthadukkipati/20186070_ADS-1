import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        // Constructor.
    }
    /**
     * {Client Program}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        LinearProbingHashST<String, Integer> hash;
        int lines = Integer.parseInt(scan.nextLine());
        hash = new LinearProbingHashST<String, Integer>();
        while (lines > 0) {
            String[] tokens = scan.nextLine().split(" ");
            switch (tokens[0]) {
            case "put":
                hash.put(tokens[1], Integer.parseInt(tokens[2]));
                break;
            case "get":
                System.out.println(hash.get(tokens[1]));
                break;
            case "delete":
                hash.delete(tokens[1]);
                break;
            case "display":
                try {
                    hash.display();
                } catch (Exception e) {
                    System.out.println("{}");
                }
                break;
            default:
                break;
            }
            lines--;
        }
    }
}
