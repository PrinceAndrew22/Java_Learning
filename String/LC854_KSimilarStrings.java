package String;
import java.util.*;

class Solution{

    public int kSimilarities(String s1, String s2){
        if(s1.equals(s2)) return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(s1);
        visited.add(s1);

        int swap = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int count=0;count<size;count++){
                String curr = queue.poll();
                
                if(curr.equals(s2)) return swap;

                int i=0;
                while(curr.charAt(i)==s2.charAt(i)) i++;
                for(int j=i+1;j<curr.length();j++){
                    if(curr.charAt(j)==s2.charAt(i) && curr.charAt(j) != s2.charAt(j)){
                        char[] arr = curr.toCharArray();
                        char temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        String next = new String(arr);

                        if(!visited.contains(next)){
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                }
            }
            swap++;
        }
        return -1;
    }
}

public class LC854_KSimilarStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string s1: ");
        String s1 = sc.nextLine();

        System.out.print("Enter string s2: ");
        String s2 = sc.nextLine();

        Solution sol = new Solution();
        int result = sol.kSimilarities(s1, s2);
        System.out.println("Minimum number of swaps required: " + result);
    }
}