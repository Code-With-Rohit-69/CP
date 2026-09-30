import java.util.Scanner;

import java.util.Scanner;

/**
 * ARoundHouse
 */
public class ARoundHouse {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();        
        int a = sc.nextInt();
        int b = sc.nextInt();

        int house = (a + b) % n;

        if (house <= 0) {
            house += n;
        }

        System.out.println(house);

        sc.close();
    }
}