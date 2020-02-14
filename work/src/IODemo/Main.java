package IODemo;


import java.io.File;

public class Main {
    private static void listDirectory(File root,int level) {
        File[] files = root.listFiles();
        if (files == null || files.length == 0) {
            return;
        }
        for (File file : files) {
            for (int i = 0; i < level * 4; i++) {
                System.out.print(" ");
            }

            System.out.println(file.getName());
            if(file.isDirectory()){
                System.out.println(File.separator);
            }else{
                System.out.print(file.length());
            }
            if (file.isDirectory()) {
                listDirectory(file, level + 1);
            }
        }
    }

    public static void main(String[] args) {
        File root = new File("C:\\Users\\taoxingyu\\Desktop\\课件们");
        System.out.println(root.getAbsolutePath());
        listDirectory(root,1);
    }
}
