package Programmers;

public class AutomaticSearch {
    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        String[] words = {"word","war","warrior","world"};
        int answer = solution8.solution(words);
        System.out.println(answer);
    }
}

class Solution8 {

    class Trie {
        Trie[] child = new Trie[26];
        int cnt;
        boolean visited;

        void insert(String word) {
            Trie curr = this;
            for(char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if(curr.child[idx] == null) {
                    curr.child[idx] = new Trie();
                }
                curr = curr.child[idx];
                curr.cnt++;
                //System.out.println("ch = " + ch + " idx = " + idx + " cnt =" + curr.cnt);
            }
        }

        int search(String word) {
            Trie curr = this;
            int count = 0;
            for(char ch : word.toCharArray()) {
                curr = curr.child[ch - 'a'];
                //System.out.println("ch = " + ch + " cnt =" + curr.cnt + " visited " + curr.visited);
                if(curr.visited == false) {
                    count += curr.cnt;
                    if(curr.cnt == 1) {
                        break;
                    }
                }
                if(curr == null) {
                    return 0;
                }
                curr.visited = true;
            }
            return count;
        }
    }

    public int solution(String[] words) {
        int answer = 0;
        Trie[] TrieRoot = new Trie[10000];

        for(String str : words) {
            int idx = str.charAt(0) - 'a';
            if(TrieRoot[idx] == null) {
                TrieRoot[idx] = new Trie();
            }

            TrieRoot[idx].insert(str);
        }

        for(String str : words) {
            int idx = str.charAt(0) - 'a';
            answer += TrieRoot[idx].search(str);
        }

        return answer;
    }
}
