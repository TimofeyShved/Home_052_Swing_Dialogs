package com.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    static JFrame jFrame = getFrame(); // наша форма
    static JPanel jPanel = new JPanel(); // наша панель

    public static void main(String[] args) {
        // создаём панель с кнопкой, для вызова сообщений
	    jFrame.add(jPanel);

	    JButton jButton = new JButton("Ошибка");
	    jPanel.add(jButton);
	    // добавляем действие на кнопку
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jPanel, "Сообщение об ошибке №-", "заголовок", JOptionPane.ERROR_MESSAGE); // сообщение об ошибке
            }
        });

        JButton jButton2 = new JButton("Да или нет");
        jPanel.add(jButton2);
        // добавляем действие на кнопку
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(JOptionPane.showConfirmDialog(jPanel, "Сделать выбор, да или нет?", "заголовок", JOptionPane.OK_CANCEL_OPTION)); // 0 - нет / 2 - да
            }
        });

        JButton jButton3 = new JButton("Множественный выбор");
        jPanel.add(jButton3);
        // добавляем действие на кнопку
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(JOptionPane.showOptionDialog(jPanel, "выберете число:", "заголовок", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"1","2","3","4"
                }, "2"));// 0 - нет / 2 - да
            }
        });

        JButton jButton4 = new JButton("Ввод данных");
        jPanel.add(jButton4);
        // добавляем действие на кнопку
        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(JOptionPane.showInputDialog(jPanel, "Введите слово"));
            }
        });

        jPanel.revalidate();

        //----------------------------------------------------------- Custom dialog -------------------------------------------------------------------

        JButton jButtonCustom = new JButton("Custom");
        jPanel.add(jButtonCustom);
        // добавляем действие на кнопку
        jButtonCustom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyDialog myDialog = new MyDialog(); // создаем наш класс для диалога
                myDialog.setVisible(true); // отображаем его
            }
        });

    }

    static class MyDialog extends JDialog{ // наш класс для общения
        public MyDialog(){
            super(jFrame, "заголовок", true); // передаем настройки
            add(new JTextField(), BorderLayout.NORTH); // добавляем элементы
            add(new JButton("click"), BorderLayout.SOUTH);
            setBounds(850, 400, 200, 100); // и размер
        }
    }

    static JFrame getFrame(){
        JFrame jFrame = new JFrame(); // создается форма
        jFrame.setVisible(true); // влючаем видимость
        jFrame.setBounds(750,250,450,200); // размеры
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // выход
        return jFrame;
    }
}
