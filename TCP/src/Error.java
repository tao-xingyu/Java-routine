import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Error {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(2222);
        while (true) {
            Socket socket = ss.accept();
            // 读
            // 写
        }
    }
}

