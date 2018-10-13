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
     * Gets the stock name.
     *
     * @return     The stock name.
     */
    public String getStockName() {
        return this.stockName;
    }
    /**
     * Gets the stock change.
     *
     * @return     The stock change.
     */
    public float getStockChange() {
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
        BinarySearchTree<String, Integer> maxST
        = new  BinarySearchTree<>();
        BinarySearchTree<String, Integer> minST
        = new BinarySearchTree<>();
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
            Stock maxHour = maxpqObj.max();

            Stock minHour = minpqObj.min();

            for (Stock aximumStock : maxpqObj) {
                // System.out.println(aximumStock + "aximumStock");
                if (aximumStock.compareTo(maxHour) == 0) {
                    if (!maxST.contains(aximumStock.getStockName())) {
                         maxST.put(aximumStock.getStockName(), 1);
                    }
                    int value = maxST.get(aximumStock.getStockName());
                    maxST.put(aximumStock.getStockName(), value++);
                } else {
                    maxST.put(aximumStock.getStockName(), 0);
                }
            }
            for (Stock minimumStock : minpqObj) {
                if (minimumStock.compareTo(minHour) == 0) {
                     if (!minST.contains(minimumStock.getStockName())) {
                         minST.put(minimumStock.getStockName(), 1);
                     }
                    int valuemin = minST.get(minimumStock.getStockName());
                    minST.put(minimumStock.getStockName(), valuemin++);
                } else {
                    minST.put(minimumStock.getStockName(), 0);
                }
            }
            for (int j = 0; j < five; j++) {
                Stock maxPQBest = maxpqObj.delMax();
                System.out.println(maxPQBest);
            }
            System.out.println();
            for (int k = 0; k < five; k++) {
                Stock minPQWorst = minpqObj.delMin();
                System.out.println(minPQWorst);
            }
            System.out.println();
        }
        int queryLength = Integer.parseInt(scan.nextLine());
        for (int l = 0; l < queryLength; l++) {
            String[] queryTokens = scan.nextLine().split(",");
            if (queryTokens[0].equals("get")) {
                if (queryTokens[1].equals("maxST")) {
                    // System.out.println(maxST.get(queryTokens[2]));
                } else {
                    // System.out.println(minST.get(queryTokens[2]));
                }
            }
        }

    }
}

