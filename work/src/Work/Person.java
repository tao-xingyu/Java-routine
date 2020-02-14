package Work;

public class Person {
    private String name;
    private int age;

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    public void eat(){
        System.out.println(this.name+"吃饭");
    }
    public void sleep(){
        System.out.println(this.name+"睡觉");
    }
    public void show(){
        System.out.println("name:"+ this.name+"age:"+this.age);
    }
}
