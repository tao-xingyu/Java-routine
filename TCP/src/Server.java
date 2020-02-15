import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(2222);
        System.out.println("LISTENING");
        in.nextLine();
        System.out.println("等待客户连接");
        Socket socket =serverSocket.accept();
        System.out.println("ESTABLISHED");
        System.out.println("等待着客户端先调用close()");
        System.out.println("CLOSE_WAIT");
        in.nextLine();
        socket.close();//关闭连接
        System.out.println("真正关闭");

    }
}
