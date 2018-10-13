import java.util.Scanner;
/**
 * Class for stock.
 */
class Stock implements Comparable<Stock> {
    /**
     * { var_description }.
     */
    private String stockName;
    /**
     * { var_description }.
     */
    private float stockChange;
    /**
     * Constructs the object.
     *
     * @param      name    The name
     * @param      change  The change
     */
    Stock(final String name, final float change) {
        this.stockName = name;
        this.stockChange = change;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public String getstockname() {
        return this.stockName;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public float getstockchange() {
        return this.stockChange;
    }
    /**
     * { function_description }.
     *
     * @param      other  The other
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Stock other) {
        if (this.stockChange > other.stockChange) {
            return 1;
        }
        if (this.stockChange < other.stockChange) {
            return -1;
        }
        if (this.stockName.compareTo(other.stockName) > 0) {
            return 1;
        }
        if (this.stockName.compareTo(other.stockName) < 0) {
            return -1;
        }
        return 0;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String inputStr = "";
        inputStr = inputStr + this.stockName + " " + this.stockChange;
        return inputStr;
    }
}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int stockLength = Integer.parseInt(scan.nextLine());
        final int six = 6;
        final int five = 5;
        for (int i = 0; i < six; i++) {
            int count = 0;
            MinPQ<Stock> minpqObj = new MinPQ<>();
            MaxPQ<Stock> maxpqObj = new MaxPQ<>();
            while (count < stockLength) {
                String[] tokens = scan.nextLine().split(",");
                Stock stockObj = new Stock(tokens[0],
                    Float.parseFloat(tokens[1]));
                minpqObj.insert(stockObj);
                maxpqObj.insert(stockObj);
                count++;
            }
            BinarySearchTree<String, Float> bestPerformer
            = new  BinarySearchTree<>();
            for (int j = 0; j < five; j++) {
                Stock maxpqBest = maxpqObj.delMax();
                System.out.println(maxpqBest);
                bestPerformer.put(maxpqBest.getstockname(),
                    maxpqBest.getstockchange());
            }
            System.out.println();
            BinarySearchTree<String, Float> worstPerformer
            = new BinarySearchTree<>();
            for (int k = 0; k < five; k++) {
                Stock minpqWorst = minpqObj.delMin();
                System.out.println(minpqWorst);
                worstPerformer.put(minpqWorst.getstockname(),
                    minpqWorst.getstockchange());
            }
            System.out.println();
            bestPerformer.print();
            System.out.println();
            worstPerformer.print();
            System.out.println();
        }
    }
}

