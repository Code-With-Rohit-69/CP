import java.util.Scanner;

public class A_Almost_Prime {

    static int[] primes;

    public static void seive() {
        for (int i = 2; i < primes.length; i++) {
            if (primes[i] == 0) {
                for (int j = 2 * i; j < primes.length; j += i) {
                    primes[j] += 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        primes = new int[n + 1];

        seive();
        
        int count = 0;

        for (int i = 1; i < n + 1; i++) {
            if (primes[i] == 2) {
                count++;
            }
        }

        System.out.println(count);

        sc.close();
    }
}