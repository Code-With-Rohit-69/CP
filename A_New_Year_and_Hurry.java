import java.util.Scanner;

public class A_New_Year_and_Hurry {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), k = sc.nextInt();

        int restTime = 240 - k;
        
        int i = 1;
        
        while (true) {
            if(i > n) break;
            if (restTime - 5 * i >= 0) {
                restTime -= 5 * i;
                i++;
            } else {
                break;
            }
        }

        System.out.println(i - 1);

        sc.close();
    }
}
