import java.util.Arrays;
public class Test {

	public void sort(Integer[] tournamentArray) {
		for (int i = 0; i < tournamentArray.length; i++) {
			Integer min = i;
			for (int j = i + 1; j < tournamentArray.length; j++) {
				if (tournamentArray[j].compareTo(tournamentArray[min]) < 0) {
					min = j;
				}
			}
			exchange(tournamentArray, i, min);
		}
	}

	public void exchange(Integer[] a, Integer i, Integer j) {
		Integer swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	public static void main(String[] args) {
		Integer[] a = new Integer[] {1, 4, 2, 3, 5, 9, 8};
		System.out.println(Arrays.toString(a));
		new Test().sort(a);
		System.out.println(Arrays.toString(a));

	}

}