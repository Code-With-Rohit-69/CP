import java.util.Scanner;

public class A_Unit_Array {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int negatives = 0;
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                negatives = arr[i] < 0 ? negatives + 1 : negatives;
            }

            int postives = n - negatives;
            int count = 0;

            while(negatives > postives || negatives % 2 == 1) {
                postives++;
                negatives--;
                count++;
            }

            System.out.println(count);


        }

        sc.close();
    }
}