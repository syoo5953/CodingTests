package Programmers;

import java.util.HashSet;

public class Pokemon {
    public static void main(String[] args ) {
        Solution12 solution12 = new Solution12();
        int[] nums = {3,3,3,2,2,4};
        System.out.println(solution12.solution(nums));
    }
}

class Solution12 {
    public int solution(int[] nums) {
        int answer;
        HashSet<Integer> map = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            map.add(nums[i]);
        }
        answer = map.size();

        if(answer > nums.length/2) {
            answer = nums.length/2;
        }
        return answer;
    }
}
