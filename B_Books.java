        import java.util.*;

        public class B_Books {

            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);

                int n = sc.nextInt(), t = sc.nextInt();

                int[] arr = new int[n];

                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }

                int max = 0;
                int left = 0;

                int curr = 0;

                for(int i = 0; i < n; i++) {
                    curr += arr[i];

                    while(curr > t && left <= i) {
                        curr -= arr[left];
                        left++;
                    }

                    max = Math.max(i - left + 1, max);

                }

                System.out.println(max);

                sc.close();
            }
        }