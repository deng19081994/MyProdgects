package com.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuHelper {
    private static String menuFormat = "%-15s%s ";

    private static JMenuItem addMenuItem(JMenu parent, String text, ActionListener actionListener) {
        JMenuItem menuItem = new JMenuItem(text);
        menuItem.setFont(new Font("Monospaced", Font.LAYOUT_RIGHT_TO_LEFT, 14));
        menuItem.addActionListener(actionListener);
        parent.add(menuItem);
        return menuItem;
    }

    static void initMainMenu(View view, JMenuBar menuBar) {
        JMenu mainMenu = new JMenu("Меню");
        menuBar.add(mainMenu);

        addMenuItem(mainMenu, String.format(menuFormat, "Новая игра", "R"), view);
        addMenuItem(mainMenu, String.format(menuFormat, "Сброс рекорда", "O"), view);
        mainMenu.addSeparator();
        addMenuItem(mainMenu, String.format(menuFormat, "Выход", "Esc"), view);
    }

    static void initMovingMenu(View view, JMenuBar menuBar) {
        JMenu moveMenu = new JMenu("Ход");
        menuBar.add(moveMenu);

        addMenuItem(moveMenu, String.format(menuFormat, "Вверх", "W"), view);
        addMenuItem(moveMenu, String.format(menuFormat, "Вниз", "S"), view);
        addMenuItem(moveMenu, String.format(menuFormat, "Вправо", "D"), view);
        addMenuItem(moveMenu, String.format(menuFormat, "Влево", "A"), view);
        moveMenu.addSeparator();
        addMenuItem(moveMenu, String.format(menuFormat, "Случайный ход", "E"), view);
        addMenuItem(moveMenu, String.format(menuFormat, "\"Умный\" ход", "Q"), view);
        moveMenu.addSeparator();
        addMenuItem(moveMenu, String.format(menuFormat, "Откат хода", "Z"), view);
    }

    static void initAboutProgram(View view, JMenuBar menuBar) {
        JMenu aboutProgramMenu = new JMenu("О программе");
        menuBar.add(aboutProgramMenu);
        addMenuItem(aboutProgramMenu, "О программе", view);
    }

    static String getMenuFormat() {
        return menuFormat;
    }
}
