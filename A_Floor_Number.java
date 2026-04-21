import java.util.Scanner;

public class A_Floor_Number {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();

            int floor;

            if (n <= 2) {
                floor = 1;
            } else {
                floor = (int) Math.ceil((double) (n - 2) / x) + 1;
            }

            System.out.println(floor);
        }

        sc.close();
    }
}