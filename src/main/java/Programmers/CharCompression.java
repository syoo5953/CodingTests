package Programmers;

public class CharCompression {
    public static void main(String[] args) {
        Solution41 solution41= new Solution41();
        System.out.println(solution41.solution("aabbaccc"));
    }
}

class Solution41 {
    public int solution(String s) {
        int answer = 0;

        for(int i=1; i<=(s.length()/2)+1; i++){
            int result = getSplitedLength(s, i, 1).length();
            answer = i==1 ? result : (answer>result?result:answer);
        }

        return answer;
    }

    public String getSplitedLength(String s, int n, int repeat){ // aabbaccc
        if(s.length() < n) return s;
        String result = "";
        String preString = s.substring(0, n);
        String postString = s.substring(n);

        // 불일치 -> 현재까지 [반복횟수 + 반복문자] 조합
        if(!postString.startsWith(preString)){
            if(repeat == 1) {
                result += (preString + getSplitedLength(postString, n, 1));
                return result;
            }
            result += result + (repeat + preString + getSplitedLength(postString, n, 1));
            return result;

        }
        result += result + getSplitedLength(postString, n, repeat + 1);
        System.out.println("preString = " + preString + " postString = " + postString + " Result = " + result);
        return result;
    }
}