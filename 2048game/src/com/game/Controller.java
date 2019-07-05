package com.game;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {
    private Model model;
    private View view;
    private GameFieldView gameFieldView;
    private boolean havePossibleMoves;

    Controller(Model model) {
        this.model = model;
        havePossibleMoves = model.canMove();
        this.gameFieldView = new GameFieldView(this);
    }

    void resetGame() {
        int answer = JOptionPane.showConfirmDialog(gameFieldView, "Начать новую игру?",
                "Новая игра", JOptionPane.YES_NO_OPTION);
        if (answer == 0) {
            model.resetGameTiles();
            havePossibleMoves = model.canMove();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
            exit();

        if (e.getKeyCode() == KeyEvent.VK_R)
            resetGame();

        if (e.getKeyCode() == KeyEvent.VK_O || e.getKeyCode() == KeyEvent.VK_0
                                            || e.getKeyCode() == KeyEvent.VK_NUMPAD0) {
            refreshRecord();
        }

        if ( ! model.canMove() )
            havePossibleMoves = false;

        if (havePossibleMoves) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A
                                                   || e.getKeyCode() == KeyEvent.VK_NUMPAD4) {
                moveLeft();

            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D
                                                           || e.getKeyCode() == KeyEvent.VK_NUMPAD6) {
                moveRight();

            } else if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W
                                                        || e.getKeyCode() == KeyEvent.VK_NUMPAD8) {
                moveUp();

            } else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S
                                                          || e.getKeyCode() == KeyEvent.VK_NUMPAD2) {
                moveDown();

            } else if (e.getKeyCode() == KeyEvent.VK_Z) {
                rollback();

            } else if (e.getKeyCode() == KeyEvent.VK_E  || e.getKeyCode() == KeyEvent.VK_NUMPAD9) {
                randomMove();

            } else if (e.getKeyCode() == KeyEvent.VK_Q || e.getKeyCode() == KeyEvent.VK_NUMPAD7) {
                autoMove();

            }
        } else if (e.getKeyCode() == KeyEvent.VK_Z) {
            rollback();
        }

        gameFieldView.repaint();
    }

    private void refreshRecord() {
        view.resetRecord();
    }

    void moveLeft() {
        model.left();
    }

    void moveRight() {
        model.right();
    }

    void moveUp() {
        model.up();
    }

    void moveDown() {
        model.down();
    }

    void rollback() {
        havePossibleMoves = true;
        model.subtractTurnBackCount();
        model.rollback();
    }

    void autoMove() {
        model.autoMove();
    }

    void randomMove() {
        model.randomMove();
    }

    void exit() {
        Object[] options = {"Ага", "Не-а"};

        int answer = JOptionPane.showOptionDialog(gameFieldView, "Желаете покинуть игру?",
                "Выход", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (answer == 0) {
            Main.writeRecord();
            System.exit(0);
        }
    }

    Tile[][] getGameTiles() {
        return model.getGameTiles();
    }

    int getTurnBackCount() {
        return model.turnBackCount;
    }

    int getScore() {
        return model.score;
    }

    int getRecord() {
        return  model.record;
    }

    Model getModel() {
        return model;
    }

    GameFieldView getGameFieldView() {
        return gameFieldView;
    }

    void setView(View view) {
        this.view = view;
    }
}
