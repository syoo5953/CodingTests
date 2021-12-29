package Programmers;

public class Collatz {
    public static void main(String[] args) {
        Solution25 solution25 = new Solution25();
        System.out.println("answer = " + solution25.solution(62633154));
    }
}

class Solution25 {
    public int solution(int num) {
        long number = num;
        for (int i = 0; i < 500; i++) {
            if (number == 1) {
                return i;
            }

            if (number % 2 == 0) {
                System.out.println(number);
                number /= 2;
            } else {
                System.out.println(number);
                number = (number * 3) + 1;
            }
        }
        return -1;
    }
}