package Programmers;

public class IDrecommendation {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.solution("a-bc...zeref922");
        System.out.println(result);
    }
}


class Solution {
    public String solution(String new_id) {
        String answer = "";
        String temp = new_id.toLowerCase();
        temp = temp.replaceAll("[^-_.a-z0-9]","");
        System.out.println(temp);
        temp = temp.replaceAll("[.]{2,}",".");
        temp = temp.replaceAll("^[.]|[.]$","");
        if(temp.equals(""))
            temp+="a";
        if(temp.length() >=16){
            temp = temp.substring(0,15);
            temp=temp.replaceAll("[.]$","");
        }
        if(temp.length() <= 2) {
            while(temp.length() < 3) {
                temp+=temp.charAt(temp.length()-1);
            }
        }
        answer = temp;
        return answer;
    }
}