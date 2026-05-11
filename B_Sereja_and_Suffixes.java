import java.util.HashSet;
import java.util.Scanner;

public class B_Sereja_and_Suffixes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();


        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        HashSet<Integer> set = new HashSet<>();

        int[] suffix = new int[n];

        for(int i = n - 1; i >= 0; i--) {
            set.add(arr[i]);
            suffix[i] = set.size();
        }

        for (int i = 0; i < m; i++) {
            int li = sc.nextInt();

            System.out.println(suffix[li - 1]);

        }

        sc.close();
    }
}