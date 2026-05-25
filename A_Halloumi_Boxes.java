import java.util.Scanner;

public class A_Halloumi_Boxes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt(), k = sc.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            boolean isSorted = true;

            for(int i = 1; i < n; i++) {
                if(arr[i] < arr[i - 1]) {
                    isSorted = false;
                    break;
                }
            }

            if (!isSorted && k == 1) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }

        }

        sc.close();
    }
}