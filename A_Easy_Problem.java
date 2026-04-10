import java.util.Scanner;

public class A_Easy_Problem {

    static Scanner sc;

    public static void solve() {
        int n = sc.nextInt();
        System.out.println(n - 1);

    }
    public static void main(String[] args) {
        sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            solve();
        }

        sc.close();
    }
}