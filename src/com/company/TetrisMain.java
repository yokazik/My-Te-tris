package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.io.IOException;

public class TetrisMain extends Canvas implements Runnable{

    public static final int WIDTH = 400, HEIGHT = 565;
    private Image[] tetrisBlocks;
    Controller control;

    private TetrisGrid tetrisGrid;




    public static void main(String[] args) {

        //creating Tetris main table, incl. size and closing method

        final JFrame frame = new JFrame("My(Tet)ris");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);

        KeyGetter.loadKeys();
        try {
            Config.loadConfig();

        } catch (Exception e) {
            e.printStackTrace();
        }


        JMenuBar bar = new JMenuBar();
        bar.setBounds(0, 0, WIDTH - 20, 25);


        JMenu file = new JMenu("File");
        file.setBounds(0, 0, 45, 24);

        JMenuItem newGame = new JMenuItem("New Game");
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Code newGame button
                System.out.println("Starting New Game ");

            }
        });

        JMenuItem highscore = new JMenuItem("Highscore");
        highscore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Code highscore button
                System.out.println("Highscore");
                int highscore = 0;
                final JFrame alert = new JFrame();
                alert.setSize(200, 150);
                alert.setLayout(null);
                alert.setLocationRelativeTo(null);
                alert.setAlwaysOnTop(true);

                JLabel score = new JLabel("The highscore is " + highscore);
                score.setBounds(0, 0, 200, 50);


                JButton okButton = new JButton("OK");
                okButton.setBounds(50, 70, 100, 30);


                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        alert.dispose();
                    }
                });
                alert.add(score);
                alert.add(okButton);
                alert.setResizable(false);
                alert.setVisible(true);

            }
        });

        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Code exit button
                System.out.println("Closing ");
                System.exit(0);

            }
        });


        JMenuItem options = new JMenuItem("Options");
        options.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Config.openConfig(frame);
            }
        });


        TetrisMain tm = new TetrisMain();
        tm.setBounds(0, 25, WIDTH, HEIGHT - 25);

        frame.add(tm);
        file.add(newGame);
        file.add(highscore);
        file.add(options);
        file.add(exit);
        bar.add(file);
        frame.add(bar);
        frame.setVisible(true);
        tm.start();


    }

    public void start() {
        Thread t = new Thread(this);
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();

    }

    public void run() {
        init();
        boolean running = true;
        while (running) {
            update();
            BufferStrategy buf = getBufferStrategy();
            if (buf == null) {
                createBufferStrategy(3);
                continue;

            }
            Graphics2D g = (Graphics2D) buf.getDrawGraphics();
            render(g);
            buf.show();
            buf.show();
        }
    }

    public void init() {
        control = new Controller(this);
        this.addKeyListener(control);
        requestFocus();
        try {
            tetrisBlocks = ImageLoader.loadImage("tetris.jpg", 25);
        } catch (IOException e) {
            System.out.println("Error loading tetris.jpg");
            System.exit(1);
        }
        tetrisGrid = new TetrisGrid(WIDTH, HEIGHT, 150, 150, tetrisBlocks);
    }


    public void update() {
//        System.out.println(control.left + " : " + control.right + " : " + control.down + " : " + control.rotate + " : " + control.pause);

    }


    public void render(Graphics2D g) {
        g.setColor(Color.BLACK);  // change board background color
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Calibri", Font.PLAIN, 20));
        g.drawString("My(Te)tris", 150, 25);
        tetrisGrid.drawGrid(g);

    }

}




