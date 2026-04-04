package String;

import java.util.*;

public class LC459_RepeatedSubstringPattern {

    public static boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                String sub = s.substring(0, i);
                StringBuilder sb = new StringBuilder();

                int times = n / i;

                for (int j = 0; j < times; j++) {
                    sb.append(sub);
                }

                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        boolean result = repeatedSubstringPattern(input);

        System.out.println("Result: " + result);

        sc.close();
    }
}
