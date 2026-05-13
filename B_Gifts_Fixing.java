import java.util.Scanner;

public class B_Gifts_Fixing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            long minA = Integer.MAX_VALUE;
            long minB = Integer.MAX_VALUE;

            long[] a = new long[n];
            long[] b = new long[n];

            for(int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                minA = Math.min(minA, a[i]);
            }

            for(int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
                minB = Math.min(minB, b[i]);
            }

            long count = 0;

            for (int i = 0; i < n; i++) {
                if(a[i] > minA && b[i] > minB) {
                    
                    if(a[i] < b[i]) {
                        long d = a[i] - minA;
                        count += d;
                        b[i] -= d;
                        a[i] = minA;
                    } else {
                        long d = b[i] - minB;
                        count += d;
                        a[i] -= d;
                        b[i] = minB;
                    }
                    
                    i--;

                } else if(a[i] > minA) {
                    count += a[i] - minA;
                } else if(b[i] > minB) {
                    count += b[i] - minB;
                }
            }

            System.out.println(count);

        }

        sc.close();
    }
}