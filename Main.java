import java.util.Arrays;
import java.util.Collections;

import static java.lang.System.out;

 public class Main {
     public static void main(String[] args)
     {
         out.println("Hello There!");
         Integer[] arr = { 1, 9, 2, 4};
         Collections.sort(Arrays.asList(arr));
         out.println(Arrays.toString(arr));
     }
 }