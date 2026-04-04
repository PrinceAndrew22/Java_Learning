package String;

import java.util.*;

public class LC38_CountAndSay {

    public static String countAndSay(int n) {
        String curr = "1";

        for (int k = 1; k < n; k++) {
            StringBuilder next = new StringBuilder();
            int i = 0;

            while (i < curr.length()) {
                int count = 1;

                while (i < curr.length() - 1 && curr.charAt(i) == curr.charAt(i + 1)) {
                    count++;
                    i++;
                }

                next.append(count).append(curr.charAt(i));
                i++;
            }

            curr = next.toString();
        }

        return curr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        String result = countAndSay(n);

        System.out.println("Result: " + result);

        sc.close();
    }
}
    
