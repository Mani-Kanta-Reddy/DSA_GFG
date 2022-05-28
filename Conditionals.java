public class Conditionals {
    public static void main(String[] args) {
        //Conditonals
        /*
        1. if-else ladder
        2. switch

        Logical operators (binary operators):
        &&, || 
        boolean AND (&&)
        true && true => true
        true && false => false
        false && true => false
        false && false => false

        boolean OR (||)
        true || true => true
        true || false => true
        false || true => true
        false || false => false
        */
        
        //simple if-else:
        int temperature = 10;
        //takes condition which has comparision oprs' (>, <, >=, <=, !=, ==)
        if(temperature < 10) { 
            System.out.println("temperature is lessthan 10");
        } else if(temperature > 10 && temperature < 20) {
            System.out.println("temparature is > 10 but < 20");
        } else if(temperature > 20 && temperature < 30){
            System.out.println("temperature > 20");
        } else if(temperature > 30 && temperature < 40){
            
        } else {

        }
        System.out.println("xxxx");

        int option = 2;
        //switch:
        switch(option) {
            case 1:
                System.out.println("line 43");



            break;
            case 2:
            System.out.println("line 49");


            break;

            default:
            System.out.println("line 55");

        }
        System.out.println("line 58");
    }
}
