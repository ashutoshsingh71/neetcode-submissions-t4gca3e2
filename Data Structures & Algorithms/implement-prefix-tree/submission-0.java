class TrieNode{
    TrieNode [] chars;
    boolean isEndOfWord; 

    TrieNode(){
        this.chars = new TrieNode [26];
    }
}

class PrefixTree {
    TrieNode root;
    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(curr.chars[index] == null){
                curr.chars[index] = new TrieNode();
            }
            curr = curr.chars[index];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = getNode(word);
        return node != null && node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = getNode(prefix);
        return node != null;
    }

    private TrieNode getNode(String word){
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(curr.chars[index] == null) return null;
            curr = curr.chars[index];
        }
        return curr;
    }
}
