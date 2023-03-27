package basic;

public class WrappersReuse {
    public static void main(String[] args) {
        System.out.println(isEqual(200, 300));  //Expect `false` since we're using ==
        System.out.println(isEqual(200, 200));  //Expect `false` since we're using ==
        System.out.println(isEqual(10, 10));    //Expect `false` sinec we're usng ==, but this returns `false` b/c Java reuses wrapper types for
        /*
         * 1. All Boolean values (true and false)
         * 2. All Byte values
         * 3. All Character values form -128 to 127
         * 4. All Short and Integer values from -128 to 127
         * so == will always returns true when their primitive values are same and belongs to the above list of values
         */
    }

    public static boolean isEqual(Integer a, Integer b) {
        return a == b;
    }
}
