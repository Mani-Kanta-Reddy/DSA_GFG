package strings;

public class PowerSet {
    public static void main(String[] args) {
        String str = "man";
        printAllSubsets(str, "", 0);
    }
    static void printAllSubsets(String str, String temp, int i) {
        if(i == str.length()) {
            System.out.println(temp);
            return;
        } else {
            printAllSubsets(str, temp, i + 1);
            printAllSubsets(str, temp+str.charAt(i), i + 1);
        }
    }
}
