import java.util.Scanner;
/**
 * Class for student.
 */
class Student {
    /**
     * { var_description }.
     */
    private String studentName;
    /**
     * { var_description }.
     */
    private double totalMarks;
    /**
     * Constructs the object.
     *
     * @param      name   The name
     * @param      marks  The marks
     */
    Student(final String name, final double marks) {
        this.studentName = name;
        this.totalMarks = marks;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.studentName;
    }
    /**
     * Gets the marks.
     *
     * @return     The marks.
     */
    public double getMarks() {
        return this.totalMarks;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "";
        str = str + this.studentName + this.totalMarks;
        return str;
    }
}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        SeparateChainingHashST<Integer, Student> sepChainObj;
        sepChainObj = new SeparateChainingHashST<>();
        for (int i = 0; i < lines; i++) {
            String[] tokens = scan.nextLine().split(",");
            Student studentObj = new Student(tokens[1],
                Double.parseDouble(tokens[2]));
            sepChainObj.put(Integer.parseInt(tokens[0]), studentObj);
        }
        // for(Integer i: sepChainObj.keys()) {
        //  System.out.println(i);
        // }
        int queries = Integer.parseInt(scan.nextLine());
        for (int j = 0; j < queries; j++) {
            String[] qTokens = scan.nextLine().split(" ");
            if (qTokens[0].equals("get")) {
                if (Integer.parseInt(qTokens[2]) == 1) {
                    if (sepChainObj.get(Integer
                        .parseInt(qTokens[1])) == null) {
                        System.out.println("Student doesn't exists...");
                    } else {
                        System.out.println(sepChainObj
                            .get(Integer
                                .parseInt(qTokens[1])).getName());
                    }
                    // System.out.println(sepChainObj
                    // .get(Integer.parseInt(qTokens[1])).getName());
                // } else {
                    // System.out.println(sepChainObj
                // .get(Integer.parseInt(qTokens[1])).getMarks());
                } else {
                    if (sepChainObj.get(Integer
                        .parseInt(qTokens[1])) == null) {
                        System.out.println("Student doesn't exists...");
                    } else {
                        System.out.println(sepChainObj.get(Integer
                            .parseInt(qTokens[1])).getMarks());
                    }
                }
            }
        }
    }
}
