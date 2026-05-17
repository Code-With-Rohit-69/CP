import java.util.Scanner;

public class A_Buttons {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            long a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();

            if((c & 1) != 0) {
                // Anna

                if (a >= b) {
                    System.out.println("First");
                } else {
                    System.out.println("Second");
                }
            } else {
                // katie

                if (b >= a) {
                    System.out.println("Second");
                } else {
                    System.out.println("First");
                }

            }

        }

        sc.close();
    }
}