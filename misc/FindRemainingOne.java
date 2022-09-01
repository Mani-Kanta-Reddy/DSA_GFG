package misc;

public class FindRemainingOne
{
    public static void main(String[] args)
    {
        char[] arr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'};
        int idxToMark = 0;
        while(!isEnd(arr)) {
            int counter = 0;
            while(counter < 3) {
                if(idxToMark < 11 && arr[idxToMark] != '?' ) {
                    counter++;
                } else {
                    //idxToMark is >= 11
                    int idxToUpdate = idxToMark % 11;
                    if(counter == 3 && arr[idxToUpdate] != '?') {
                        arr[idxToUpdate] = '?';
                    } else if(arr[idxToUpdate] != '?'){
                        counter++;
                    }
                }
                idxToMark++;
            }
            if(counter == 3 && idxToMark < 11) {
                arr[idxToMark] = '?';
            } else {
                int idxToUpdate = idxToMark % 11;
                arr[idxToUpdate] = '?';
            }
            idxToMark++;
        }
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] != '?')
            {
                System.out.println(arr[i]);
            }
        }
    }
    private static boolean isEnd(char[] arr) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == '?') {
                count++;
            }
        }
        return count == arr.length - 1 ? true : false;
    }
}
