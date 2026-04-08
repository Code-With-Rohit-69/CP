import java.util.Scanner;

public class A_Choosing_Teams {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int count = 0;

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if(5 - arr[i] >= k) {
                count++;
            }
        }

        System.out.println(count / 3);

        sc.close();
    }
}