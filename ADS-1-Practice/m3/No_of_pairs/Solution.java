import java.util.Scanner;
import java.util.Arrays;
class Noofpairs {
	int[] array;
	int size;
	Noofpairs(int[] arr, int n) {
		this.array = arr;
		this.size = n;
	}
	public int pairs(int[] array, int n) {
		Arrays.sort(array);
		int count = 1;
		int temp = 0;
		for (int i = 1; i < n; i++) {
			if (array[i] == array[i - 1]) {
				count++;
			} else {
				temp = temp + count * (count - 1) / 2;
			}
		}
		temp = temp + count * (count - 1) / 2;
		return temp;
	}

}
public class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = scan.nextInt();
		}
		Noofpairs nof = new Noofpairs(array, n);
		System.out.println(nof.pairs(array, n));

	}
}
