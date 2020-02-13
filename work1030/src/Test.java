class Animal {
    public String name;
    public int age;

    /* public Animal() {

     }*/
    static {
        System.out.println("Animal::static{}");
    }
    {
        System.out.println("Animal::instance{}");
    }

    public Animal(String name, int age) {
        eat();
        this.name = name;
        this.age = age;
        System.out.println("Animal(String,int)");
    }

    public void eat() {
        System.out.println("Animal::eat()");
    }
}

class Cat extends Animal {
    public String sex;
    static {
        System.out.println("Cat::static{}");
    }
    {
        System.out.println("Cat::instance{}");
    }
    public Cat(String name, int age,String sex) {
        super(name, age);
        this.sex = sex;
        System.out.println("Cat(String,int,String)");
    }
    public void eat() {

        System.out.println("Cat::eat()");
    }
}

public class Test {
    public static void main(String[] args) {
        Animal animal = new Cat("caocoa",19,"man");
        animal.eat();
    }
}