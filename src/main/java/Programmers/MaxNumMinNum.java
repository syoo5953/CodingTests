package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class MaxNumMinNum {
    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        String s ="-1 -2 -3 -4";
        System.out.println(solution26.solution(s));
    }
}

class Solution26 {
    public String solution(String s) {
        String answer = "";
        String[] strs = s.split(" ");
        Arrays.sort(strs, Comparator.comparing(Integer::valueOf));
        answer = strs[0] + " " + strs[strs.length-1];
        return answer;
    }
}