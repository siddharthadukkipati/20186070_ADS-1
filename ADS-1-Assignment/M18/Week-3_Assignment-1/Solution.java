import java.util.Scanner;
class Stock implements Comparable<Stock> {
	private String stockName;
	private float stockChange;
	Stock(String name, float change) {
		this.stockName = name;
		this.stockChange = change;
	}
	public String getstockname() {
		return this.stockName;
	}
	public float getstockchange() {
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
		inputStr = inputStr + this.stockName + " " +this.stockChange;
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
		final int five = 5;
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
			BinarySearchTree<String, Float> bestPerformer = new  BinarySearchTree<>();
			for (int j = 0; j < five; j++) {
				Stock maxpqBest = maxpqObj.delMax();
				System.out.println(maxpqBest);
				bestPerformer.put(maxpqBest.getstockname(), maxpqBest.getstockchange());
			}
			System.out.println();
			BinarySearchTree<String, Float> worstPerformer = new BinarySearchTree<>();
			for(int k = 0; k < five; k++) {
				Stock minpqWorst = minpqObj.delMin();
				System.out.println(minpqWorst);
				worstPerformer.put(minpqWorst.getstockname(), minpqWorst.getstockchange());
			}
			System.out.println();
			// bestPerformer.print();
			// System.out.println();
			// worstPerformer.print();
			// System.out.println();
		}
	}
}
