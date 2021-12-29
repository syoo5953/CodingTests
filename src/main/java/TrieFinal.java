public class TrieFinal {
    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
        int[] answer = solution7.solution(words, queries);
        for (int num : answer) {
            System.out.println(num);
        }
    }
}

class Solution7 {

    class Trie {
        Trie[] child = new Trie[26];
        int count;

        void insert(String str) {
            Trie curr = this;
            for(char ch : str.toCharArray()) {
                curr.count++;
                int idx = ch - 'a';
                if(curr.child[idx] == null) {
                    curr.child[idx] = new Trie();
                }

                curr = curr.child[idx];
            }
            curr.count++;
        }

        int search(String str) {
            Trie curr = this;
            for(char ch : str.toCharArray()) {
                if(ch == '?') {
                    System.out.println("test = " + curr.count);
                    return curr.count;
                }

                curr = curr.child[ch - 'a'];
                if(curr == null) {
                    return 0;
                }
            }
            return curr.count;
        }
    }


    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        int ansIdx = 0;
        Trie[] TrieRoot = new Trie[10000];
        Trie[] ReTrieRoot = new Trie[10000];

        for(String str : words) {
            int idx = str.length() - 1;
            if(TrieRoot[idx] == null) {
                TrieRoot[idx] = new Trie();
                ReTrieRoot[idx] = new Trie();
            }

            TrieRoot[idx].insert(str);
            ReTrieRoot[idx].insert(new StringBuilder(str).reverse().toString());
        }

        for(String str : queries) {
            int idx = str.length() - 1;
            if(TrieRoot[idx] == null) {
                answer[ansIdx++] = 0;
                continue;
            }

            if(str.charAt(0) != '?') {
                answer[ansIdx++] = TrieRoot[idx].search(str);
            } else {
                answer[ansIdx++] = ReTrieRoot[idx].search(new StringBuilder(str).reverse().toString());
            }
        }
        return answer;
    }
}