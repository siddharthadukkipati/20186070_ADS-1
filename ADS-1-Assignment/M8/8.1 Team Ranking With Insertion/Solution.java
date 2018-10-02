import java.util.Scanner;
import java.util.Arrays;
class Tournament {
	private String teamName;
	private int teamWins;
	private int teamLooses;
	private int teamDraws;
	Tournament(String name, int wins, int looses, int draws) {
		this.teamName = name;
		this.teamWins = wins;
		this.teamLooses = looses;
		this.teamDraws = draws;
	}
	public String getTeamName() {
		return this.teamName;
	}
	public int getTeamWins() {
		return this.teamWins;
	}
	public int getTeamLooses() {
		return this.teamLooses;
	}
	public int getTeamDraws() {
		return this.teamDraws;
	}
	public int comparedTo(Tournament that) {
		if (this.getTeamWins() < that.getTeamWins())
			return 1;
		else if (this.getTeamWins() > that.getTeamWins())
			return -1;
		if (this.getTeamLooses() < that.getTeamLooses())
			return 1;
		else if (this.getTeamLooses() > that.getTeamLooses())
			return -1;
		if (this.getTeamDraws() < that.getTeamDraws())
			return 1;
		else if (this.getTeamDraws() > that.getTeamDraws())
			return -1;
		return 0;
	}
}
class InsertionSort {
	private Tournament[] tournamentArray;
	private int size;
	InsertionSort() {
	this.tournamentArray = new Tournament[10];
	this.size = 0;
	}
	public void resize() {
		tournamentArray = Arrays.copyOf(tournamentArray, 2 * tournamentArray.length);
	}
	public int size() {
		return this.size;
	}
	public void addTo(Tournament team) {
		if (size == tournamentArray.length) {
			resize();
		}
		tournamentArray[size++] = team;
	}
	public String toString() {
		int k = 0;
        String inputStr = "";
        for (k = 0; k < size - 1; k++) {
            inputStr = tournamentArray[k].getTeamName() + ",";
        }
        // inputStr += tournamentArray[k].getTeamName();
        return inputStr;
	}
}
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Tournament teamObj;
		InsertionSort sortOf = new InsertionSort();
		// List lstObj = new List();
		while(sc.hasNext()) {
			String[] tokens = sc.nextLine().split(",");
			sortOf.addTo(new Tournament(tokens[0],
				Integer.parseInt(tokens[1]),
				Integer.parseInt(tokens[2]),
				Integer.parseInt(tokens[3])));
			System.out.println(sortOf.toString());
		}
	}
}	