package Programmers;

import java.util.*;

public class MoeGosa {
    public static void main(String[] args) {
        int[] answers = {1,3,2,4,2};
        Solution33 solution33 = new Solution33();
        int[] ans = solution33.solution(answers);
        for(int i : ans) {
            System.out.println(i);
        }
    }
}

class Solution33 {
    public int[] solution(int[] answers) {
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};

        int f_cnt = 0;
        int s_cnt = 0;
        int t_cnt = 0;

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == first[i%5]) {
                f_cnt++;
            }
            if(answers[i] == second[i%8]) {
                s_cnt++;
            }
            if(answers[i] == third[i%10]) {
                t_cnt++;
            }
        }

        int max = Math.max(f_cnt, Math.max(s_cnt, t_cnt));
        System.out.println("max = " + max);
        ArrayList<Integer> list = new ArrayList<>();

        if(max == f_cnt) {list.add(1);}
        if(max == s_cnt) {list.add(2);}
        if(max == t_cnt) {list.add(3);}
        System.out.println("list = " + list);
        return list.stream().mapToInt(i->i.intValue()).toArray();
    }
}