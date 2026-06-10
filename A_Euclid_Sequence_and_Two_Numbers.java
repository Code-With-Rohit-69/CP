import java.util.Arrays;
import java.util.Scanner;

public class A_Euclid_Sequence_and_Two_Numbers {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tt = sc.nextInt();

        while(tt-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            
            Arrays.sort(arr);

            if (n == 2) { 
                System.out.println(arr[n - 1] + " " + arr[n - 2]);
                continue;
            }


            boolean valid = true;

            for(int i = n - 3; i >= 0; i--) {
                if(arr[i + 2] % arr[i + 1] != arr[i]) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                System.out.println(arr[n - 1] + " " + arr[n - 2]);
            } else {
                System.out.println(-1);
            }

        }

        sc.close();
    }
}
