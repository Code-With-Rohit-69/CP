import java.util.Arrays;
import java.util.Scanner;

public class B_Taxi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        int cars = 0;
        int remaining = 0;

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if(arr[i] > remaining) {
                cars++;
                remaining = 4;
            }

            remaining -= arr[i];
        }
        
        System.out.println(cars);

        sc.close();
    }
}