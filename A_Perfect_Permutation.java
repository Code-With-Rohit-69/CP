import java.util.Scanner;

public class A_Perfect_Permutation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if ((n & 1) == 1) {
            System.out.println(-1);
            sc.close();
            return;
        }

        for (int i = n; i >= 1; i--) {
            System.out.print(i + " ");
        }

        sc.close();
    }
}