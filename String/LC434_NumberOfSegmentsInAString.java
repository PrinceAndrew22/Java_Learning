package String;

import java.util.*;

public class LC434_NumberOfSegmentsInAString {

    static class Solution {
        public int countSegments(String s) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String input = sc.nextLine();

        Solution obj = new Solution();
        int result = obj.countSegments(input);

        System.out.println("Number of segments: " + result);

        sc.close();
    }
}