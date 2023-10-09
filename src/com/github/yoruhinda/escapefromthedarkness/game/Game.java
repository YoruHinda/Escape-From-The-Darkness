package com.github.yoruhinda.escapefromthedarkness.game;

import javax.swing.*;
import java.awt.*;

public class Game extends Thread{
    private boolean running = true;
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();

    public Game() {
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Escape From The Darkness");
        panel.setBackground(Color.RED);
        frame.add(panel);
        frame.setVisible(true);
        start();
    }

    @Override
    public void run(){
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
                render();
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

    }

    private void render(){

    }
}
