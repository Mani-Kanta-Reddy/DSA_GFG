class Oops {
    /*
    1.Encapsulation
    2.Inheritance
    3.Polymorphism
    4.Abstraction
    */
    public static void main(String[] args) {
        Student mani = new Student();
        mani.setAge(23);
        mani.setName("mani");
        System.out.println(mani);
        Student ashok = new Student(24, "ashok");
        System.out.println(ashok);
    }

}
class Student { 
    /*
    Encapsulation: make properties private and write setter/getters to expose
    */
    private int age;
    private String name;

    Student() {}

    Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return this.age + " " + this.name;
    }
}
