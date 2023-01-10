package utils;
public class Pair<T, U> {
    private T o1;
    private U o2;
    public Pair(T o1, U o2) {
        this.o1 = o1;
        this.o2 = o2;
    }
    public T first() {
        return o1;
    }
    public void first(T o1) {
        this.o1 = o1;
    }
    public U second() {
        return o2;
    }
    public void second(U o2) {
        this.o2 = o2;
    }
    @Override
    public String toString() {
        return "(" + o1.toString() + ","+ o2.toString() + ")";
    }
}

class Demo {
    public static void main(String[] args) {
        Pair<Integer, Character> p1 = new Pair<>(1, 'c');
        System.out.println(p1.first());
        System.out.println(p1.second());
        p1.first(2);
        System.out.println(p1);
    }
}
