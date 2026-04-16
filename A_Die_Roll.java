import java.util.Scanner;

public class A_Die_Roll {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Y = sc.nextInt();
        int W = sc.nextInt();

        int numerator = 6 - Y;
        int denominator = 6 - W;

        if(numerator == 0 || denominator == 0) {
            System.out.println("0/1");
            sc.close();
            return;
        }

        if(numerator == 1 && denominator == 1) {
            System.out.println("1/1");
            sc.close();
            return;
        }

        int min = Math.min(numerator, denominator);

        if (numerator % min == 0 && denominator % min == 0) {
            numerator /= min;
            denominator /= min;
        }

        System.out.println(numerator + "/" + denominator);

        sc.close();
    }
}