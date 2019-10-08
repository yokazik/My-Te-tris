package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {

   TetrisMain game;
   public Controller(TetrisMain game) {
       this.game = game;
       }


                                              //implementing keys functions

       public void keyPressed (KeyEvent e){

                if (KeyEvent.getKeyText(e.getKeyCode()).equals(Config.left)){
                System.out.println("left pressed");
                }
                else if (KeyEvent.getKeyText(e.getKeyCode()).equals(Config.right)){
                System.out.println("right pressed");
                }
                else if (KeyEvent.getKeyText(e.getKeyCode()).equals(Config.rotate)){
                System.out.println("rotate pressed");
                }
                else if (KeyEvent.getKeyText(e.getKeyCode()).equals(Config.down)){
                System.out.println("down pressed");
                }
                else if (KeyEvent.getKeyText(e.getKeyCode()).equals(Config.pause)){
                System.out.println("pause pressed");
                }
            }

       public void keyTyped (KeyEvent e){
       if (KeyEvent.getKeyText(e.getKeyCode()).equals(Config.pause)) {
           System.out.println("P pressed");

       }

       }

       public void keyReleased (KeyEvent e) {
       }
}
