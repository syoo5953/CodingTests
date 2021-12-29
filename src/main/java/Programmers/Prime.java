package Programmers;

import java.util.ArrayList;

public class Prime {
    public static void main(String[] args) {
        Solution37 solution37 = new Solution37();
        System.out.println(solution37.solution(110011, 10));
    }
}

class Solution37 {
    public int solution(int n, int k) {
        String array = Integer.toString(n, k);
        char[] ch = array.toCharArray();
        int count = 0;

        int i = 0;
        while(array.length() > 0) {
            if(ch[i] == '0') {
                String str = array.substring(0, i);
                System.out.println(str);
                if((str.substring(1,str.length()-1).equals("0"))) {
                } else if(str.length() == 2 && (str.substring(0, str.length()-1).equals("0"))){
                } else {
                    count++;
                }
                array = array.substring(i);
                i = 0;
            }
            i++;
        }
        return count;
    }
}