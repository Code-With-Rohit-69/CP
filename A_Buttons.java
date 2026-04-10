import java.util.Scanner;

public class A_Buttons {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            long a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();

            long sum = a + b + c;

            if ((sum & 1) != 0) {
                System.out.println("First");
            } else {
                System.out.println("Second");
            }

        }

        sc.close();
    }
}