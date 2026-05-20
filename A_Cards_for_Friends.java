import java.util.Scanner;

public class A_Cards_for_Friends {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            long w = sc.nextLong();
            long h = sc.nextLong();
            long n = sc.nextLong();

            long cuts = 1;

            while (w % 2 == 0) {
                cuts *= 2;
                w /= 2;
            }

            while (h % 2 == 0) {
                cuts *= 2;
                h /= 2;
            }

            System.out.println(cuts >= n ? "YES" : "NO");

        }

        sc.close();
    }
}
