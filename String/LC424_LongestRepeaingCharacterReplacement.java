package String;

import java.util.*;

public class LC424_LongestRepeaingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int res = 0;
        int max = 0;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {           
            arr[s.charAt(r) - 'A']++;            
            max = Math.max(max, arr[s.charAt(r) - 'A']);            

            if (r - l + 1 - max > k) {             
                arr[s.charAt(l) - 'A']--;
                l++;
            }           

            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string (only A-Z): ");
        String s = sc.nextLine();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        LC424_LongestRepeaingCharacterReplacement sol =
                new LC424_LongestRepeaingCharacterReplacement();

        int result = sol.characterReplacement(s, k);

        System.out.println("Result: " + result);

        sc.close();
    }
}
