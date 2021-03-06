package engine.main;

import engine.input.KeyHandler;
import worlds.*;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game{

    //General
    public int width, height; //with and height of the game
    public String title; //title of the Window
    boolean running = true;

    //Engine.Input
    private KeyHandler keyHandler;

    //Graphical
    private Display display;

    /*
    ====================================================================================================================
    Init Methods
    ====================================================================================================================
     */
    /**
     * Constructor
     */
    public Game(){
        title = "entity";
        width = 19 * 38 + 1; //19
        height = 26 * 38 + 1;//26
        init();
    }

    /**
     * initializes:
     * Engine.Input.KeyHandler
     * JFrame
     * first World
     */
    private void init(){
        keyHandler = new KeyHandler();
        display = new Display(title, width, height); //creates Engine.Main.Engine.Main.Engine.Main.Engine.Main.Engine.Main.Display
        display.getFrame().addKeyListener(keyHandler); //adds KeyListener
        PacMan world = new PacMan(this);
        Worlds.setWorld(world);
    }


    /*
    ====================================================================================================================
    GAME LOOP
    ====================================================================================================================
     */
    /**
     * loop
     * frames -> fps
     * ticks -> tps
     */
    public void run(){
        int tps = 80; //ticks per second
        double timePerTick = 1000000000F / tps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;

        //tps counter
        int ticks = 0;

        //fps counter
        int frames = 0;
        long fpsTpsTimer = System.currentTimeMillis();

        while(running){
            //tick
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1){
                tick();
                ticks++;
                delta--;
            }

            if(timer >= 1000000000){
                timer = 0;
            }

            //render
            render();
            frames++;

            if(System.currentTimeMillis() - fpsTpsTimer > 1000){
                fpsTpsTimer = System.currentTimeMillis();
                //printStats(frames, ticks);
                frames = 0;
                ticks = 0;
            }
        }
    }

    /**
     * updates the game
     */
    private void tick(){
        keyHandler.tick();
        if(Worlds.getWorld() != null){
            Worlds.getWorld().tick();
        }
    }

    /**
     * renders the game
     */
    private void render(){
        //Graphics
        BufferStrategy bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0, 0, width, height);

        //Draw Here!
        if(Worlds.getWorld() != null){
            Worlds.getWorld().render(g); //render current world
        }
        //EndDrawing

        bs.show();
        g.dispose();
    }

    private void printStats(int frames, int ticks){
        System.out.println("FPS: " + frames + "  TPS: " + ticks);
    }


    /*
    ====================================================================================================================
    getter / setter
    ====================================================================================================================
     */
    public KeyHandler getKeyHandler(){
        return keyHandler;
    }
}
