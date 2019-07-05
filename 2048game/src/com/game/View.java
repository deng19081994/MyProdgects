package com.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class View extends JFrame implements ActionListener {
    private Controller controller;
    private GameFieldView gameFieldView;

    View(Controller controller) {
        this.controller = controller;
        this.gameFieldView = controller.getGameFieldView();
        init();
    }

    private void init() {
        setTitle("2048");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(460,620);
        setResizable(false);
        add(gameFieldView);
        setLocationRelativeTo(null);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Main.writeRecord();
                super.windowClosing(e);
            }
        });

        initMenuBar();
        setVisible(true);
    }

    public void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        //проверить на других системах с этой строкой
//        menuBar.setBackground(new Color(0xbbada0, true));
        MenuHelper.initMainMenu(this, menuBar);
        MenuHelper.initMovingMenu(this, menuBar);
        MenuHelper.initAboutProgram(this, menuBar);

        getContentPane().add(menuBar, BorderLayout.NORTH);
//      или так
//        this.setJMenuBar(menuBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
        String menuFormat = MenuHelper.getMenuFormat();

        if (event.equals(String.format(menuFormat, "Вверх", "W"))) {
            controller.moveUp();
            gameFieldView.repaint();
            return;
        }

        if (event.equals(String.format(menuFormat, "Вниз", "S"))) {
            controller.moveDown();
            gameFieldView.repaint();
            return;
        }

        if (event.equals(String.format(menuFormat, "Влево", "A"))) {
            controller.moveLeft();
            gameFieldView.repaint();
            return;
        }

        if (event.equals(String.format(menuFormat, "Вправо", "D"))) {
            controller.moveRight();
            gameFieldView.repaint();
            return;
        }

        if (event.equals(String.format(menuFormat, "Откат хода", "Z"))) {
            controller.rollback();
            gameFieldView.repaint();
            return;
        }

        if (event.equals(String.format(menuFormat, "\"Умный\" ход", "Q"))) {
            controller.autoMove();
            gameFieldView.repaint();
            return;
        }

        if (event.equals(String.format(menuFormat, "Случайный ход", "E"))) {
            controller.randomMove();
            gameFieldView.repaint();
            return;
        }

        if (event.equals(String.format(menuFormat, "Новая игра", "R"))) {
            controller.resetGame();
            gameFieldView.repaint();
            return;
        }

        if (event.equals(String.format(menuFormat, "Сброс рекорда", "O"))) {
            resetRecord();
            gameFieldView.repaint();
            return;
        }

        if (event.equals(String.format(menuFormat, "Выход", "Esc"))) {
            controller.exit();
            return;
        }

        if (event.equals("О программе")) {
            showAbout();
            gameFieldView.repaint();
            return;
        }
    }

    void resetRecord() {
        int answer = JOptionPane.showConfirmDialog(gameFieldView, "Желаете обнулить рекорд?",
                                                   "Сброс рекорда", JOptionPane.YES_NO_OPTION);
        if (answer == 0) {
            controller.getModel().record = 0;
            Main.writeRecord();
        }
    }

    private void showAbout() {
        JOptionPane.showMessageDialog(this,
                "Написанна криворуким военным в июле 2019\nдля боевых гномов 3-го экипажа Бороды и Коня.\n\nVersion 0.9",
                "О программе",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
