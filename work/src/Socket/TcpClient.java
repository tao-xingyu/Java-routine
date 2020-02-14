package Socket;

import sun.plugin2.applet.Plugin2ClassLoader;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 2222);


        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        Scanner stdinScanner = new Scanner(System.in);
        while (true) {
            String message = stdinScanner.nextLine();
            byte[] sendBuffer = message.getBytes("UTF-8");
            os.write(sendBuffer);

        }
            //socket.close();
        }
    }

