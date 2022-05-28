public class Loops {
    public static void main(String[] args) {
        /*
        1. for
        2. while
        3. do-while
        */
        //Print 1..10
        int counter = 1;
        while(counter < 11) {
            System.out.println(counter++);
        }

        int k = 0;
        do {
            System.out.println(k);
            k++;
        } while(k < 10);

        // for-loops | increment -> use '<' & decrement -> use '>'
        int i = 0;
        for(i = 0; i < 10; i++) { //initialisation ; codition-check; increment/decrement
            System.out.println(i); //condition-check | execution | increment/decrement
        }
        int j = 10;
        for(j = 10; j > 0; j--) { //-2^32 
            System.out.println(j);
        }
    }
}
