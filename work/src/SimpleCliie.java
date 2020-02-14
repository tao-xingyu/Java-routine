import java.io.IOException;
import java.net.Socket;

public class SimpleCliie {
    public static void main(String[] args) throws IOException {
        StringBuilder rsquest = new StringBuilder();
        rsquest.append("GET / HTTP/1.0\r\n");
        rsquest.append("Host: www.baidu.com\r\n");
        rsquest.append("\r\n");
        System.out.println(rsquest.toString());

        Socket socket = new Socket("www.baidu.com", 80);
        socket.getOutputStream().write(rsquest.toString().getBytes("UTF-8"));
        socket.getOutputStream().flush();
        socket.shutdownOutput();

        byte[] buffer = new byte[4096];
        int len = socket.getInputStream().read(buffer);
        socket.close();
        String response = new String(buffer, 0, len, "UTF-8");
        System.out.println(response);
    }
}



