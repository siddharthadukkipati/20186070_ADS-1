import java.util.Scanner;
/**
 * Class for student.
 */
class Student {
	private String studentName;
	private double totalMarks;
	Student(String name, double marks) {
		this.studentName = name;
		this.totalMarks = marks;
	}
	public String getName() {
		return this.studentName;
	}
	public double getMarks() {
		return this.totalMarks;
	}
	public String toString() {
		String str = "";
		str = str + this.studentName + this.totalMarks;
		return str;
	}
}
class Solution {
	private Solution() {
		//unused
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int lines = Integer.parseInt(scan.nextLine());
		SeparateChainingHashST<Integer, Student> sepChainObj;
		sepChainObj = new SeparateChainingHashST<>();
		for(int i = 0; i < lines; i++) {
			String[] tokens = scan.nextLine().split(",");
			Student studentObj = new Student(tokens[1], Double.parseDouble(tokens[2]));
			sepChainObj.put(Integer.parseInt(tokens[0]), studentObj);
		}
		// for(Integer i: sepChainObj.keys()) {
		// 	System.out.println(i);
		// }
		int queries = Integer.parseInt(scan.nextLine());
		for (int j = 0; j < queries; j++) {
			String[] qTokens = scan.nextLine().split(" ");
			if(qTokens[0].equals("get")) {
				if(Integer.parseInt(qTokens[2]) == 1) {
					if (sepChainObj.get(Integer.parseInt(qTokens[1])) == null) {
						System.out.println("Student doesn't exists...");
					} else {
						System.out.println(sepChainObj.get(Integer.parseInt(qTokens[1])).getName());
					}
					// System.out.println(sepChainObj.get(Integer.parseInt(qTokens[1])).getName());
				// } else {
					// System.out.println(sepChainObj.get(Integer.parseInt(qTokens[1])).getMarks());
				} else {
					if (sepChainObj.get(Integer.parseInt(qTokens[1])) == null) {
						System.out.println("Student doesn't exists...");
					} else {
						System.out.println(sepChainObj.get(Integer.parseInt(qTokens[1])).getMarks());
					}
				}
			}
		}
	}
}
