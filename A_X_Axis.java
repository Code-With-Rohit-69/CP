import java.util.Scanner;

public class A_X_Axis {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            int[] arr = new int[3];
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for(int i = 0; i < 3; i++) {
                arr[i] = sc.nextInt();
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i]);
            }

            System.out.println(max - min);

        }

        sc.close();
    }
}