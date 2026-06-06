import java.util.Scanner;

public class B_Permutation_Swap {

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int k = Math.abs(arr[0] - 1);

            for (int i = 1; i < n; i++) {
                k = gcd(k, Math.abs(arr[i] - (i + 1)));
            }

            System.out.println(k);

        }

        sc.close();
    }
}
