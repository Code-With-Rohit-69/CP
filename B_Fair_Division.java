import java.util.Scanner;

public class B_Fair_Division {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int ones = 0, twos = 0;

            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                if(num == 1) ones++;
                else twos++;
            }

            int total = ones + (2 * twos);

            if (total % 2 != 0) {
                System.out.println("NO");
            } else {
                int half = total / 2;

                if (half % 2 != 0 && ones == 0) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            }
        }

        sc.close();
    }
}