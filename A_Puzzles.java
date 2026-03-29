import java.util.Arrays;
import java.util.Scanner;

public class A_Puzzles {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.hasNextInt() ? sc.nextInt() : n;

        int[] puzzle = new int[m];

        for(int i = 0; i < m; i++) {
            puzzle[i] = sc.nextInt();
        }

        int min = (int) (1e9);

        Arrays.sort(puzzle);

        for(int i = 0; i <= m - n; i++) {
            min = Math.min(min, puzzle[n + i -1] - puzzle[i]);
        }

        System.out.println(min);

        sc.close();
    }
}