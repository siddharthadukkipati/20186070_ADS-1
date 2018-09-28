import java.util.Scanner;
import java.util.Arrays;
class SortedArray {
    private int[] firstArray;
    private int[] secondArray;
    SortedArray(final int[] a1, final int[] a2) {
        this.firstArray = a1;
        this.secondArray = a2;
    }
    public String sortOf(int[] a1, int[] a2) {
        int i = 0, j = 0, k = 0;
        int[] resultArray = new int[a1.length + a2.length];
        while (i < a1.length && j < a2.length) {
            if(a1[i] < a2[j]) {
                resultArray[k++] = a1[i++];
            } else {
                resultArray[k++] = a2[j++];
            }
        }
        while (i < a1.length) {
            resultArray[k++] = a1[i++];
        }
        while (j < a2.length) {
            resultArray[k++] = a2[j++];
        }
        String result = "";
        // int index = 0;
        for (int index = 0; index < resultArray.length; k++) {
            result += resultArray[index] + ",";
        }
        return result;
    }

}
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size1 = Integer.parseInt(sc.nextLine());
        int size2 = Integer.parseInt(sc.nextLine());
        String[] arraytemp1 = sc.nextLine().split(",");
        String[] arraytemp2 = sc.nextLine().split(",");
        int[] array1 = new int[size1];
        int[] array2 = new int[size2];
        for (int i = 0; i < size1; i++) {
            array1[i] = Integer.parseInt(arraytemp1[i]);
        }
        for (int j = 0; j < size2; j++) {
            array2[j] = Integer.parseInt(arraytemp2[j]);
        }
        SortedArray saobj = new SortedArray(array1, array2);
        System.out.println(saobj.sortOf(array1, array2));



    }
}