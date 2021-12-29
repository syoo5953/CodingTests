package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class NthRaw {
    public static void main(String[] argss){
        Solution28 solution28 = new Solution28();
        int n = 3;
        int k = 5;
        int[] answer = solution28.solution(n,k);
        for(int i : answer) {
            System.out.println(i);
        }
    }
}

class Solution28 {
    public int[] solution(int n, long k) {
        int[] answer = {};
        final int[] count = {0};
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = String.valueOf(i+1);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                count[0]++;
                System.out.println(count[0]);
                return Integer.valueOf(o2).compareTo(Integer.valueOf(o1));
            }
        });
        return answer;
    }
}