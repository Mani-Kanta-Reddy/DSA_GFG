package recursion;

public class TowerOfHanoi1 {
    static void toh(int n, String source, String dest, String temp) {
        //base-case:
        if(n == 0) {
            return;
        }

        //recursive -case:
        toh(n - 1, source, temp, dest);
        System.out.println("Move " + n + source + dest);
        toh(n - 1, temp, dest, source);
    }
    public static void main(String[] args) {
        toh(3, "A", "B", "C");
    }
}
