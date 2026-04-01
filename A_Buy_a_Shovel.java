import java.util.Scanner;

public class A_Buy_a_Shovel {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt(), r = sc.nextInt();
        int temp = k;

        int c = 1;

        while (temp % 10 != 0 && temp % 10 != r) {
            c++;
            temp = k * c;
        }

        System.out.println(c);

        sc.close();
    }
}