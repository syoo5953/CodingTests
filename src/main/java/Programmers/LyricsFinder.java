package Programmers;

public class LyricsFinder {
    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
        int[] answer = solution5.solution(words, queries);
        for(int num : answer) {
            System.out.println(num);
        }
    }
}

class Solution5 {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        int i = 0;
        for(String query : queries){
            char head = query.charAt(0);
            char foot = query.charAt(query.length()-1);
            String pattern = query.replace("?", "");
            int cnt = query.length() - pattern.length();
            int result = 0;

            if(head == '?'){
                pattern = "[a-z]"+"{" +cnt+ "}"+pattern;
            }else{
                pattern = pattern+"[a-z]"+"{" +cnt+ "}";
                System.out.println(pattern);
            }

            for(String word : words){
                if(word.matches(pattern)) {
                    result++;
                }
            }

            answer[i++] = result;
        }
        return answer;
    }
}
