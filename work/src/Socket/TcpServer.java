package Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpServer {
    public static void main(String[] args) throws IOException {
        //监听
        ServerSocket serverSocket = new ServerSocket(2222);
        while(true){
            //通信
            System.out.println("等待client发送消息:");
            Socket socket = serverSocket.accept();
            System.out.println("有client连接上来");

            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(
                    new OutputStreamWriter(os,"UTF-8"),
                    false
            );

            Scanner scanner = new Scanner(is,"GBK");
            while(scanner.hasNext()){
                String message = scanner.nextLine();
                System.out.println("收到对方的消息:"+message);
                String responseMessage = message;
                System.out.println("发送给对方的消息:"+responseMessage);
                printWriter.println(responseMessage);
                printWriter.flush();
            }
            socket.close();
        }
    }
}
