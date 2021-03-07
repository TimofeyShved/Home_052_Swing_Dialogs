package com.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileFilter;

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

        //----------------------------------------------------------- JFileChooser выборка -------------------------------------------------------------------

        JButton jButtonFile = new JButton("Выберете файл");
        jPanel.add(jButtonFile);
        // добавляем действие на кнопку
        jButtonFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser(); // создаем клас для выборки файла
                jFileChooser.setCurrentDirectory(new File(".")); // путь папки
                jFileChooser.setSelectedFile(new File(".")); // выбранный файл
                jFileChooser.setMultiSelectionEnabled(true); // возможность выбрать несколько
                // выбор может отображать файлы и папки
                jFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                // есть заготовки jFCh.showOpenDialog(jFrame); или jFCh.showSaveDialog(jFrame);

                // Фильтр для нашего окна
                /*
                FileFilter fileFilter = new FileFilter()
                {
                    @Override
                    public boolean accept(File pathname) {
                        if (pathname.getName().endsWith("gif")){
                            return true;
                        }
                        else {
                            return false;
                        }
                    }

                    @Override
                    public String toString() {
                        return super.toString()+"Only gif";
                    }
                };
                //jFileChooser.setFileFilter(fileFilter);
                */

                //добавляем на наше окно, текстовое поле
                JTextField jTextField = new JTextField("text", 50);
                jFileChooser.add(jTextField, BorderLayout.SOUTH);

                // действие при выборе элемента, папки файла
                jFileChooser.addPropertyChangeListener(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        jTextField.setText(evt.getSource().toString()); // выводит значения элемента в текстовое поле
                    }
                });

                int i = jFileChooser.showDialog(jPanel, "Save");
                System.out.println(i);                      // 0 - да / 1 - нет / выбран ли файл?

                File file = jFileChooser.getSelectedFile(); // вытаскиваем файл из выборки
                System.out.println(file.getName());
            }
        });

        //----------------------------------------------------------- ColorDialog Цвет -------------------------------------------------------------------

        JButton jButtonColor = new JButton("Цвет формы");
        jPanel.add(jButtonColor);
        // добавляем действие на кнопку
        jButtonColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(jPanel, "заголовок", Color.WHITE);
                jPanel.setBackground(color);
            }
        });
    }

    //----Custom dialog
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
