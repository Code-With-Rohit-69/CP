import java.util.Scanner;

public class A_IQ_test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean found = false;

        for(int i = 1; i < n - 1; i++) {
            if (arr[i] % 2 == 0 && arr[i - 1] % 2 != 0 && arr[i + 1] % 2 != 0) { 
                System.out.println(i + 1);
                found = true;
                break;
            }

            if (arr[i] % 2 != 0 && arr[i - 1] % 2 == 0 && arr[i + 1] % 2 == 0) { 
                System.out.println(i + 1);
                found = true;
                break;
            }
        }

        if(!found) {
            if((arr[0] % 2 == 0 && arr[1] % 2 != 0) || (arr[0] % 2 != 0 && arr[1] % 2 == 0)) {
                System.out.println(1);
            } else if ((arr[n - 1] % 2 == 0 && arr[n - 2] % 2 != 0) || (arr[n - 1] % 2 != 0 && arr[n - 2] % 2 == 0)) {
                System.out.println(n);
            }
        }

        sc.close();
    }
}