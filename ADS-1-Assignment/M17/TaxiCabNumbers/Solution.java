import java.util.Scanner;
/**
 * Class for cube sum.
 */
class CubeSum implements Comparable<CubeSum> {
    /**
     * variable declaration.
     */
    private final int sum;
    /**
     * variable declaration.
     */
    private final int number1;
    /**
     * variable declaration.
     */
    private final int number2;
    /**
     * Constructs the object.
     *
     * @param      i integer.
     * @param      j integer.
     */
    CubeSum(final int i, final int j) {
        this.sum = i * i * i + j * j * j;
        this.number1 = i;
        this.number2 = j;
    }
    /**
     * Gets the sum.
     *
     * @return     The sum.
     */
    public int getSum() {
        return sum;
    }
    /**
     * gets the number.
     *
     * @return number.
     */
    public int getNumber1() {
        return number1;
    }
    /**
     * gets the number.
     *
     * @return number.
     */
    public int getNumber2() {
        return number2;
    }
    /**
     * compare to method.
     *
     * @param      that  The that
     *
     * @return  integer.
     */
    public int compareTo(final CubeSum that) {
        if (this.sum < that.sum) {
            return -1;
        }
        if (this.sum > that.sum) {
            return +1;
        }
        return 0;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return sum + " = " + number1 + "^3" + " + " + number2 + "^3";
    }
}
/**
 * client program.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused constructor.
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        final int limit = 600;
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int count = 0;
        int temp = 1;
        // initialize priority queue
        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        for (int i = 0; i <= limit; i++) {
            pq.insert(new CubeSum(i, i));
        }
        // find smallest sum, print it out, and update
        while (!pq.isEmpty()) {
            CubeSum s = pq.delMin();
            //System.out.println(s.getSum()+" "+temp);
            if (temp == s.getSum()) {
                count++;
            } else {
                count = 0;
            }
            if (count == m - 1) {
                n--;
                if (n == 0) {
                    System.out.println(s.getSum());
                    break;
                }
            }
            temp = s.getSum();
            if (s.getNumber2() < limit) {
                pq.insert(new CubeSum(s.getNumber1(), s.getNumber2() + 1));
            }
        }
    }

}
