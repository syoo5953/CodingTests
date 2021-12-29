package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HackerTest1 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(1);
        list.add(3);
        list.add(2);
        System.out.println(minMove(list));
    }

    public static int minMove(List<Integer> arr) {
        Object[] array = arr.toArray();
        int moveIdx = 0;
        for (int num : arr) {
            array[moveIdx++] = num;
        }
        Object[] goal = array.clone();
        Arrays.sort(goal);

        int j = 0;
        int ans = array.length;

        for (Object found : array) {
            System.out.println("found = " + found + " goal = " + goal[j]);
            if (found == goal[j]) {
                j++;
                ans--;
            }
        }
        return ans;
    }
}

