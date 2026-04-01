import java.util.Scanner;

public class A_Required_Remainder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int n = sc.nextInt();

            int MOD = n % x;

            if(MOD == y) {
                System.out.println(n);
            } else if(MOD > y) {
                int how_much_greater = MOD - y;
                System.out.println(n - how_much_greater);
            } else {
                int diff = x - y;
                System.out.println(n - (MOD + diff));
            }

        }

        sc.close();
    }
}