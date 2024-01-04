package com.github.yoruhinda.escapefromthedarkness.animation;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Animation {

    private int frameCount;
    private int frameDelay;
    private int currentFrame;
    private int animationDirection;
    private int totalFrames;

    private boolean stopped;

    private List<Frame> frames = new ArrayList<>();

    public Animation(List<BufferedImage> frames, int frameDelay){
        this.frameDelay = frameDelay;
        this.stopped = true;

        for(int i = 0; i < frames.size(); i++){
            this.frames.add(new Frame(frames.get(i), frameDelay));
        }

        this.frameCount = 0;
        this.currentFrame = 0;
        this.animationDirection = 1;
        this.totalFrames = this.frames.size();
    }

    public void start(){
        if(!stopped){
            return;
        }
        if(frames.isEmpty()){
            return;
        }

        stopped = false;
    }

    public void stop(){
        if (frames.isEmpty()){
            return;
        }

        stopped = true;
    }

    public void restart(){
        if (frames.isEmpty()){
            return;
        }

        stopped = false;
        currentFrame = 0;
    }

    public void reset(){
        this.stopped = true;
        this.frameCount = 0;
        this.currentFrame = 0;
    }

    public void addFrame(BufferedImage frame, int duration){
        if(duration <= 0){
            System.err.println("Invalid Duration: " + duration);
            throw new RuntimeException("Invalid Duration: " + duration);
        }
        frames.add(new Frame(frame, duration));
        currentFrame = 0;
    }

    public BufferedImage getSprite(){
        return frames.get(currentFrame).getFrame();
    }

    public void update(){
        if (!stopped){
            frameCount++;

            if(frameCount > frameDelay){
                frameCount = 0;
                currentFrame += animationDirection;
                if (currentFrame > totalFrames - 1){
                    currentFrame = 0;
                } else if (currentFrame < 0) {
                    currentFrame = totalFrames - 1;
                }
            }
        }
    }
}
