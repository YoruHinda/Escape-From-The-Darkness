package com.github.yoruhinda.escapefromthedarkness.game.ui;

import com.github.yoruhinda.escapefromthedarkness.game.Game;
import com.github.yoruhinda.escapefromthedarkness.game.handler.KeyHandler;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private Game game;
    private KeyHandler keyHandler;
    public GamePanel(Game game){
        this.game = game;
        keyHandler = new KeyHandler(game);
        initialize();
    }
    public void initialize(){
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(keyHandler);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.render(g);
    }
}
