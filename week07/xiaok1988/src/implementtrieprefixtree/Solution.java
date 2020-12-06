package implementtrieprefixtree;

class TrieNode {
    private TrieNode[] nodes;
    private int N = 26;
    private boolean isEnd = false;
    public TrieNode () {
        this.nodes = new TrieNode[N];
    }

    public boolean containsKey(char ch) {
        return this.nodes[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return this.nodes[ch - 'a'];
    }

    public void put(TrieNode trieNode, char ch) {
        this.nodes[ch - 'a'] = trieNode;
    }

    public void setEnd() {
        this.isEnd = true;
    }

    public boolean isEnd() {
        return this.isEnd;
    }
}



class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            if (!node.containsKey(current)) {
                node.put(new TrieNode(), current);
            }
            node = node.get(current);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            if (!node.containsKey(current)) {
                return false;
            }
            node = node.get(current);
        }
        if (node.isEnd()) {
            return true;
        } else {
            return false;
        }
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char current = prefix.charAt(i);
            if (!node.containsKey(current)) {
                return false;
            }
            node = node.get(current);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */


