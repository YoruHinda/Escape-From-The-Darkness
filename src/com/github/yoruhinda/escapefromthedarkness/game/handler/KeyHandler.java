package com.github.yoruhinda.escapefromthedarkness.game.handler;

import com.github.yoruhinda.escapefromthedarkness.entity.Player;
import com.github.yoruhinda.escapefromthedarkness.game.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private Game game;

    public KeyHandler(Game game) {
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                game.getPlayer().setLeft(true);
                break;
            case KeyEvent.VK_D:
                game.getPlayer().setRight(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                game.getPlayer().setLeft(false);
                break;
            case KeyEvent.VK_D:
                game.getPlayer().setRight(false);
                break;
        }
    }
}
