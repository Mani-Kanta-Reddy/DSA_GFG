package misc;

import java.util.ArrayList;
import java.util.List;

public class DeleteColumnsToMakeSorted
{
    public static void main(String[] args)
    {
        String[] strs = {"abc", "bce", "cae"};
        System.out.println(minDeletionSize(strs));
    }
    public static int minDeletionSize(String[] strs) {
        //point and shoot approach
        int res = 0;
        int n = strs.length;
        for(int i = 0; i < strs[0].length(); i++) {
            //loop over and extract `i`th char from each str
            List<Character> chars = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                chars.add(strs[j].charAt(i));
            }
            //iterate over `chars` and check whether all are in lexicographic order
            if(chars.size() == 1) {
                res++;
            } else {
                boolean isLexicographic = true;
                for(int k = 1; k < chars.size(); k++) {
                    if(chars.get(k - 1).compareTo(chars.get(k)) > 0) {
                        isLexicographic = false;
                        break;
                    }
                }
                if(isLexicographic)
                    res++;
            }
        }
        return strs[0].length() - res;
    }
}
