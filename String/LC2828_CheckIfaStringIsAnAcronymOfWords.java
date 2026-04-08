package String;

import java.util.*;

public class LC2828_CheckIfaStringIsAnAcronymOfWords {

    public static boolean isAcronym(List<String> words, String s) {
        if (words.size() != s.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            if (words.get(i).charAt(0) != s.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of words: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        List<String> words = new ArrayList<>();

        System.out.println("Enter words:");
        for (int i = 0; i < n; i++) {
            words.add(sc.nextLine());
        }

        System.out.print("Enter acronym string: ");
        String s = sc.nextLine();

        boolean result = isAcronym(words, s);

        System.out.println("Is Acronym: " + result);

        sc.close();
    }
}