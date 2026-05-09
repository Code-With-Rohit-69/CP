import java.util.Scanner;

public class A_Array_with_Odd_Sum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0 ) {
            int n = sc.nextInt();

            long sum = 0;

            for (int i = 0; i < n; i++) {
                sum += sc.nextLong();
            }

            if ((sum & 1) == 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }

        }

        sc.close();
    }
}