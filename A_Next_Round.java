import java.util.Scanner;

public class A_Next_Round {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), t = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if(arr[i] > 0 && arr[i] >= arr[t - 1]) count++;
        }

        System.out.println(count);

        sc.close();
    }
}