import java.util.Scanner;
/**
*Insertion sorting to implement the sorting.
*/
class Sorting {
    /**
    *exchange method is used to exchange the values after there are sorted.
    *@param a student data.
    *@param i first value to be exchange.
    *@param j second value to be exchnaged.
    */
    public void exchange(StudentData[] a, int i, int j) {
        StudentData temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    /**
    *less method is used to compare which of the two are less.
    *@param std1 student data 1.
    *@param std2 student data 2.
    */
    public boolean less(StudentData std1, StudentData std2) {
        return std1.compareTo(std2) == -1;
    }
    /**
    *Insertion sort code to sort the students.
    *@param students students data in array format.
    */
    public void sort(StudentData[] students) {
        for (int i = 1; i < students.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(students[j - 1], students[j])) {
                    exchange(students, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }
}
/**
*Students data class where in we store the students data.
*/
class StudentData implements Comparable<StudentData> {
    /**
    * Student name.
    */
    public String studentName;
    /**
    *Student date of birth.
    */
    public String dateOfBirth;
    /**
    *Student subject 1 marks.
    */
    public int sub1marks;
    /**
    *Student subject 2 marks.
    */
    public int sub2marks;
    /**
    *Student subject 3 marks.
    */
    public int sub3marks;
    /**
    *Student's total marks.
    */
    public int totalMarks;
    /**
    *Student Reservation Cateogory.
    */
    public String reservationCat;
    /**
    *COnstructor which loads the Students details.
    *@param name student name.
    *@param dob student date of birth.
    *@param sub1 student subject 1 marks.
    *@param sub2 student subject 2 marks.
    *@param sub3 students subject 3 marks.
    *@param total students total marks.
    *@param category students reservation category.
    */
    StudentData(final String name, final String dob, final int sub1, 
        final int sub2, final int sub3, final int total, final String category) {
        this.studentName = name;
        this.dateOfBirth = dob;
        this.sub1marks = sub1;
        this.sub2marks = sub2;
        this.sub3marks = sub3;
        this.totalMarks = total;
        this.reservationCat = category;
    }
    /**
    *this method is used to divide and check the date.
    *@return divided date format.
    */
    public String[] dateCheck() {
        String[] check = dateOfBirth.split("-");
        return check;
    }
    /**
    *this method is used to compare the information of the student.
    *@param that second student to which comparison has to take place.
    *@return integer value.
    */
    public int compareTo(StudentData that) {
        if (this.totalMarks > that.totalMarks) {
            return 1;
        } else if (this.totalMarks < that.totalMarks) {
            return -1;
        }
        if (this.sub3marks > that.sub3marks) {
            return 1;
        } else if (this.sub3marks < that.sub3marks) {
            return -1;
        }
        if (this.sub2marks > that.sub2marks) {
            return 1;
        } else if (this.sub2marks < that.sub2marks) {
            return -1;
        }
        if (Integer.parseInt(this.dateCheck()[2])
            > Integer.parseInt(that.dateCheck()[2])) {
            return 1;
        } else if (Integer.parseInt(this.dateCheck()[2])
            < Integer.parseInt(that.dateCheck()[2])) {
            return -1;
        }
        if (Integer.parseInt(this.dateCheck()[1])
            > Integer.parseInt(that.dateCheck()[1])) {
            return 1;
        } else if (Integer.parseInt(this.dateCheck()[1])
            < Integer.parseInt(that.dateCheck()[1])) {
            return -1;
        }
        if (Integer.parseInt(this.dateCheck()[0])
            > Integer.parseInt(that.dateCheck()[0])) {
            return 1;
        } else if (Integer.parseInt(this.dateCheck()[0])
            < Integer.parseInt(that.dateCheck()[0])) {
            return -1;
        }
        return 0;
    }

}
/**
*Soultion class deals with the main function and also the selction
*of merit list and the to string method as well.
*/
class Solution {
    /**
    *default constructor.
    */
    Solution() {
    }
    /**
    *mert list method where in the students are
    *divided according to the marks and the reservation.
    *@param a Student data type.
    *@param vacancy inrteger type.
    *@param open integer type.
    *@param bc integer type.
    *@param sc integer type.
    *@param st integer type.
    */
    public static void mertiList(final StudentData[] a, int vacancy, int open,
        int bc, int sc, int st) {
        for (int i = 0; i < a.length && vacancy > 0; i++) {
            if (open > 0) {
                System.out.println(a[i].studentName + ","
                    + a[i].totalMarks + ","
                    + a[i].reservationCat);
                open--;
            } else if (a[i].reservationCat.equals("BC")
                || a[i].reservationCat.equals("SC")
                || a[i].reservationCat.equals("ST")) {
                if (a[i].reservationCat.equals("BC") && bc > 0) {
                    System.out.println(a[i].studentName + ","
                        + a[i].totalMarks + ","
                        + a[i].reservationCat);
                    bc--;
                } else if (a[i].reservationCat.equals("SC") && sc > 0) {
                    System.out.println(a[i].studentName + ","
                        + a[i].totalMarks + ","
                        + a[i].reservationCat);
                    sc--;
                } else if (a[i].reservationCat.equals("ST") && st > 0) {
                    System.out.println(a[i].studentName + ","
                        + a[i].totalMarks + ","
                        + a[i].reservationCat);
                    st--;
                }
            }
        }
        vacancy--;
    }
    /**
    *To string method which convterts to String type.
    *@param a Student data type.
    */
    public static void toString(StudentData[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i].studentName + ","
                + a[i].totalMarks + ","
                + a[i].reservationCat);
        }
    }
    /**
    *main method to read the input based on the given test cases.
    *@param args String type.
    */
    public static void main(final String[] args) {
        Scanner scan =  new Scanner(System.in);
        final int n = Integer.parseInt(scan.nextLine());
        StudentData[] students = new StudentData[n];
        final int vacancyNumber = Integer.parseInt(scan.nextLine());
        final int openVacancy = Integer.parseInt(scan.nextLine());
        final int bcVacancy = Integer.parseInt(scan.nextLine());
        final int scVacancy = Integer.parseInt(scan.nextLine());
        final int stVacancy = Integer.parseInt(scan.nextLine());
        final int three = 3;
        final int four = 4;
        final int five = 5;
        final int six = 6;
        for (int i = 0; i < n; i++) {
            String line = scan.nextLine();
            String[] tokens = line.split(",");
            StudentData eachStudentInfo =
            new StudentData(tokens[0], tokens[1],
                    Integer.parseInt(tokens[2]), Integer.parseInt(tokens[three]),
                    Integer.parseInt(tokens[four]),
                    Integer.parseInt(tokens[five]), tokens[six]);
            students[i] = eachStudentInfo;
        }
        Sorting insertion = new Sorting();
        insertion.sort(students);
        toString(students);
        System.out.println(); //empty line.
        mertiList(students, vacancyNumber, openVacancy,
            bcVacancy, scVacancy, stVacancy);
    }

}
