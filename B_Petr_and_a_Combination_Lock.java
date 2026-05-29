import java.util.Scanner;

public class B_Petr_and_a_Combination_Lock {

    public static boolean dfs(int[] arr, int index, int rotate) {
        
        if (index == arr.length) {
            return rotate % 360 == 0;
        }


        return dfs(arr, index + 1, rotate + arr[index]) || dfs(arr, index + 1, rotate - arr[index]);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean res = dfs(arr, 0, 0);

        System.out.println(res ? "YES" : "NO");

        sc.close();
    }
}