import java.util.Scanner;

public class A_Game_With_Sticks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int intersection = Math.min(n, m);

        if((intersection & 1) == 0) {
            System.out.println("Malvika");
        } else {
            System.out.println("Akshat");
        }

        sc.close();
    }
}