import java.util.Scanner;

public class A_Walking_Master {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tt = sc.nextInt();

        while (tt-- > 0) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (j > y) {
                System.out.println(-1);
                continue;
            }

            int moves = y - j;

            i += moves;

            if (i < x) {
                System.out.println(-1);
                continue;
            }

            moves += i - x;

            System.out.println(moves);

        }

        sc.close();

    }
}
