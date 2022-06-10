package basic;
public class PostfixAndPrefixOps {
    public static void main(String[] args) {
        int counter = 0;
        // counter = counter + 1;
        //scenario counter++:
        // counter + 1;
        // counter = counter;

        //scenario ++counter:
        // counter = counter + 1;

        System.out.println(++counter); //pre-increment = ++counter | pre-decrement = --counter
        // System.out.println(counter);
        System.out.println(counter++); //post-increment = counter++ | post-decrement = counter--
        System.out.println(counter);
    }
}
