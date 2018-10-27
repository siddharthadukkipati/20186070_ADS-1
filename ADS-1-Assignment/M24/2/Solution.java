import java.util.Scanner;
class StudentData implements Comparable<StudentData> {
    private String name;
    private double total;
    private int regNumber;
    StudentData(final String name1, final String total1, final String regnumber1) {
        this.name  = name1;
        this.total = Double.parseDouble(total1);
        this.regNumber = Integer.parseInt(regnumber1);
    }
    public String getName() {
        return name;
    }
    public double getTotal() {
        return total;
    }
    public int getRollNo() {
        return regNumber;
    }
    public int compareTo(final StudentData that) {
        if (this.total > that.total) {
            return -1;
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
public final class Solution {   
    private Solution() {
        //unused.
    }
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        BST<StudentData, Integer> bstObj;
        bstObj = new BST<>();
        StudentData studentObj = null;
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
