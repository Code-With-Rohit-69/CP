import java.util.Scanner;

public class B_New_Year_s_Number {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            while (n >= 2020 && n % 2021 != 0) {
                n -= 2020;
            }
            System.out.println(n % 2021 == 0 ? "YES" : "NO");

        }

        sc.close();
    }
}