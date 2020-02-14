package IODemo;

import java.io.*;

public class 输出到文件中 {
    public static void main(String[] args) throws IOException {
        {
            OutputStream os = new FileOutputStream("本地输出文件.txt");
            Writer writer = new OutputStreamWriter(os,"UTF-8");
            writer.write('c');
            writer.write("中国人");
            char[] buffer = {'我','爱','我','的','祖','国'};
            writer.write(buffer,0,buffer.length);
            writer.append("\r\n我爱北京天安门");

            writer.flush();//刷新
            writer.close();
        }
        {
            //OutputStream os = new FileOutputStream("本地输出文件.txt");
            //PrintStream out = new PrintStream(os,false,"UTF-8");
            PrintStream out = new PrintStream("本地输出文件.txt");
            out.println("我是中国人");
            out.println("我也是第二行");
            out.println("为中华崛起而读书");
            out.flush();
            out.close();
        }
    }
}
