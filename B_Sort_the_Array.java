import java.util.Scanner;

public class B_Sort_the_Array {

    public static void reverse(int[] arr, int l, int r) {
        int i = l, j = r;

        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int l = 0;

        while (l < n - 1 && arr[l] < arr[l + 1]) {
            l++;
        }

        if(l == n - 1) {
            System.out.println("yes");
            System.out.println("1 1");
            return;
        }

        int r = l;

        while (r < n - 1 && arr[r] > arr[r + 1]) {
            r++;
        }

        reverse(arr, l, r);

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                System.out.println("no");
                sc.close();
                return;
            }
        }

        System.out.println("yes");
        System.out.println((l + 1) + " " + (r + 1));

        sc.close();
    }
}