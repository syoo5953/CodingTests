package Programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class MenuRenewal {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        String[] ans = solution1.solution(orders, course);
        for (String str : ans) {
            //System.out.println(str);
        }
    }
}


class Solution1 {

    static HashMap<String, Integer> map;
    static int m;

    public String[] solution(String[] orders, int[] course) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        for (int i = 0; i < course.length; i++) {
            map = new HashMap<>();
            m = 0;

            for (int j = 0; j < orders.length; j++) {
                find(0, 0, "", course[i], orders[j]);
            }

            for (String s : map.keySet()) {
                if (map.get(s) == m && m > 1) {
                    pq.offer(s);
                }
            }
        }
        String ans[] = new String[pq.size()];
        int k = 0;
        while (!pq.isEmpty()) {
            ans[k++] = pq.poll();
        }
        return ans;
    }

    static void find(int cnt, int idx, String str, int targetNum, String word) {
        if (cnt == targetNum) {
            System.out.println("성공: " + "index = " + idx + " cnt = " + cnt + " " + "targetNum = " + targetNum + " str = " + str + " word = " + word);

            String temps = str;
            System.out.println("temps: " + temps);
            System.out.println();
            map.put(temps, map.getOrDefault(temps, 0) + 1);
            m = Math.max(m, map.get(temps));
            return;
        }
        for (int i = idx; i < word.length(); i++) {
            System.out.println("index = " + i + " cnt = " + cnt + " " + "targetNum = " + targetNum + " str = " + str + " word = " + word);

            char now = word.charAt(i);
            System.out.println("STR = " + str + " NOW = " + now);
            find(cnt + 1, i + 1,str + now, targetNum, word);
        }
        System.out.println("끝-----------");
    }
}