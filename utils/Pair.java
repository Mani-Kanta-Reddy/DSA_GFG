package utils;
public class Pair<T, U> {
    private T o1;
    private U o2;
    public Pair(T o1, U o2) {
        this.o1 = o1;
        this.o2 = o2;
    }
    public T get1() {
        return o1;
    }
    public void set1(T o1) {
        this.o1 = o1;
    }
    public U get2() {
        return o2;
    }
    public void set2(U o2) {
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
        System.out.println(p1.get1());
        System.out.println(p1.get2());
        p1.set1(2);
        System.out.println(p1);
    }
}
