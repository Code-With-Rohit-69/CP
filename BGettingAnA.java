import java.util.*;

public class BGettingAnA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] A = new int[n];
        int sum = 0;

        for(int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
            sum += A[i];
        }

        Arrays.sort(A);

        int count = 0;
        int index = 0;

        while(true) {
            double average = (double) sum / n;

            if(average >= 4.5) {
                break;
            }

            if(A[index] == 5) {
                index++;
                continue;
            }

            sum += 5 - A[index];
            A[index] = 5;
            count++;
            index++;
        }

        System.out.println(count);

    }
}