import java.util.Scanner;

public class A_Minutes_Before_the_New_Year {

    static Scanner sc;

    public static void solve() {
        int hh = sc.nextInt();
        int mm = sc.nextInt();

        int remainingHours = 24 - hh;

        int totalRemaining = remainingHours * 60 - mm;

        System.out.println(totalRemaining);

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