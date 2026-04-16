import java.util.Scanner;

public class A_Boring_Apartments {

    public static int count(int n) {
        int c = 0;
        int i = 1;

        while(n > 0) {
            c += i;
            n /= 10;
            i++;
        }

        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int res = count(n);
            int r = n % 10;

            res += (r - 1) * 10;

            System.out.println(res);

        }

        sc.close();
    }
}   