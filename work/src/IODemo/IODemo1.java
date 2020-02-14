package IODemo;

import java.io.File;

public class IODemo1 {
    public static void main1(String[] args) {
        File parent = new File("课件们");
        System.out.println(parent.canRead());
        System.out.println(parent.canWrite());
        System.out.println(parent.canExecute());//可执行

        System.out.println(parent.exists());
        System.out.println(parent.isDirectory());//是文件夹
        System.out.println(parent.isFile());//是文件
        System.out.println(parent.isAbsolute());//是绝对路径
        System.out.println(parent.isHidden());//隐藏

        System.out.println(parent.getTotalSpace());
        System.out.println(parent.getFreeSpace());
        System.out.println(parent.getUsableSpace());

        System.out.println(parent.length());//大小
        System.out.println(parent.getName());//名字
        System.out.println(parent.lastModified());//上次修改时间

        System.out.println(parent.toPath());//路径
    }

    public static void main(String[] args) {

    }
}
