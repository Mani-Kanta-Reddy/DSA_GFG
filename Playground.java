public class Playground {
    public static void main(String[] args) {
        int res = 1 ^ 4;
        int count = 0;
        while(res > 0) {
            if(res % 2 != 0)
                count++;
            res /= 2;
        }
        System.out.println(count);
    }
}
