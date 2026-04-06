package Array;

import java.util.*;

public class LC632_SmallestRangeCoveringElementsFromKLists {

    static class Node {
        int value;
        int row;
        int col;

        Node(int v, int r, int c) {
            value = v;
            row = r;
            col = c;
        }
    }

    public static int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
        int max = Integer.MIN_VALUE;

        // Initialize heap
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            pq.add(new Node(val, i, 0));
            max = Math.max(max, val);
        }

        int start = 0, end = Integer.MAX_VALUE;

        while (true) {
            Node curr = pq.poll();
            int min = curr.value;

            if (max - min < end - start) {
                start = min;
                end = max;
            }

            if (curr.col + 1 < nums.get(curr.row).size()) {
                int nextVal = nums.get(curr.row).get(curr.col + 1);
                pq.add(new Node(nextVal, curr.row, curr.col + 1));
                max = Math.max(max, nextVal);
            } else {
                break;
            }
        }

        return new int[]{start, end};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of lists: ");
        int k = sc.nextInt();

        List<List<Integer>> nums = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            System.out.print("Enter size of list " + (i + 1) + ": ");
            int n = sc.nextInt();

            List<Integer> list = new ArrayList<>();
            System.out.println("Enter elements (sorted):");

            for (int j = 0; j < n; j++) {
                list.add(sc.nextInt());
            }

            nums.add(list);
        }

        int[] result = smallestRange(nums);

        System.out.println("Smallest Range: [" + result[0] + ", " + result[1] + "]");

        sc.close();
    }
}