package Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

class InOutMethods {

    //Метод получения сообщений
    private static void receive(DataInputStream in){
        while (true){
            try{
                System.out.println("Новое сообщение > " + in.readUTF());
            } catch (IOException ex){
                ex.printStackTrace();
                break;
            }
        }
    }

    // Метод отправки сообщений
    private static void send (DataOutputStream out, Scanner scanner) {

        while (true) {
            System.out.println("Введите сообщение > ");
            while (scanner.hasNextLine()) {
                System.out.println("Введите сообщение > ");
                String line = scanner.nextLine();
                try {
                    out.writeUTF(line);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }
    }

    //Поток для получения сообщений
    static class ReceiveRunnable implements Runnable{
        private DataInputStream in ;

        ReceiveRunnable(DataInputStream in){
            this.in = in;
        }

        @Override
        public void run() {
            receive(in);
        }
    }

    //Поток для отправки сообщений
    static class SendRunnable implements Runnable{
        private DataOutputStream out;
        private Scanner scanner;

        SendRunnable(DataOutputStream out, Scanner scanner){
            this.out = out;
            this.scanner = scanner;
        }
        @Override
        public void run() {
            send(out, scanner);
        }
    }
}
