    import java.util.*;

    public class B_Books {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt(), t = sc.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int mid = n / 2;
            int count = 0;

            for (int i = mid; i < n; i++) {
                if(arr[i] <= t) {
                    count++;
                    t -= arr[i];
                }
            }

            mid -= 1;

            while (mid >= 0 && arr[mid] <= t && t > 0) {
                count++;
                t -= arr[mid];  
                mid--;
            }

            System.out.println(count);

            sc.close();
        }
    }