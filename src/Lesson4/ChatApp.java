package Lesson4;

import javax.swing.*;

public class ChatApp {
    private static ChatWindow chatWindow;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                chatWindow = new ChatWindow();
            }
        });
    }
}
