import java.util.Scanner;
class InsertionSort {
	void exchange(studentData[] a, int i, int j) {
		studentData temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	boolean less(studentData std1, studentData std2) {
		return std1.compareTo(std2) == -1;
	}
	void sort(studentData[] students) {
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
class studentData implements Comparable<studentData> {
	String studentName;
	String dateOfBirth;
	int sub1marks;
	int sub2marks;
	int sub3marks;
	int totalMarks;
	String reservationCat;
	studentData(String name, String dob, int sub1, int sub2, int sub3, int total, String category) {
		this.studentName = name;
		this.dateOfBirth = dob;
		this.sub1marks = sub1;
		this.sub2marks = sub2;
		this.sub3marks = sub3;
		this.totalMarks = total;
		this.reservationCat = category;
	}
	String[] dateCheck() {
		String[] check = dateOfBirth.split("-");
		return check;
	}
	public int compareTo(studentData that) {
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
		if (Integer.parseInt(this.dateCheck()[2]) > Integer.parseInt(that.dateCheck()[2])) {
			return 1;
		} else if (Integer.parseInt(this.dateCheck()[2]) < Integer.parseInt(that.dateCheck()[2])) {
			return -1;
		}
		if (Integer.parseInt(this.dateCheck()[1]) > Integer.parseInt(that.dateCheck()[1])) {
			return 1;
		} else if (Integer.parseInt(this.dateCheck()[1]) < Integer.parseInt(that.dateCheck()[1])) {
			return -1;
		}
		if (Integer.parseInt(this.dateCheck()[0]) > Integer.parseInt(that.dateCheck()[0])) {
			return 1;
		} else if (Integer.parseInt(this.dateCheck()[0]) < Integer.parseInt(that.dateCheck()[0])) {
			return -1;
		}
		return 0;
	}

}
class Solution {
	Solution() {
		//unused
	}
	public static void mertiList(studentData[] a, int vacancy, int open, int bc, int sc, int st) {
		for (int i = 0; i < a.length && vacancy > 0; i++) {
			if (open > 0) {
				System.out.println(a[i].studentName + "," +
				                   a[i].totalMarks + "," +
				                   a[i].reservationCat);
				open--;
			} else if (a[i].reservationCat.equals("BC") || a[i].reservationCat.equals("SC") || a[i].reservationCat.equals("ST")) {
				if (a[i].reservationCat.equals("BC") && bc > 0) {
					System.out.println(a[i].studentName + "," +
					                   a[i].totalMarks + "," +
					                   a[i].reservationCat);
					bc--;
				} else if (a[i].reservationCat.equals("SC") && sc > 0) {
					System.out.println(a[i].studentName + "," +
					                   a[i].totalMarks + "," +
					                   a[i].reservationCat);
					sc--;
				} else if (a[i].reservationCat.equals("ST") && st > 0) {
					System.out.println(a[i].studentName + "," +
					                   a[i].totalMarks + "," +
					                   a[i].reservationCat);
					st--;
				} else {
				}
			}
		}
		vacancy--;
	}
	public static void toString(studentData[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i].studentName + "," +
			                   a[i].totalMarks + "," +
			                   a[i].reservationCat);
		}
	}
	public static void main(String[] args) {
		Scanner scan =  new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		studentData[] students = new studentData[n];
		int vacancyNumber = Integer.parseInt(scan.nextLine());
		int openVacancy = Integer.parseInt(scan.nextLine());
		int bcVacancy = Integer.parseInt(scan.nextLine());
		int scVacancy = Integer.parseInt(scan.nextLine());
		int stVacancy = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < n; i++) {
			String line = scan.nextLine();
			String[] tokens = line.split(",");
			studentData eachStudentInfo = new studentData(tokens[0], tokens[1],
			        Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]),
			        Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]), tokens[6]);
			students[i] = eachStudentInfo;
		}
		InsertionSort insertion = new InsertionSort();
		insertion.sort(students);
		toString(students);
		// System.out.println(); //empty line.
		mertiList(students, vacancyNumber, openVacancy, bcVacancy, scVacancy, stVacancy);
	}

}
