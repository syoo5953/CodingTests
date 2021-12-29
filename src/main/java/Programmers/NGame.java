package Programmers;

import java.util.Stack;

public class NGame {
    public static void main(String[] args){
        Solution9 solution9 = new Solution9();
        String answer = solution9.solution(16, 8, 2, 1);
        System.out.println(answer);
    }
}

class Solution9 {
    public String solution(int n, int t, int m, int p) {
        String answer = "";

        int startNum = 0;
        String targetString = new String();
        String retString = new String();

        while (targetString.length() < m * t) {
            targetString += Integer.toString(startNum++, n);
        }

        for (int i=0; i<t; i++) {
            retString += targetString.charAt(p - 1 + i * m);
        }

        answer = retString.toUpperCase();


        return answer;
    }
}