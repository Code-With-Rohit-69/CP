import java.util.*;

public class Main {

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public static void main(String[] args) {
        // int n = 1000;
        // int[] nums = new int[n];

        // Arrays.fill(nums, 1_000_000_000);

        // System.out.print("[");
        // for (int i = 0; i < n; i++) {
        //     if (i > 0) System.out.print(",");
        //     System.out.print(nums[i]);
        // }
        // System.out.println("]");

        System.err.println(gcd(7, 22) + " " + gcd(6, 22));
        System.err.println(gcd(1, 23) + " " + gcd(2, 23));

    }
}