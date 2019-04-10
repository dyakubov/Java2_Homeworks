package Lesson4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ChatWindow extends JFrame {

    public ChatWindow() throws HeadlessException {
        setTitle("Online chat by Dmitry Yakubov");
        setBounds(50,50,640,480);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Большое текстовое поле для отображения переписки в центре окна
        JTextArea textArea = new JTextArea();
        add(textArea, BorderLayout.CENTER);

        //Однострочное текстовое поле для ввода сообщений
        JTextField field = new JTextField();
        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(textArea, field);
            }
        });

        //Кнопка для отсылки сообщений
        JButton sendButton = new JButton("Отправить");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(textArea, field);
            }
        });


        //Панель с однострочным тестовым полем и кнопкой "отправить"
        JPanel commPanel = new JPanel();
        commPanel.setLayout(new BorderLayout());
        commPanel.add(field);
        commPanel.add(sendButton, BorderLayout.EAST);
        add(commPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    //Метод отправки сообщения
    private void sendMessage(JTextArea textArea, JTextField field){
        if(!field.getText().equals("")) { //Проверяем, что не отправляем пустую строку
            textArea.setText(textArea.getText() + "\n" + field.getText()); //Получаем содержимое переписки и добавляем к нему новое сообщение
            field.setText(""); //Очищаем содержимое тестовой строки
        }
    }
}
