import java.util.Scanner;

public class A_Magical_Sticks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int sticks = (int) Math.ceil((double) n / 2);
            System.out.println(sticks);

        }

        sc.close();
    }
}