package Programmers;

public class NumberAndChar {
    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        int answer = solution10.solution("one4seveneight");
        System.out.println(answer);
    }
}

class Solution10 {
    public int solution(String s) {

        String[] alphabets = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        for(int i=0; i<alphabets.length; i++){
            s = s.replaceAll(alphabets[i],Integer.toString(i));
        }

        return Integer.parseInt(s);
    }
}