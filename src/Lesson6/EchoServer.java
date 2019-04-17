package Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {


    public static void main(String[] args) throws InterruptedException {

        try(Scanner scanner = new Scanner(System.in);
            ServerSocket serverSocket = new ServerSocket(7777)){

            System.out.println("Сервер ожидает подключения!");
            Socket socket = serverSocket.accept();
            System.out.println("Кто-то подключился");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Thread send = new Thread(new InOutMethods.SendRunnable(out, scanner));
            Thread receive = new Thread(new InOutMethods.ReceiveRunnable(in));

            send.start();
            receive.start();

            send.join();
            receive.join();

        }catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
