import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for insertionsort.
 */
class InsertionSort {
	/**
	 * { exchanges two items }.
	 * Complexity: Best: O(1)
	 *             Worst: O(1)
	 *             Average: O(1)
	 *
	 * @param      a       The a
	 * @param      lo  The lo
	 * @param      hi    The hi
	 */
	void exchange(final StudentData[] a,
	              final int lo,
	              final int hi) {
		StudentData temp = a[lo];
		a[lo] = a[hi];
		a[hi] = temp;
	}
	/**
	 * { To check min element }.
	 * Complexity: Best: O(1)
	 *             Worst: O(1)
	 *             Average: O(1)
	 *
	 * @param      stdOne  The stdOne
	 * @param      stdTwo  The stdTwo
	 *
	 * @return     { boolean }
	 */
	boolean less(final StudentData stdOne,
	             final StudentData stdTwo) {
		return stdOne.compareTo(stdTwo) == -1;
	}
	/**
	 * { Insertion sort function }.
	 * Complexity: Best: O(N^2)
	 *             Worst: O(N^2)
	 *             Average: O(N^2)
	 *
	 * @param      students  The students
	 */
	void sort(StudentData[] students) {
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
 * Class for StudentData.
 */
class StudentData implements Comparable<StudentData> {
	/**
	 * { studentname }.
	 */
	String studentname;
	/**
	 * { birthdate }.
	 */
	String birthdate;
	/**
	 * { sub1marks }.
	 */
	int sub1marks;
	/**
	 * { sub2marks }.
	 */
	int sub2marks;
	/**
	 * { sub3marks }.
	 */
	int sub3marks;
	/**
	 * { totalmarks }.
	 */
	int totalmarks;
	/**
	 * { rescategory }.
	 */
	String rescategory;
	/**
	 * Constructs the object.
	 *
	 * @param      name      The name
	 * @param      dob       The dob
	 * @param      sub1      The sub 1
	 * @param      sub2      The sub 2
	 * @param      sub3      The sub 3
	 * @param      total     The total
	 * @param      category  The category
	 */
	StudentData(final String name,
	            final String dob,
	            final int sub1,
	            final int sub2,
	            final int sub3,
	            final int total,
	            final String category) {
		this.studentname = name;
		this.birthdate = dob;
		this.sub1marks = sub1;
		this.sub2marks = sub2;
		this.sub3marks = sub3;
		this.totalmarks = total;
		this.rescategory = category;
	}
	/**
	 * { To split the data string }.
	 * Complexity: Best: O(1)
	 *             Worst: O(1)
	 *             Average: O(1)
	 *
	 * @return     { description_of_the_return_value }
	 */
	String[] dateCheck() {
		String[] checkDate = birthdate.split("-");
		return checkDate;
	}
	/**
	 * { CompareTo function }.
	 * Complexity: Best: O(1)
	 *             Worst: O(1)
	 *             Average: O(1)
	 *
	 * @param      that  The that
	 *
	 * @return     { int }
	 */
	public int compareTo(final StudentData that) {
		if (this.totalmarks > that.totalmarks) {
			return 1;
		}
		if (this.totalmarks < that.totalmarks) {
			return -1;
		}
		if (this.sub3marks > that.sub3marks) {
			return 1;
		}
		if (this.sub3marks < that.sub3marks) {
			return -1;
		}
		if (this.sub2marks > that.sub2marks) {
			return 1;
		}
		if (this.sub2marks < that.sub2marks) {
			return -1;
		}
		if (Integer.parseInt(this.dateCheck()[2]) > Integer.parseInt(that.dateCheck()[2])) {
			return 1;
		}
		if (Integer.parseInt(this.dateCheck()[2]) < Integer.parseInt(that.dateCheck()[2])) {
			return -1;
		}
		if (Integer.parseInt(this.dateCheck()[1]) > Integer.parseInt(that.dateCheck()[1])) {
			return 1;
		}
		if (Integer.parseInt(this.dateCheck()[1]) < Integer.parseInt(that.dateCheck()[1])) {
			return -1;
		}
		if (Integer.parseInt(this.dateCheck()[0]) > Integer.parseInt(that.dateCheck()[0])) {
			return 1;
		}
		if (Integer.parseInt(this.dateCheck()[0]) < Integer.parseInt(that.dateCheck()[0])) {
			return -1;
		}
		return 0;
	}
}
