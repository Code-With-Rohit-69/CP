import java.util.Scanner;

public class A_Minimal_Square {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt();

            int max = Math.max(a, b + b);

            int min = max * max;

            max = Math.max(a + a, b);

            min = Math.min(min, max * max);

            System.out.println(min);

        }

        sc.close();
    }
}