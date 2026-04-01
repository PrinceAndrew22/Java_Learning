package Array;

import java.util.*;

public class LC658_FindKClosestElements {

    static class Solution {
        public List<Integer> findClosestElements(int[] A, int k, int x) {
            int left = 0, right = A.length - k;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (x - A[mid] > A[mid + k] - x)
                    left = mid + 1;
                else
                    right = mid;
            }

            List<Integer> result = new ArrayList<>(k);
            for (int i = left; i < left + k; i++) {
                result.add(A[i]);
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter sorted array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        System.out.print("Enter x: ");
        int x = sc.nextInt();

        Solution obj = new Solution();
        List<Integer> result = obj.findClosestElements(arr, k, x);

        System.out.println("Closest elements: " + result);

        sc.close();
    }
}
