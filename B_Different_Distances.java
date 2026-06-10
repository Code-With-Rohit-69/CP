import java.util.Scanner;

public class B_Different_Distances {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        int[] shift = {0, 1, 3, 6};

        while (t-- > 0) {
            int n = sc.nextInt();

            StringBuilder sb = new StringBuilder();

            for (int s : shift) {
                for (int col = 0; col < n; col++) {
                    int val = Math.floorMod(col - s, n) + 1;
                    sb.append(val).append(' ');
                }
            }

            System.out.println(sb);
        }

        sc.close();
    }
}