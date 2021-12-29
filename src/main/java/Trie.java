import java.util.HashMap;
import java.util.Map;

class TrieNode{
    private Map<Character, TrieNode> childNodes = new HashMap<>();
    private boolean isLastChar;

    Map<Character, TrieNode> getChildNodes() {
        return this.childNodes;
    }

    boolean isLastChar() {
        return this.isLastChar;
    }

    void setIsLastChar(boolean isLastChar) {
        this.isLastChar = isLastChar;
    }
}


class Trie1 {

    private TrieNode root;

    Trie1() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode thisNode = this.root;

        for(int i = 0; i < word.length(); i++) {
            thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        thisNode.setIsLastChar(true);
    }

    boolean contains(String word) {
        TrieNode thisNode = this.root;

        for(int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            TrieNode node = thisNode.getChildNodes().get(character);

            if(node == null) {
                return false;
            }
            thisNode = node;
        }
        return thisNode.isLastChar();
    }

    void delete(String word) {
        delete(this.root, word, 0);
    }

    private void delete(TrieNode thisNode, String word, int index) {
        char character = word.charAt(index);

        if(!thisNode.getChildNodes().containsKey(character)) {
            throw new Error("There is no " + word);
        }

        TrieNode childNode = thisNode.getChildNodes().get(character);
        index++;

        if (index == word.length()) {
            if (!childNode.isLastChar()) throw new Error("There is no [" + word + "] in this Trie.");

            childNode.setIsLastChar(false);

            if(childNode.getChildNodes().isEmpty()) {
                thisNode.getChildNodes().remove(character);
            }
        } else {
            delete(childNode, word, index);

            if(!childNode.isLastChar() && childNode.getChildNodes().isEmpty()) {
                thisNode.getChildNodes().remove(character);
            }
        }
    }

    public static void main(String[] args) {

        Trie1 trie = new Trie1();

        trie.insert("PI");
        trie.insert("PIE");
        trie.insert("POW");
        trie.insert("POP");
    }
}