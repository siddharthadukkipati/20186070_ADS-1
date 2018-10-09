import java.util.Scanner;
import java.util.Arrays;
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
     * { openCount }.
     */
    private static int openCount = 0;
    /**
     * { bcCount }.
     */
    private static int bcCount = 0;
    /**
     * { scCount }.
     */
    private static int scCount = 0;
    /**
     * { stCount }.
     */
    private static int stCount = 0;
    /**
     * { countingcat }.
     * complexity: O(N)
     *
     * @param      a  The array
     */
    public static void countCategory(final StudentData[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i].rescategory.equals("Open")) {
                openCount++;
            }
            if (a[i].rescategory.equals("BC")) {
                bcCount++;
            }
            if (a[i].rescategory.equals("SC")) {
                scCount++;
            }
            if (a[i].rescategory.equals("ST")) {
                stCount++;
            }
        }
    }
    /**
     * { meritarray }.
     * complexity: O(N)
     *
     * @param      a    The a
     * @param      vacancy  The vacancy
     * @param      open     The open
     * @param      bc       { parameter_description }
     * @param      sc       The screen
     * @param      st       { parameter_description }
     */
    public static void meritList(final StudentData[] a,
                                 final int vacancy, final int open,
                                 final int bc, final int sc,
                                 final int st) {
        countCategory(a);
        int vacancynew = vacancy;
        int opennew = open;
        int bcnew = bc;
        int scnew = sc;
        int stnew = st;
        final int thirty = 30;
        StudentData[] merit = new StudentData[thirty];
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (vacancynew == 0) {
                break;
            }
            if (opennew > 0) {
                merit[count++] = a[i];
                opennew--;
                vacancynew--;

            } else {
                if (a[i].rescategory.equals("BC")
                        || a[i].rescategory.equals("SC")
                        || a[i].rescategory.equals("ST")) {
                    if (a[i].rescategory.equals("BC")
                            && bcnew > 0) {
                        merit[count++] = a[i];
                        bcnew--;
                        vacancynew--;
                    } else if (a[i].rescategory.equals("SC")
                               && scnew > 0) {

                        merit[count++] = a[i];
                        scnew--;
                        vacancynew--;
                    } else if (a[i].rescategory.equals("ST")
                               && stnew > 0) {
                        merit[count++] = a[i];
                        stnew--;
                        vacancynew--;
                    }
                } else if (vacancynew > 0
                           && bcCount == 0 && scCount == 0
                           && stCount == 0) {
                    merit[count++] = a[i];
                    vacancynew--;
                }
            }

        }
        if (vacancynew > 0) {
            for (int j = 0; j < a.length; j++) {
                if (vacancynew <= 0) {
                    break;
                }
                if (a[j] != merit[j]) {
                    merit[count++] = a[j];
                    vacancynew--;
                }
            }
        }
        merit = Arrays.copyOf(merit, count);
        // Arrays.sort(merit, Collections.reverseOrder());
        InsertionSort newinsert = new InsertionSort();
        newinsert.sort(merit);
        print(merit);
    }

    /**
     * { print }.
     * O(N)
     * @param      a  The a
     */
    public static void print(final StudentData[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i].studentname + ","
                               + a[i].totalmarks + ","
                               + a[i].rescategory);
        }
    }
    /**
     * { main }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        final int three = 3;
        final int four = 4;
        final int five = 5;
        final int six = 6;
        Scanner scan =  new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        StudentData[] students = new StudentData[num];
        int vacancynum = Integer.parseInt(scan.nextLine());
        int openvacancy = Integer.parseInt(scan.nextLine());
        int bcvacancy = Integer.parseInt(scan.nextLine());
        int scvacancy = Integer.parseInt(scan.nextLine());
        int stvacancy = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            String line = scan.nextLine();
            String[] tokens = line.split(",");
            StudentData eachstudentdata = new StudentData(tokens[0], tokens[1],
                    Integer.parseInt(tokens[2]),
                    Integer.parseInt(tokens[three]),
                    Integer.parseInt(tokens[four]),
                    Integer.parseInt(tokens[five]),
                    tokens[six]);
            students[i] = eachstudentdata;
        }
        InsertionSort insertion = new InsertionSort();
        insertion.sort(students);
         // Arrays.sort(students, Collections.reverseOrder());
        print(students);
        System.out.println();
        meritList(students, vacancynum,
                  openvacancy, bcvacancy,
                  scvacancy, stvacancy);
    }

}
