package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class TetrisMain extends Canvas implements Runnable, KeyListener {

    public static final int WIDTH = 400, HEIGHT = 540;


    public static void main(String[] args) {

        //creating Tetris main table, incl. size and closing method

        JFrame frame = new JFrame("My(Tet)ris");
        frame.setSize(WIDTH,HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        TetrisMain tm = new TetrisMain();
        frame.add(tm);
        frame.setVisible(true);
        tm.start();

    }

    public void start(){
        Thread t = new Thread(this);
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();

    }

    public void run(){
        boolean running = true;
        while(running){
            update();
            BufferStrategy buf = getBufferStrategy();
            if(buf == null){
                createBufferStrategy(3);
                continue;

            }
            Graphics2D g = (Graphics2D) buf. getDrawGraphics();
            render(g);
            buf.show();
            buf.show();
        }
    }


    public void update(){

    }

    public void render(Graphics2D g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0, WIDTH, HEIGHT);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Calibri", Font.PLAIN, 20));
        g.drawString("My(Te)tris", 170,50);


    }




    // implementing reactions on keys from keyboard
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}
