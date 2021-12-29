package Programmers;

public class TargetNumber {
    public static void main(String[] args) {
        Solution59 solution = new Solution59();
        int[] numbers = {1,2,3,4,5};
        System.out.println("Answer = " + solution.solution(numbers, 9));
    }
}

class Solution59 {
    static int answer=0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }

    public void dfs(int[] num, int index, int value, int t){
        if(index==num.length){
            if(value==t) answer++;
        }else{
            int minus= value-num[index];
            int plus= value+num[index];
            dfs(num, index+1, minus, t);
            dfs(num, index+1, plus, t);
        }
    }
}