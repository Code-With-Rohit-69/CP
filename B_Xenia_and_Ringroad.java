import java.util.Scanner;

public class B_Xenia_and_Ringroad {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();

        long[] arr = new long[m];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        long time = arr[0] - 1;

        for(int i = 1; i < m; i++) {
            long house = arr[i];

            if(house < arr[i - 1]) {
                time += n - arr[i - 1] + arr[i];
            } else {
                time += arr[i] - arr[i - 1];
            }
        }

        System.out.println(time);

        sc.close();
    }
}