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
		inputStr = inputStr + this.stockName + this.stockChange;
		return inputStr;
	}
}
class Solution {
	private Solution() {
		//unused.
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int stockLength = Integer.parseInt(scan.nextLine());
		final int six = 6;
		for (int i = 0; i < six; i++) {
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

			BinarySearchTree<String, Float> stockbest = new  BinarySearchTree<>();
			BinarySearchTree<String, Float> stockworst = new BinarySearchTree<>();
			final int five = 5;
			for (int j = 0; j < five; j++) {
				Stock maxpqbest = maxpqObj.delMax();
				stockbest.put(maxpqbest.getStockName(), maxpqbest.getStockChange());
				Stock minpqworst = minpqObj.delMin();
				stockworst.put(minpqworst.getStockName(), minpqworst.getStockChange());
			}
			stockbest.print();
			System.out.println();
			stockworst.print();
			System.out.println();
		}
	}
}