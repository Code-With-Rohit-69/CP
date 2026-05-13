import java.util.Scanner;

public class C_Clock_Conversion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();

            int hr = Integer.parseInt(s.substring(0, 2));
            int mm = Integer.parseInt(s.substring(3));

            boolean isPM = hr > 12;

            if (hr >= 12) { 
                int hr12 = hr > 12 ? hr - 12 : hr;
                
                System.out.print(hr12 < 10 ? ("0" + hr12) : hr12);
                System.out.print(":" + (mm < 10 ? ("0" + mm) : mm) + " " + "PM");
            } else {

                if (hr == 0) {
                    System.out.print(12 + ":" + (mm < 10 ? ("0" + mm) : mm) + " " + "AM");
                } else {
                    System.out.print(hr < 10 ? ("0" + hr) : hr);
                    System.out.print(":" + (mm < 10 ? ("0" + mm) : mm) + " " + "AM");
                }

            }

            System.out.println();

        }

        sc.close();
    }
}