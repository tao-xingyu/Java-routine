package Socket.TcpThread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static class Worker implements Runnable {
        private final Socket socket;

        Worker(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            try {
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                Scanner scanner = new Scanner(is, "UTF-8");
                PrintStream out = new PrintStream(os, false, "UTF-8");

                while (scanner.hasNextLine()) {
                    System.out.println(name + ":等待客户端发送消息");
                    String message = scanner.nextLine();
                    System.out.println(name + ":收到消息:" + message);
                    String echoMessage = message;
                    out.println(echoMessage);
                }
            } catch (UnsupportedEncodingException e) {
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException ex) {}
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        ExecutorService pool = Executors.newFixedThreadPool(100);
        int i = 0;
        while (true) {
            System.out.println("main:等待连接");
            Socket socket = serverSocket.accept();
            System.out.println("main:连接建立");
            pool.execute(new Worker(socket));
            //Thread thread = new Thread(new Worker(socket), "工作人员(" + i++ + ")");
            //thread.start();
        }
    }
}