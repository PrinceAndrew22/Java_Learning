package String;

import java.util.*;

public class LC591_TagValidator {

    public static boolean isValid(String code) {
        Stack<String> st = new Stack<>();
        int i = 0, n = code.length();

        while (i < n) {
            if (i > 0 && st.isEmpty()) return false;

            if (code.startsWith("<![CDATA[", i)) {
                int j = code.indexOf("]]>", i);
                if (j < 0) return false;
                i = j + 3;
            } 
            else if (code.startsWith("</", i)) {
                int j = code.indexOf(">", i);
                if (j < 0) return false;

                String tag = code.substring(i + 2, j);
                if (st.isEmpty() || !st.peek().equals(tag)) return false;

                st.pop();
                i = j + 1;
            } 
            else if (code.startsWith("<", i)) {
                int j = code.indexOf(">", i);
                if (j < 0) return false;

                String tag = code.substring(i + 1, j);

                if (tag.length() < 1 || tag.length() > 9) return false;

                for (char c : tag.toCharArray()) {
                    if (!Character.isUpperCase(c)) return false;
                }

                st.push(tag);
                i = j + 1;
            } 
            else {
                i++;
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter code string:");
        String code = sc.nextLine();

        boolean result = isValid(code);

        System.out.println("Valid XML-like Code: " + result);

        sc.close();
    }
}