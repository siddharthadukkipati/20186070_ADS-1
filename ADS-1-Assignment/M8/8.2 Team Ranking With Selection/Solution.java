import java.util.Scanner;
import java.util.Arrays;
/**
*Tournament class usually helps in storing the Details of the team.
*/
class Tournament {
    /**
    *Team Name is being stored.
    */
    private String teamName;
    /**
    *Team Wins.
    */
    private int teamWins;
    /**
    *Team Looses.
    */
    private int teamLooses;
    /**
    *Team Draws.
    */
    private int teamDraws;
    /**
    *This is an overloaded constructor.
    *@param name name of the time.
    *@param wins number of wins for a team.
    *@param looses number of looses for a team.
    *@param draws number of draws for a team.
    */
    Tournament(final String name, final int wins,
        final int looses, final int draws) {
        this.teamName = name;
        this.teamWins = wins;
        this.teamLooses = looses;
        this.teamDraws = draws;
    }
    /**
    *gets the Team Name.
    *@return the team name.
    */
    public String getTeamName() {
        return this.teamName;
    }
    /**
    *gets the team wins.
    *@return team wins.
    */
    public int getTeamWins() {
        return this.teamWins;
    }
    /**
    *team looses.
    *@return team looses.
    */
    public int getTeamLooses() {
        return this.teamLooses;
    }
    /**
    *team Draws.
    *@return team draws
    */
    public int getTeamDraws() {
        return this.teamDraws;
    }
    /**
    *This method is used to compare various feilds and returns integer values.
    *@return 1 or -1 or 0 depending on the condition.
    *@param that second one.
    */
    public int compareTo(final Tournament that) {
        if (this.getTeamWins() > that.getTeamWins()) {
            return 1;
        } else if (this.getTeamWins() < that.getTeamWins()) {
            return -1;
        }
        if (this.getTeamLooses() < that.getTeamLooses()) {
            return 1;
        } else if (this.getTeamLooses() > that.getTeamLooses()) {
            return -1;
        }
        if (this.getTeamDraws() > that.getTeamDraws()) {
            return 1;
        } else if (this.getTeamDraws() < that.getTeamDraws()) {
            return -1;
        }
        return 0;
    }
}
/**
*Selection sort.
*/
class SelectionSort {
    /**
    *Tournament.
    */
    private Tournament[] tournamentArray;
    /**
    *Size.
    */
    private int size;
    /**
    *Constructor.
    */
    SelectionSort() {
    final int ten = 10;
    this.tournamentArray = new Tournament[ten];
    this.size = 0;
    }
    /**
    *resize method is used to resize when the arrays size is full.
    */
    public void resize() {
        tournamentArray = Arrays.copyOf(tournamentArray,
            2 * tournamentArray.length);
    }
    /**
    *gives the size of the array.
    *@return size of the array.
    */
    public int size() {
        return this.size;
    }
    /**
    *generally adds the team names to the arrays.
    *@param team team.
    */
    public void addTo(final Tournament team) {
        if (size == tournamentArray.length) {
            resize();
        }
        tournamentArray[size++] = team;
    }
    /**
    *converts from Arrays to String.
    *@return input String.
    */
    public String toString() {
        int k = 0;
        String inputStr = "";
        for (k = 0; k < size - 1; k++) {
            inputStr += tournamentArray[k].getTeamName() + ",";
        }
        inputStr += tournamentArray[k].getTeamName();
        return inputStr;
    }
    /**
    *Swaps from one position to another position.
    *@param a Tournament[].
    *@param i integer.
    *@param j integer.
    */
    public void exchange(final Tournament[] a, final int i, final int j) {
        Tournament swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    /**
    *Generally sorts the elements.
    */
    public void sort() {
        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (tournamentArray[j].compareTo(tournamentArray[min])
                    == 1) {
                    min = j;
                }
            }
            exchange(tournamentArray, i, min);
        }
    }
}
/**
*Soultion.
*/
final public class Solution {
    /**
    *default constructor.
    */
    private Solution() {
    }
    /**
    *main method which helps to read the main function.
    *@param args arguments.
    */
    public static void main(final String[] args) {
        final int three = 3;
        Scanner sc = new Scanner(System.in);
        Tournament teamObj;
        SelectionSort sortOf = new SelectionSort();
        // List lstObj = new List();
        while (sc.hasNext()) {
            String[] tokens = sc.nextLine().split(",");
            sortOf.addTo(new Tournament(tokens[0],
                Integer.parseInt(tokens[1]),
                Integer.parseInt(tokens[2]),
                Integer.parseInt(tokens[three])));
        }
        sortOf.sort();
        System.out.println(sortOf.toString());
    }
}
