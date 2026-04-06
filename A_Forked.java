import java.util.HashSet;
import java.util.Scanner;

public class A_Forked {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt();
            int xK = sc.nextInt(), yK = sc.nextInt();
            int xQ = sc.nextInt(), yQ = sc.nextInt();

            HashSet<String> king = new HashSet<>();
            HashSet<String> queen = new HashSet<>();

            /*
             * -a, -b
             * -b, -a
             * -a, b
             * -b, a
             * b, -a
             * a, -b
             * b, a
             * a, b
             */

            int[][] moves = {
                    { -a, -b },
                    { -b, -a },
                    { -a, b },
                    { -b, a },
                    { b, -a },
                    { a, -b },
                    { b, a },
                    { a, b },
            };

            for (int i = 0; i < moves.length; i++) {
                king.add((xK + moves[i][0]) + " - " + (yK + moves[i][1]));
            }

            for (int i = 0; i < moves.length; i++) {
                queen.add((xQ + moves[i][0]) + " - " + (yQ + moves[i][1]));
            }
            
            int count = 0;

            for (String qString : queen) {
                if (king.contains(qString)) {
                    count++;
                }
            }

            System.out.println(count);

        }

        sc.close();
    }
}