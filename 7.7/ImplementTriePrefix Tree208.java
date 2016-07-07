class TrieNode {
    TrieNode[] children;
    boolean endOfWord;
    // Initialize your data structure here.
    public TrieNode() {
        children = new TrieNode[26];
        endOfWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    private TrieNode curr;
    // Inserts a word into the trie.
    public void insert(String word) {
        curr = root;
        for(int i = 0; i < word.length(); i++)
        {
            if(curr.children[word.charAt(i) - 'a'] == null)
            {
                TrieNode child = new TrieNode();
                curr.children[word.charAt(i) - 'a'] = child;
                curr = child;
            }
            else 
                curr = curr.children[word.charAt(i) - 'a'];
        }
        curr.endOfWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if(startsWith(word))
        {
            return curr.endOfWord;
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        curr = root;
        for(int i = 0 ; i < prefix.length(); i++)
        {
            if(curr.children[prefix.charAt(i) - 'a'] == null)
                return false;
            curr = curr.children[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");