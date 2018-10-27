/**
 * { item_description }.
 */
import java.util.Scanner;
/**
 * Class for student data.
 */
class StudentData implements Comparable<StudentData> {
    /**
     * { var_description }.
     */
    private String name;
    /**
     * { var_description }.
     */
    private double total;
    /**
     * { var_description }.
     */
    private int regNumber;
    /**
     * Constructs the object.
     *
     * @param      name1       The name 1
     * @param      total1      The total 1
     * @param      regnumber1  The regnumber 1
     */
    StudentData(final String name1, final String total1, final String regnumber1) {
        this.name  = name1;
        this.total = Double.parseDouble(total1);
        this.regNumber = Integer.parseInt(regnumber1);
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the total.
     *
     * @return     The total.
     */
    public double getTotal() {
        return total;
    }
    /**
     * Gets the roll no.
     *
     * @return     The roll no.
     */
    public int getRollNo() {
        return regNumber;
    }
    /**
     * { function_description }.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final StudentData that) {
        if (this.total > that.total) {
            return 1;
        }
        if (this.total < that.total) {
            return -1;
        }
        if (this.regNumber > that.regNumber) {
            return 1;
        }
        if (this.regNumber < that.regNumber) {
            return -1;
        }
        return 0;
    }
}
/**
 * { item_description }.
 */
public final class Solution {   
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
        int lines = Integer.parseInt(scan.nextLine());
        BST<StudentData, Integer> bstObj;
        bstObj = new BST<StudentData, Integer>();
        StudentData studentObj;
        while (lines > 0) {
            String[] num = scan.nextLine().split(",");
            studentObj = new StudentData(num[1], num[2], num[0]);
            bstObj.put(studentObj, Integer.parseInt(num[0]));
            lines--;
        }
        int n = Integer.parseInt(scan.nextLine());
        while (n > 0) {
            String[] tokens = scan.nextLine().split(" ");
            if (tokens[0].equals("BE")) {
                double initialMarks = Double.parseDouble(tokens[1]);
                double finalMarks = Double.parseDouble(tokens[2]);
                for (StudentData studentData : bstObj.keys()) {
                    if (studentData.getTotal() >= initialMarks && studentData.getTotal() <= finalMarks) {
                        System.out.println(studentData.getName());
                    }
                }
            } else if (tokens[0].equals("LE")) {
                double regNum = Double.parseDouble(tokens[1]);
                for (StudentData studentData : bstObj.keys()) {
                    if (studentData.getTotal() <= regNum) {
                        System.out.println(studentData.getName());
                    }
                }
            } else if (tokens[0].equals("GE")) {
                double regNum = Double.parseDouble(tokens[1]);
                for (StudentData studentData : bstObj.keys()) {
                    if (studentData.getTotal() >= regNum) {
                        System.out.println(studentData.getName());
                    }
                }
            }
            n--;
            
        }
    }
}
