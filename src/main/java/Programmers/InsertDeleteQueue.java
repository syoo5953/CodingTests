package Programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class InsertDeleteQueue {
    public static void main(String[] args) {
        String[] operations ={"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        Solution31 solution31 = new Solution31();
        int[] answer = solution31.solution(operations);
        System.out.println("===========================");
        for(int i : answer) {
            System.out.print(i +" ");
        }
    }
}

class Solution31 {
    static PriorityQueue<Integer> minQueue = new PriorityQueue<>();
    static PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        for(String opts: operations) {
            String[] str = opts.split(" ");
            if(str[0].equals("I")) {
                Insert(Integer.parseInt(str[1]));
            }

            if(minQueue.size() > 0) {
                if(str[0].equals("D") && str[1].equals("1")) {
                    DeleteMax();
                } else if(str[0].equals("D") && str[1].equals("-1")) {
                    DeleteMin();
                }
            }
        }
        if(maxQueue.size() == 0) {
            return answer;
        } else {
            answer[0] = maxQueue.poll();
            answer[1] = minQueue.poll();
        }
        return answer;
    }

    static void Insert(int num) {
        maxQueue.add(num);
        minQueue.add(num);
    }

    static void DeleteMax() {
        int max = maxQueue.poll();
        minQueue.remove(max);
    }

    static void DeleteMin() {
        int min = minQueue.poll();
        maxQueue.remove(min);
    }
}