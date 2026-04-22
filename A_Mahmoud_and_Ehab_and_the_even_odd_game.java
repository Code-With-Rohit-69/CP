import java.util.Scanner;

public class A_Mahmoud_and_Ehab_and_the_even_odd_game {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if ((n & 1) == 0) {
            System.out.println("Mahmoud");
        } else {
            System.out.println("Ehab");
        }

        sc.close();
    }
}