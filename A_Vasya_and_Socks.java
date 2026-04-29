import java.util.Scanner;

public class A_Vasya_and_Socks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();
        int days = 0;

        while (n > 0) {
            days++;
            n--;
            if(days % m == 0) n++;
        }

        System.out.println(days);

        sc.close();
    }
}