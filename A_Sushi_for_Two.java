import java.util.Scanner;

public class A_Sushi_for_Two {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean isTwo = arr[0] == 2;
        int two = arr[0] == 2 ? 1 : 0;
        int one = arr[0] != 2 ? 1 : 0;

        int ans = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                if (arr[i] == 2) {
                    two++;
                } else {
                    one++;
                }
            } else {
                isTwo = !isTwo;
                int min = Math.min(one, two);

                
                ans = Math.max(ans, 2 * min);
                // System.out.println("index: " + i + " one: " + one + " two: " + two + " min: " + min + " ans " + ans);

                if (arr[i] == 1) {
                    one = 1;
                } else {
                    two = 1;
                }
            }
            
        }

        int min = Math.min(one, two);

                
        ans = Math.max(ans, 2 * min);

        System.out.println(ans);

        sc.close();
    }
}