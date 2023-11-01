package com.github.yoruhinda.escapefromthedarkness.game;

import com.github.yoruhinda.escapefromthedarkness.entity.Player;
import com.github.yoruhinda.escapefromthedarkness.game.ui.GamePanel;

import javax.swing.*;
import java.awt.*;

public class Game extends Thread{
    private boolean running = true;
    private JFrame gameFrame = new JFrame();
    private GamePanel gamePanel = new GamePanel(this);
    private Player player = new Player(gamePanel);

    public Game() {
        start();
    }

    private void initializeFrame(){
        gameFrame.setTitle("Escape From The Darkness");
        gameFrame.setSize(500,500);
        gameFrame.getContentPane().add(gamePanel);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
    }

    @Override
    public void run(){
        initializeFrame();
        final int desiredFPS = 60;
        final int desiredUPS = 60;

        final long updateThreshold = 1000000000 / desiredUPS;
        final long drawThreshold = 1000000000 / desiredFPS;

        long lastFPS = 0, lastUPS = 0, lastFPSUPSOutput = 0;

        int fps = 0, ups = 0;

        loop:
        while(running){
            if((System.nanoTime() - lastFPSUPSOutput) > 1000000000){
                System.out.println("FPS: " + (double)fps);
                System.out.println("UPS: " + (double)ups);

                fps = 0;
                ups = 0;

                lastFPSUPSOutput = System.nanoTime();
            }
            if((System.nanoTime() - lastUPS) > updateThreshold){
                lastUPS = System.nanoTime();
                update();
                ups++;
            }
            if((System.nanoTime() - lastFPS) > drawThreshold){
                lastFPS = System.nanoTime();
                gamePanel.repaint();
                fps++;
            }
            if(!((System.nanoTime() - lastUPS) > updateThreshold || (System.nanoTime() - lastFPS) > drawThreshold)){
                long nextScheduledUP = lastUPS + updateThreshold;
                long nextScheduledDraw = lastFPS + drawThreshold;

                long minScheduled = Math.min(nextScheduledUP, nextScheduledDraw);

                long nanosToWait = minScheduled - System.nanoTime();

                if(nanosToWait <= 0)
                    continue loop;

                try{
                    Thread.sleep(nanosToWait / 1000000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    private void update(){
        player.update();
    }

    public void render(Graphics graphics){
        player.render(graphics);
    }

    public Player getPlayer() {
        return player;
    }
}
