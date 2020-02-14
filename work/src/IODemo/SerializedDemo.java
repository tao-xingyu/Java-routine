package IODemo;

import Work.Person;

import java.io.*;

public class SerializedDemo {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        {
            Person person1 = new Person("陈",34);
            Person person2 = new Person("高",18);
            OutputStream os = new FileOutputStream("Person对象.bin");
            ObjectOutputStream oos  = new ObjectOutputStream(os);
            oos.writeObject(person1);
            oos.writeObject(person2);
            oos.close();
        }

        {
            InputStream is = new FileInputStream("Person对象.bin");
            ObjectInputStream ois = new ObjectInputStream(is);
            Person p;
            p = (Person)ois.readObject();
            System.out.println(p);
            ois.close();
        }
    }
}
