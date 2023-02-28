package DS;

public class Trie
{
    Node root = new Node();
    static class Node {
        Node[] children = new Node[26];
        boolean endOfWord;
    }
    //insert
    public void insert(String word) {
        Node temp = root;
        //go over each character from the word and insert to the trie
        for(int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            int idx = curr - 'a';
            //check if curr is already available
            if(temp.children[idx] == null) {
                temp.children[idx] = new Node();
            }
            temp = temp.children[idx];
            //check if currChar is last then mark EOW
            if(i == word.length() - 1) {
                temp.endOfWord = true;
            }
        }
    }
    //search
    public boolean search(String word) {
        //go over one by one char in trie hierarchy and search
        Node temp = root;
        for(int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            int idx = curr - 'a';
            if(temp.children[idx] == null) {
                return false;
            }
            temp = temp.children[idx];
            if(i == word.length() - 1 && temp.endOfWord) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] words = {"i", "like", "sam", "samsung", "mobile", "ice"};
        String key = "ilikesamsung";
        for(String word : words) {
            trie.insert(word);
        }
        // System.out.println(trie.search("s"));
        System.out.println(wordBreak(trie, words, key));
    }

    public static boolean wordBreak(Trie trie, String[] words, String key)
    {
        int n = key.length();
        //base-case:
        if(n == 0) return true;

        //recursive-case:
        for(int i = 1; i <= n; i++) {
            String left = key.substring(0, i);
            String right = key.substring(i);

            if(trie.search(left) && wordBreak(trie, words, right)) return true;
        }
        return false;
    }
}
