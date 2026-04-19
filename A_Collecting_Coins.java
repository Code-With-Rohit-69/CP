import java.util.Scanner;

public class A_Collecting_Coins {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int n = sc.nextInt();

            long s = a + b + c + n;

            if (s % 3 == 0) {
                long target = s / 3;
                if (a <= target && b <= target && c <= target) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }

        }

        sc.close();
    }
}