package Programmers;

public class NumbersAndWords {
    public static void main(String[] args ) {
        String s = "2zero45sixseven";
        Solution47 solution47 = new Solution47();
        solution47.solution(s);
    }
}

class Solution47 {public int solution(String s) {
    int answer;
    String[] array = {"zero", "one", "two", "three", "four"," five", "six", "seven", "eight"," nine"};
    char[] chArray = s.toCharArray();
    String word = new String();
    String ans = new String();
    for(int i = 0; i < chArray.length; i++) {
        if(!Character.isDigit(chArray[i])) {
            word += chArray[i];
            for(int j = 0; j < array.length; j++) {
                if(word.equals(array[j])) {
                    ans += j;
                    word = new String();
                }
            }
        } else {
            ans += chArray[i];
        }
    }
    answer = Integer.parseInt(ans);
    System.out.println(answer);
    return answer;
}

}