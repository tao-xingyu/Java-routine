package IODemo;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class 内存中的源 {
    public static void main(String[] args) throws IOException {
        byte[] source = "中 国 人民 站起来 了".getBytes("UTF-8");
        InputStream is = new ByteArrayInputStream(source);

        Scanner scanner = new Scanner(is,"UTF-8");
        while(scanner.hasNext()){
            System.out.println(scanner.next());
        }
    scanner.close();
    }
}
