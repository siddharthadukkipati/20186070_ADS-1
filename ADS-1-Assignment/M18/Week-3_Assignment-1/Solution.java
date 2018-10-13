import java.util.Scanner;
class Stock implements Comparable<Stock> {
    private String stockName;
    private float stockChange;
    Stock(String name, float change) {
        this.stockName = name;
        this.stockChange = change;
    }
    public String getStockName() {
        return this.stockName;
    }
    public float getStockChange() {
        return this.stockChange;
    }
    public int compareTo(Stock other) {
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
    public String toString() {
        String inputStr = "";
        inputStr = inputStr + this.stockName + " " + this.stockChange;
        return inputStr;
    }
}
class Solution {
    private Solution() {
        //unused.
    }
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        BinarySearchTree<String, Integer> maxST = new  BinarySearchTree<>();
        BinarySearchTree<String, Integer> minST = new BinarySearchTree<>();
        int stockLength = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < 6; i++) {
            int count = 0;
            MinPQ<Stock> minpqObj = new MinPQ<>();
            MaxPQ<Stock> maxpqObj = new MaxPQ<>();
            while (count < stockLength) {
                String[] tokens = scan.nextLine().split(",");
                Stock stockObj = new Stock(tokens[0], Float.parseFloat(tokens[1]));
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
            for (int j = 0; j < 5; j++) {
                Stock maxPQBest = maxpqObj.delMax();
                System.out.println(maxPQBest);
            }
            System.out.println();
            for (int k = 0; k < 5; k++) {
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
                    System.out.println(maxST.get(queryTokens[2]));
                } else {
                    System.out.println(minST.get(queryTokens[2]));
                }
            }
        }

    }
}

