import java.util.Scanner;

public class A_Strange_Partition {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            long max = 0;
            long min = 0;

            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                max += Math.ceil((double) num / k);
                min += num;
            }

            min = (long) Math.ceil((double) min / k);

            System.out.println(min + " " + max);

        }

        sc.close();
    }
}
