package Programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class Printer {
    public static void main(String[] args) {
        Solution45 solution45 = new Solution45();
        int[] priorities = {1,1,9,1,1,1};
        int location = 0;
        solution45.solution(priorities, location);
    }
}

class Solution45 {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
        }

        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                //System.out.print(pq);
                //System.out.println(" i = " + i + " count = " + answer);
                if (priorities[i] == pq.peek()) {
                    if (i == location) {
                        answer++;
                        //System.out.println("조건문 = "  + pq + " i = " + i + " answer = " + answer);
                        return answer;
                    }
                    pq.poll();
                    answer++;
                }
            }
        }
        return -1;
    }
}