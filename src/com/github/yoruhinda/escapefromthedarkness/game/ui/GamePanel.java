package com.github.yoruhinda.escapefromthedarkness.game.ui;

import com.github.yoruhinda.escapefromthedarkness.game.Game;
import com.github.yoruhinda.escapefromthedarkness.game.handler.KeyHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GamePanel extends JPanel {
    private Game game;
    private KeyHandler keyHandler;
    private BufferedImage background;
    public GamePanel(Game game){
        this.game = game;
        keyHandler = new KeyHandler(game);
        try {
            background = ImageIO.read(this.getClass().getResource("/resources/terrain/Blue Nebula/Blue_Nebula_01-512x512.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        initialize();
    }
    public void initialize(){
        setFocusable(true);
        addKeyListener(keyHandler);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background,0,0,this);
        game.render(g);
    }
}
