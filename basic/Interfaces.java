package basic;

public class Interfaces {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.speak();
        obj.eat();
        // obj.sleep(); can't be called like this you've to call only as below
        MyInterface.sleep();        

    }
}
interface MyInterface {
    public abstract void speak();
    default void eat() {System.out.println("curnch... crunch...");}
    public static void sleep() {System.out.println("zzzzz.....");}
    private void code() {System.out.println("coding....");}
}

class MyClass implements MyInterface {
    public void speak() {System.out.println("hello...");}
    @Override
    public void eat() {System.out.println("munch... munch...");}
}
