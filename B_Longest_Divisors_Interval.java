import java.util.Scanner;

public class B_Longest_Divisors_Interval {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

		int t = scanner.nextInt();

		while (t-- > 0) {
			long n = scanner.nextLong();

			int i = 1;

			while (n % i == 0) { // O(60)
				i++;
			}

			System.out.println(i - 1);
		}
        
		scanner.close();
    }
}
