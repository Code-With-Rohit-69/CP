import java.util.Arrays;
import java.util.Scanner;

public class B_A_and_B_and_Compilation_Errors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] arr2 = new int[n - 1];

        for(int i = 0; i < n - 1; i++) {
            arr2[i] = sc.nextInt();
        }

        int[] arr3 = new int[n - 2];

        for(int i = 0; i < n - 2; i++) {
            arr3[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        Arrays.sort(arr2);
        Arrays.sort(arr3);

        int debug1 = -1;
        int debug2 = -1;

        // a and b

        int i = 0;

        while (true) {

            if (i >= arr2.length) {
                debug1 = arr[i];
                break;
            }
            
            if (arr[i] != arr2[i]) {
                debug1 = arr[i];
                break;
            }

            i++;

        }

        i = 0;

        // b and c

        while (true) {
            
            if (i >= arr3.length) {
                debug2 = arr2[i];
                break;
            }
            
            if (arr2[i] != arr3[i]) {
                debug2 = arr2[i];
                break;
            }

            i++;

        }

        System.out.println(debug1);
        System.out.println(debug2);

        sc.close();
    }
}