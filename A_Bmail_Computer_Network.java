import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A_Bmail_Computer_Network {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            arr[i] = sc.nextInt();
        }

        List<Integer> list = new ArrayList<>();
        list.add(n);

        while (n > 1) {
            list.add(arr[n - 2]);
            n = arr[n - 2];
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }

        sc.close();
    }
}