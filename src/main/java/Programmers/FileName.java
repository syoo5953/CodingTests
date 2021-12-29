package Programmers;

import java.util.*;


public class FileName {
    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        Solution22 solution22 = new Solution22();
        String[] answer = solution22.solution(files);
        for(String str : answer) {
            System.out.println(str);
        }
    }
}

class Solution22 {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String head1 = o1.split("[0-9]")[0];
                String head2 = o2.split("[0-9]")[0];
                int result = head1.compareToIgnoreCase(head2);
                if(result==0){
                    return convert(o1, head1.length()) - convert(o2, head2.length());
                }
                return result;
            }
        });
        return files;
    }

    public int convert(String str, int l){
        str = str.substring(l);
        System.out.println("str = "  + str);
        String result = "";
        for(char c : str.toCharArray()){
            System.out.println("c = " + c);
            if(Character.isDigit(c) && result.length()<=5)
            {
                result+=c;
                System.out.println("result = " + result);
            }
            else break;
        }
        System.out.println("Sedning...");
        return Integer.parseInt(result);
    }
}