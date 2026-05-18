import java.util.Scanner;

public class B_Remilia_Plays_Soku {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            int k = sc.nextInt();

            int diff = Math.abs(x1 - x2);

            int dist = Math.min(diff, n - diff);

            System.out.println(dist + k);

        }

        sc.close();

    }
}