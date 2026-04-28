import java.util.Scanner;

public class B_Grab_the_Candies {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int even = 0, odd = 0;

            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                if((num & 1) == 0) even += num;
                else odd += num;
            }

            if (even > odd) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

        sc.close();
    }
}