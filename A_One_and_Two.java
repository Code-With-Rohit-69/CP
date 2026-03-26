import java.util.Scanner;

public class A_One_and_Two {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int totalTwos = 0;

            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if(arr[i] == 2) totalTwos++;
            }

            int index = -1;
            
            int currentTwos = 0;

            for(int i = 0; i < n; i++) {
                if(arr[i] == 2) currentTwos++;

                if(currentTwos == totalTwos - currentTwos) {
                    index = i + 1;
                    break;
                }
            }

            System.out.println(index);

        }

        sc.close();
    }
}