import java.util.Scanner;
/**
 * Class for sorting.
 */
class Sorting {

    /**.
     * Constructs the object.
     */
    Sorting() {
        /**.
         * { item_description }
         */
    }
// time complexity for this method is N^2.
// In first for loop and second loop it iterates through the size of array
/**.
     *
     *insertion sort for arrays with less size.
     * @param      arr  The arguments
     * @param      low  The arguments
     * @param      high  The arguments
     */
    public void insertion(final Comparable[] arr, final int low,
     final int high) {
        // int i = low;
        // int j = high;
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low && less(arr[j], arr[j - 1]); j--) {
                exchange(arr, j, j - 1);
            }
        }
    }
// time complexity of this method is constant.
    //It exchanges the elements only once.
/**.
     *
     *swap elements.
     * @param      arr  The arguments
     * @param      j  The arguments
     * @param      min  The arguments
     */
    public void exchange(final Comparable[] arr, final int j, final int min) {
        final int ten = 10;
        Comparable temp = arr[j];
        arr[j] = arr[min];
        arr[min] = temp;
    }
// time complexity of this method is N. It iterates through
// the array to print all the objects in array.

    /**.
     * Returns a string representation of the object.
     *
     * @param      arr   The arr
     *
     * @return     String representation of the object.
     */
    public String toString(final Comparable[] arr) {
        // System.out.println("in print");
        String str = "[";
        for (int i = 0; i < arr.length - 1; i++) {
            str += arr[i] + ", ";
        }
        str += arr[arr.length - 1] + "]";
        return str;
    }
// time complexity is log N
/**.
     * sort method.
     *
     * @param      arr  The arguments
     * @param      low  The arguments
     * @param      high  The arguments
     * @param      cutOff  The arguments
     */
    public void sort(final Comparable[] arr, final int low,
     final int high, final int cutOff) {
        if (high <= low + cutOff - 1) {
            insertion(arr, low, high);
            System.out.println("insertionSort called");
            return;
        }
        int k = partition(arr, low, high);
        System.out.println(toString(arr));
        sort(arr, low, k - 1, cutOff);
        sort(arr, k + 1, high, cutOff);
    }
//time complexity is constant

    /**.
     * sort method.
     *
     * @param      array   The array
     * @param      cutOff  The cut off
     */
    public void sort(final Comparable[] array, final int cutOff) {
        sort(array, 0, array.length - 1, cutOff);
    }
// time complexity is N

    /**.
     * partition algorithm.
     *
     * @param      arr   The arr
     * @param      low   The low
     * @param      high  The high
     *
     * @return  partition element.
     */
    public int partition(final Comparable[] arr,
     final int low, final int high) {
        int i = low;
        int j = high + 1;
        while (true) {
            while (less(arr[++i], arr[low])) {
                if (i == high) {
                    break;
                }
            }
            while (less(arr[low], arr[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exchange(arr, i, j);
        }
        exchange(arr, low, j);
        // System.out.println(toString(arr));
        return j;
    }
// time complexity is constant.

    /**.
     * less method.
     *
     * @param      a     comparable.
     * @param      b   comparable.
     *
     * @return   boolean
     */
    public boolean less(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }
}
/**
 * client program.
 */
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
        //unused constructor.
    }
    /**.
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Sorting sort = new Sorting();
        int testcases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testcases; i++) {
            int j = Integer.parseInt(sc.nextLine());
            // sc.nextLine();
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            if (tokens[0].equals("")) {
                System.out.println("[]");
            } else {
                sort.sort(tokens, j);
                System.out.println(sort.toString(tokens));
            }
        }
    }
}
