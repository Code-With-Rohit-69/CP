import java.util.Scanner;

public class C_Raspberries {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            long product = 1;
            int nearest = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                product *= num;

                if(num < k) {
                    nearest = Math.min(nearest, k - num);
                } else {
                    int times = (int) Math.ceil((double) num / k);
                    nearest = Math.min(nearest, times * k - num);
                }

            }

            if(product % k == 0) {
                System.out.println(0);
                continue;
            }

            System.out.println(nearest);

        }

        sc.close();
    }
}