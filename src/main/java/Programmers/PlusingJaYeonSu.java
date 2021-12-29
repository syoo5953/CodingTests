package Programmers;

public class PlusingJaYeonSu {
    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        solution42.solution(15);
    }
}

class Solution42 {
    public int solution(int n) {
        int answer = 0;

        for(int i=1; i<=n ;i++){
            int sum=0;

            for(int j = i; sum < n; j++){
                sum += j;
                System.out.println("j = " + j + " sum  = " +sum);
                if(sum == n){
                    answer+=1;
                }
            }
            System.out.println();
        }

        return answer;
    }
}