public class WordDictionary {

    private class TrieNode 
    {
        TrieNode[] children = new TrieNode[26];
        boolean endOfWord = false;
    }
    private TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        constructTrie(word);
    }
    public void constructTrie( String word)
    {
        if(word == null||word.length() == 0)
            return;
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++)
        {
            if(cur.children[word.charAt(i) - 'a'] == null)
            {
                TrieNode child = new TrieNode();
                cur.children[word.charAt(i) - 'a'] = child;
                cur = child;
            }
            else
                cur = cur.children[word.charAt(i) - 'a'];
        }
        cur.endOfWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++)
        {
            if(word.charAt(i) == '.')
            {
                for(int j = 0; j < 26; j++)
                {
                    if(cur.children[j] != null)
                    {
                        
                        if(search(cur.children[j], word.substring(i+1)))
                            return true;
                    }
                }
                return false;
            }
            else if(cur.children[word.charAt(i) - 'a'] == null)
            {
                return false;
            }
            else
                cur = cur.children[word.charAt(i) - 'a'];
        }
        return cur.endOfWord;
    }
    public boolean search(TrieNode node, String word) {
        TrieNode cur = node;
        for(int i = 0; i < word.length(); i++)
        {
            if(word.charAt(i) == '.')
            {
                for(int j = 0; j < 26; j++)
                {
                    if(cur.children[j] != null)
                    {
                        
                        if(search(cur.children[j], word.substring(i+1)))
                            return true;
                    }
                }
                return false;

            }
            else if(cur.children[word.charAt(i) - 'a'] == null)
            {
                return false;
            }
            else
                cur = cur.children[word.charAt(i) - 'a'];
        }
        return cur.endOfWord;
    }

}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");