import java.util.Scanner;

public class A_Yogurt_Sale {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tt = sc.nextInt();

        while(tt-- > 0) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            int regularPrice = n * a;

            int t = n / 2;
            int disP = t * b;

            int r = n % 2;

            if(r > 0) {
                disP += a;
            }

            System.out.println(Math.min(regularPrice, disP));

        }

        sc.close();
    }
}