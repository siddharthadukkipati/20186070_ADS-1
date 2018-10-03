import java.util.Scanner;
/**
 * Class for merge.
 */
class Merge {
    /**
     * cutoff to insertion sort.
     */
    private final int x = 7;
    /**
     * Constructs the object.
     */
    Merge() {
        //Unused Constructor.
    }
    /**
     * merge method.
     * time complexity is N.
     * @param      array  The array
     * @param      aux    The auxiliary
     * @param      low    The low
     * @param      mid    The middle
     * @param      high   The high
     */
    public void merge(final Comparable[] array, final Comparable[] aux,
        final int low, final int mid, final int high) {
        assert isSorted(array, low, mid);
        assert isSorted(array, mid + 1, high);
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                aux[k] = array[j++];
            } else if (j > high) {
                aux[k] = array[i++];
            } else if (less(array[j], array[i])) {
                aux[k] = array[j++];
            } else {
                aux[k] = array[i++];
            }
        }
        assert isSorted(aux, low, high);
    }
    /**
     *sorting the elements recursively.
     *time complexity is logN.
     * @param      array  The array
     * @param      aux    The auxiliary
     * @param      low    The low
     * @param      high   The high
     */
    public void sort(final Comparable[] array, final Comparable[] aux,
        final int low, final int high) {
        if (high <= low + x) {
            insertionSort(aux, low, high);
            System.out.println("Insertion sort method invoked...");
            return;
        }
        int mid = low + (high - low) / 2;
        sort(aux, array, low, mid);
        sort(aux, array, mid + 1, high);
        if (!less(array[mid + 1], array[mid])) {
            for (int i = low; i <= high; i++) {
                aux[i] = array[i];
            }
            System.out.println(
                "Array is already sorted. So, skipped the call to merge...");
            return;
        }
        merge(array, aux, low, mid, high);
    }
    /**
     *
     * sort method.
     * @param      a comparable
     */
    public void sort(final Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length - 1);
        assert isSorted(a);
    }
    /**
     * insertion sort algorithm.
     *to sort array with size less than 7.
     *time complexity is N^2/2
     * @param      a    comparable type.
     * @param      low   The low
     * @param      high  The high
     */
    public void insertionSort(final Comparable[] a,
        final int low, final int high) {
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low && less(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
            }
        }
    }
    /**
     * exchange method.
     *
     * @param      a comparable type
     * @param      i integer
     * @param      j integer
     */
    public void exchange(final Comparable[] a,
        final int i, final int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    /**
     * comparing method.
     *
     * @param      i comparable type.
     * @param      j comparable type.
     *
     * @return    boolean.
     */
    public boolean less(final Comparable i, final Comparable j) {
        return i.compareTo(j) < 0;
    }
    /**
     * Determines if sorted.
     *
     * @param      a array
     *
     * @return     True if sorted, False otherwise.
     */
    public boolean isSorted(final Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }
    /**
     * Determines if sorted.
     *
     * @param      a     array
     * @param      low   The low
     * @param      high  The high
     *
     * @return     True if sorted, False otherwise.
     */
    public boolean isSorted(final Comparable[] a,
        final int low, final int high) {
        for (int i = low + 1; i <= high; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
    /**
     * to String method.
     *
     * @param      array  The array
     *
     * @return    string
     */
    public String toString(final Comparable[] array) {
        String str = "[";
        int i;
        for (i = 0; i < array.length - 1; i++) {
            str += array[i] + ", ";
        }
        str += array[i] + "]";
        return str;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     * Time complexity of thighs method is O(1).
     */
    private Solution() {
        //Unused Constructor.
    }
    /**
     * Client Program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Merge mergebj = new Merge();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            mergebj.sort(tokens);
            System.out.println(mergebj.toString(tokens));
            System.out.println();
        }
    }
}
