import java.util.Scanner;

public class A_Road_To_Zero {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            long x = sc.nextLong(), y = sc.nextLong();
            long a = sc.nextLong(), b = sc.nextLong();

            long pay = 0L;

            // use only a dollars

            pay += a * x;
            pay += a * y;

            // use single dollars if x == y

            if(x == y) {
                pay = Math.min(pay, x * b);
            }

            // use both operations

            long dollar = 0L;

            if(x > 0 && y > 0) {
                long min = Math.min(x, y);

                dollar += b * min;

                x -= min;
                y -= min;
            } 

            if(x > 0) {
                dollar += a * x;
            } else if(y > 0) {
                dollar += a * y;
            }

            pay = Math.min(pay, dollar);

            System.out.println(pay);

        }

        sc.close();
    }
}