import java.util.Arrays;
import java.util.Scanner;

public class B_Kuriyama_Mirai_s_Stones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] v = new int[n];

        for (int i = 0; i < v.length; i++) {
            v[i] = sc.nextInt();
        }

        int[] u = Arrays.copyOf(v, v.length);
        Arrays.sort(u);

        long[] preV = new long[n];
        long[] preU = new long[n];

        preV[0] = v[0];
        preU[0] = u[0];

        for (int i = 1; i < n; i++) {
            preV[i] = v[i] + preV[i - 1];
            preU[i] = u[i] + preU[i - 1];
        }

        int m = sc.nextInt();

        while (m-- > 0) {
            int type = sc.nextInt();
            int l = sc.nextInt() - 1;
            int r = sc.nextInt() - 1;

            if (type == 1) {
                System.out.println(l - 1 < 0 ? preV[r] : preV[r] - preV[l - 1]);
            } else {
                System.out.println(l - 1 < 0 ? preU[r] : preU[r] - preU[l - 1]);
            }

        }

        sc.close();
    }
}