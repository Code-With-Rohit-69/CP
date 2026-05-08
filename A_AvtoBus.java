import java.util.Scanner;

public class A_AvtoBus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            long tiers = sc.nextLong();

            if ((tiers & 1) != 0 || tiers < 4) {
                System.out.println(-1);
                continue;
            }

            long min = 0;

            if (tiers % 6 != 0) {
                min = 1;
            }

            min += tiers / 6;

            long max = tiers / 4;

            System.out.println(min + " " + max);

        }

        sc.close();
    }
}
