package DS;

import java.util.*;

public class AhoCorasick
{
    static class Node
    {
        Map<Character, Node> children = new HashMap<>();
        Node suffixLink;
        Node outputLink;
        int patternIdx = -1;
    }

    Node root = new Node();

    public void buildTrie(String[] words)
    {
        for(int i = 0; i < words.length; i++)
        {
            Node temp = root;
            String word = words[i];
            for(int j = 0; j < word.length(); j++)
            {
                //for each char -> insert into trie
                //if char is not present make a link
                char key = word.charAt(j);
                if(!temp.children.containsKey(key))
                {
                    Node newNode = new Node();
                    temp.children.put(key, newNode);
                }
                temp = temp.children.get(key);
            }
            temp.patternIdx = i;
        }
    }

    public boolean searchTrie(String word)
    {
        Node temp = root;
        for(int i = 0; i < word.length(); i++)
        {
            char key = word.charAt(i);
            if(!temp.children.containsKey(key))
                return false;
            temp = temp.children.get(key);
        }
        return temp.patternIdx > -1;
    }

    public void buildSuffixAndOutputLinks()
    {
        //suffixLink for root is itself
        root.suffixLink = root;

        //Build SuffixLinks & outputLinks
        Queue<Node> queue = new ArrayDeque<>();
        //suffixLinks for 1st level children is root
        for(char key : root.children.keySet())
        {
            queue.offer(root.children.get(key));
            root.children.get(key).suffixLink = root;
        }
        // Build suffixLinks & outputLinks for the rest of the children
        while(!queue.isEmpty())
        {
            Node parent = queue.poll();
            //for each of the child build suffixLink
            for(char childKey : parent.children.keySet())
            {
                Node child = parent.children.get(childKey);
                Node temp = parent.suffixLink;
                while(!temp.children.containsKey(childKey) && temp != root)
                    temp = temp.suffixLink;

                if(temp.children.containsKey(childKey))
                    child.suffixLink = temp.children.get(childKey);
                else
                    child.suffixLink = root;

                //NOTE: don't forget to add child to the queue
                queue.offer(child);
            }
            // for parent set up outputLink
            if(parent.suffixLink.patternIdx > -1)
                parent.outputLink = parent.suffixLink;
            else
                parent.outputLink = parent.suffixLink.outputLink;
        }

    }

    public List<List<Integer>> patternMatch(String text, String[] dictionary)
    {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < dictionary.length; i++)
        {
            result.add(i, new ArrayList<>());
        }
        Node parent = root;
        for(int i = 0; i < text.length(); i++)
        {
            char key = text.charAt(i);
            if(parent.children.containsKey(key))
            {
                parent = parent.children.get(key);
                if(parent.patternIdx > -1)
                    result.get(parent.patternIdx).add(i);

                Node myOutputLink = parent.outputLink;
                while(myOutputLink != null)
                {
                    result.get(myOutputLink.patternIdx).add(i);
                    myOutputLink = myOutputLink.outputLink;
                }
            }
            else
            {
                //go over suffix links to complete the result
                while(parent != root && !parent.children.containsKey(key))
                    parent = parent.suffixLink;
                if(parent.children.containsKey(key))
                    i--;
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        String[] words = {"ACC", "ATC", "CAT", "GCC", "C", "T"};
        AhoCorasick aha = new AhoCorasick();
        aha.buildTrie(words);
        aha.buildSuffixAndOutputLinks();
        List<List<Integer>> result = aha.patternMatch("GCATCG", words);
        for(int i = 0; i < words.length; i++)
        {
            if (result.get(i).isEmpty())
            {
                System.out.print(-1);
            }
            else
            {
                for(int endIndex : result.get(i))
                {
                    System.out.print((endIndex - words[i].length() + 1) + " ");
                }
            }
            System.out.println();
        }

    }
}
