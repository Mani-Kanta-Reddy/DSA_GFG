package recursion;

public class PowerLinear {
    static int powerLinear(int x, int n) {
        //base-case
        if(n == 1) 
            return x;
        //recursive -case
        int currProduct = powerLinear(x, n - 1) * x;
        return currProduct;
    }
    public static void main(String[] args) {
        powerLinear(2, 3);
    }
}
