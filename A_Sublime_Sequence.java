import java.util.Scanner;

public class A_Sublime_Sequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            int k = sc.nextInt();
            int n = sc.nextInt();

            if((n & 1) == 0) {
                System.out.println(0);
            } else {
                System.out.println(k);
            }

        }

        sc.close();
    }
}