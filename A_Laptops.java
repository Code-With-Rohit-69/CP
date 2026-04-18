import java.util.Scanner;

public class A_Laptops {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();;

        boolean ans = false;

        while (n-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt();
            if(a < b) {
                ans = true;
            }
        }

        if(ans) {
            System.out.println("Happy Alex");
        } else {
            System.out.println("Poor Alex");
        }

        sc.close();
    }
}