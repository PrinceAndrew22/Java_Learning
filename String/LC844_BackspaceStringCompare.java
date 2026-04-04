package String;

import java.util.*;

public class LC844_BackspaceStringCompare {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User input
        System.out.print("Enter first string: ");
        String s = sc.nextLine();

        System.out.print("Enter second string: ");
        String t = sc.nextLine();

        Solution obj = new Solution();
        boolean result = obj.backspaceCompare(s, t);

        System.out.println("Result: " + result);

        sc.close();
    }
}

class Solution {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    public String build(String str) {
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c != '#') sb.append(c);
            else if (sb.length() > 0) sb.setLength(sb.length() - 1);
        }

        return sb.toString();
    }
}
