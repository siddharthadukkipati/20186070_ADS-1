import java.util.Scanner;
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
		SeparateChainingHashST<Integer, Student> schObj;
		schObj = new SeparateChainingHashST<>();
		for(int i = 0; i < lines; i++) {
			String[] tokens = scan.nextLine().split(",");
			Student stdObj = new Student(tokens[1], Double.parseDouble(tokens[2]));
			schObj.put(Integer.parseInt(tokens[0]), stdObj);
		}
		// for(Integer i: schObj.keys()) {
		// 	System.out.println(i);
		// }
		int queries = Integer.parseInt(scan.nextLine());
		for (int j = 0; j < queries; j++) {
			String[] queryTokens = scan.nextLine().split(" ");
			if(queryTokens[0].equals("get")) {
				if(Integer.parseInt(queryTokens[2]) == 1) {
					if (schObj.get(Integer.parseInt(queryTokens[1])) == null) {
						System.out.println("Student doesn't exists...");
					} else {
						System.out.println(schObj.get(Integer.parseInt(queryTokens[1])).getName());
					}
					// System.out.println(schObj.get(Integer.parseInt(queryTokens[1])).getName());
				// } else {
					// System.out.println(schObj.get(Integer.parseInt(queryTokens[1])).getMarks());
				}
			}
		}
	}
}
