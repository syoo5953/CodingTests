package Programmers;

public class YukSoonSort {

    static void sort(int[] nums) {
        for(int i = 0; i < nums.length/2; i++) {
            int temps = nums[i];
            nums[i] = nums[nums.length-1-i];
            nums[nums.length-1-i] = temps;
            for(int num : nums) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {21, 10, 8, -6, 37, 55};
        sort(nums);
    }
}
