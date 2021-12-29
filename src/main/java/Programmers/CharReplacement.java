package Programmers;

public class CharReplacement {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.solution("ababcdcdababcdcd"));
    }
}

class Solution2 {
    public int solution(String s) {
        int answer = 0;

        for(int i=1; i<=(s.length()/2)+1; i++){
            String res = getSplitedLength(s, i, 1);
            int result = res.length();
            answer = i==1 ? result : (Math.min(answer, result));
            System.out.println("i = " + i + " Res = " + res + " Answer = " + answer);
        }

        return answer;
    }

    public String getSplitedLength(String s, int n, int repeat){
        if(s.length() < n) {
            return s;
        }

        String preString = s.substring(0, n);
        String postString = s.substring(n);

        if(!postString.startsWith(preString)){
            if(repeat == 1) {
                return preString + getSplitedLength(postString, n, 1);
            } else {
                return repeat + preString + getSplitedLength(postString, n, 1);
            }
        }
        return getSplitedLength(postString, n, repeat + 1);
    }
}