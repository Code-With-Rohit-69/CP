import java.util.Scanner;

public class A_The_New_Year_Meeting_Friends {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt();
        int x2 = sc.nextInt();
        int x3 = sc.nextInt();

        int min = Math.min(x1, Math.min(x2, x3));

        int max = Math.abs(min - x1);
        max = Math.max(max, Math.abs(min - x2));
        max = Math.max(max, Math.abs(min - x3));

        System.out.println(max);

        sc.close();
    }
}