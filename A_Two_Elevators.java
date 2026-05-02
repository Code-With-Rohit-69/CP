import java.util.Scanner;

public class A_Two_Elevators {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            int first = Math.abs(a - 1);

            int second = Math.abs(b - c);
            second += Math.abs(c - 1);

            if(first < second) {
                System.out.println(1);
            } else if (second < first) {
                System.out.println(2);
            } else {
                System.out.println(3);
            }

        }

        sc.close();
    }
}