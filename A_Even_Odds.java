import java.util.Scanner;

public class A_Even_Odds {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong(), k = sc.nextLong();
        long half = n / 2;

        if((n & 1) == 0) { // is n is even
            if(k > half) {
                long diff = k - half;
                System.out.println(2 * diff);
            } else {
                System.out.println(2 * k - 1);
            }
        } else { // n is odd
            if(k <= half + 1) {
                System.out.println(2 * k - 1);
            } else {
                long diff = k - half;
                System.out.println(2 * diff - 2);
            }
        }

        sc.close();
    }
}