import java.util.Scanner;

public class A_Vasya_the_Hipster {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(), b = sc.nextInt();
        int min = Math.min(a, b);

        System.out.print(min + " ");

        int sameSocks = Math.max(a, b) - min;

        System.out.print(sameSocks / 2);

        sc.close();
    }
}