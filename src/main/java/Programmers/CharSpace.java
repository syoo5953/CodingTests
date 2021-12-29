package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class CharSpace {
    public static void main(String[] args) {
        Solution27 solution27 = new Solution27();
        solution27.solution("a a a b b b b");
    }
}

class Solution27 {
    public String solution(String s) {
        String answer = "";
        String[] strs = s.split(" ");
        Arrays.sort(strs, Comparator.comparing(Integer::valueOf));
        answer = strs[0] + " " + strs[strs.length-1];
        return answer;
    }
}
