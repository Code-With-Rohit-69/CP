import java.util.Scanner;

public class A_Fancy_Fence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int angle = sc.nextInt();

            if(360 % (180 - angle) == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

        sc.close();
    }
}