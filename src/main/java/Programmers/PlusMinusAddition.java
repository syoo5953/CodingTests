package Programmers;

public class PlusMinusAddition {
    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        int[] nums = {4, 7, 12};
        boolean[] bool = {true, false, true};

        int answer = solution14.solution(nums, bool);
        System.out.println(answer);
    }
}

class Solution14 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        String[] temp = new String[absolutes.length];

        for (int i = 0; i < signs.length; i++) {
            if (signs[i] == false) {
                temp[i] = String.valueOf(absolutes[i]).replace(String.valueOf(absolutes[i]), "-" + absolutes[i]);
            } else {
                temp[i] = String.valueOf(absolutes[i]);
            }
        }

        for (String str : temp) {
            answer += Integer.parseInt(str);
        }

        return answer;
    }
}