import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Socket socket = new Socket("127.0.0.1", 2222);
        System.out.println("ESTABLISHED");
        scanner.nextLine();
        System.out.println("关闭连接，发送 FIN");
        socket.close();
    }
}