import java.util.*;

public class A_Forbidden_Integer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt(), k = sc.nextInt(), x = sc.nextInt();
            if (x != 1) {
                System.out.println("YES");
                System.out.println(n);

                for (int i = 0; i < n; i++) {
                    System.out.print(1 + " ");
                }

            } else {
                int twos = n / 2;

                if (k >= 2 && n % 2 == 0) {
                    System.out.println("YES");
                    System.out.println(twos);

                    for (int i = 0; i < twos; i++) {
                        System.out.print(2 + " ");
                    }
                } else if (k >= 3 && n % 2 != 0) {
                    System.out.println("YES");
                    System.out.println(twos);

                    for (int i = 0; i < twos - 1; i++) {
                        System.out.print(2 + " ");
                    }

                    System.out.print(3);
                } else {
                    System.out.print("NO");
                }
            }

            System.out.println();

        }

        sc.close();
    }
}