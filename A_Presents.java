import java.util.Scanner;

public class A_Presents {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            res[arr[i] - 1] = i + 1;
        }

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

        sc.close();
    }
}