import java.util.Scanner;

public class B_Sort_the_Array {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 0;
        int c = 0;

        for (int i = 1; i < n; i++) {
            if(arr[i] < arr[i - 1]) {
                c++;
            } else {
                if(c > 0) {
                    c = 0;
                    count++;
                }
            }
        }

        if(c > 0) {
            count++;
        }

        if (count < 2) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

        sc.close();
    }
}