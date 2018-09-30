import java.util.Scanner;

/**
 * Class for sorted array.
 */
class SortedArray {
    /**
     * firstarray.
     */
    private int[] firstarray;
    /**
     * seconfarray.
     */
    private int[] secondarray;
    /**
     * Constructs the object.
     * @param      a1    A 1
     * @param      a2    A 2
     */
    SortedArray(final int[] a1, final int[] a2) {
        this.firstarray = a1;
        this.secondarray = a2;
    }
    /**
     * getting sorted elements.
     * @param      arr1  The arr 1
     * @param      arr2  The arr 2
     *
     * @return   sorted array
     */
    public String sort(final int[] arr1, final int[] arr2) {
        int i = 0;
        int j = 0, k = 0;
        int[] array = new int[arr1.length + arr2.length];
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                array[k++] = arr1[i++];
            } else {
                array[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            array[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            array[k++] = arr2[j++];
        }
        String res = "";
        int index = 0;
        for (index = 0; index < array.length - 1; index++) {
            res += array[index] + ",";
        } res += array[index];
        return res;
    }
}

/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int size1 = Integer.parseInt(scan.nextLine());
        int size2 = Integer.parseInt(scan.nextLine());
        String[] arraytemp1 = scan.nextLine().split(",");
        String[] arraytemp2 = scan.nextLine().split(",");
        int[] array1 = new int[size1];
        int[] array2 = new int[size2];
        for (int i = 0; i < size1; i++) {
            array1[i] = Integer.parseInt(arraytemp1[i]);
        }
        for (int j = 0; j < size2; j++) {
            array2[j] = Integer.parseInt(arraytemp2[j]);
        }
        SortedArray sa = new SortedArray(array1, array2);
        System.out.println(sa.sort(array1, array2));

    }
}
