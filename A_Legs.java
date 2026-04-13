import java.util.Scanner;

public class A_Legs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int count = 0;
            
            count = n / 4;
            n %= 4;

            count += n / 2;

            System.out.println(count);

        }

        sc.close();
    }
}