import java.util.Scanner;

public class A_Yet_Another_Two_Integers_Problem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt();
            int count = 0;

            int diff = Math.abs(a - b);

            while (diff >= 10) {
                diff -= 10;
                count++;
            }

            if (diff > 0) {
                count++;
            }

            System.out.println(count);
        }

        sc.close();
    }
}