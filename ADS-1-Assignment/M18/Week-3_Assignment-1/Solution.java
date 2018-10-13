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
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
	public float getstockChange() {
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
 * { item_description }.
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
		BinarySearchTree<String, Integer> maxST =
        new  BinarySearchTree<>();
		BinarySearchTree<String, Integer> minST =
        new BinarySearchTree<>();
		int stockLength = Integer.parseInt(scan.nextLine());
		final int six = 6;
        final int five = 5;
        for (int i = 0; i < six; i++) {
			int count = 0;
			MinPQ<Stock> minPQObj = new MinPQ<>();
			MaxPQ<Stock> maxPQObj = new MaxPQ<>();
			while (count < stockLength) {
				String[] stockTokens = scan.nextLine().split(",");
				Stock stockobj = new Stock(stockTokens[0],
                    Float.parseFloat(stockTokens[1]));
				minPQObj.insert(stockobj);
				maxPQObj.insert(stockobj);
				count++;
			}
			for (int j = 0; j < five; j++) {
				Stock maxpqBest = maxPQObj.delMax();
				if (maxST.contains(maxpqBest.getStockName())) {
					int value = maxST.get(maxpqBest.getStockName());

					maxST.put(maxpqBest.getStockName(), ++value);

				} else {
					maxST.put(maxpqBest.getStockName(), 1);
				}
				System.out.println(maxpqBest);
			}
			System.out.println();
			for (int k = 0; k < five; k++) {
				Stock minpqWorst = minPQObj.delMin();
				if (minST.contains(minpqWorst.getStockName())) {
					int valuemin = minST.get(minpqWorst.getStockName());
					minST.put(minpqWorst.getStockName(), ++valuemin);
				} else {
					minST.put(minpqWorst.getStockName(), 1);
				}
				System.out.println(minpqWorst);
			}
			System.out.println();
		}
		int queryLength = Integer.parseInt(scan.nextLine());
		for (int l = 0; l < queryLength; l++) {
			String[] queryTokens = scan.nextLine().split(",");
			if (queryTokens[0].equals("get")) {
				if (queryTokens[1].equals("maxST")) {
					if(!maxST.contains(queryTokens[2])) {
						System.out.println("0");
					} else {
						System.out.println(maxST.get(queryTokens[2]));
					}
				} else {
					if (!minST.contains(queryTokens[2])) {
						System.out.println("0");
					} else {
						System.out.println(minST.get(queryTokens[2]));
					}
				}
			}
		}

	}
}
