package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Config {

    public static String rotate = "Up", left = "Left", right = "Right", down = "Down", pause = "P";
    private static ArrayList<Choice> choices;

    public static void openConfig(JFrame frame) {
        choices = new ArrayList<Choice>();
        final JFrame options = new JFrame("Options");
        options.setSize(400,300);
        options.setResizable(false);
        options.setLocationRelativeTo(frame);
        options.setLayout(null);

        Choice left = addChoice("Left", options,30,30);
        left.select(Config.left);
        Choice right = addChoice("Right", options,30,75);
        right.select(Config.right);
        Choice down = addChoice("Down", options,30,120);
        down.select(Config.down);
        Choice rotate = addChoice("Rotate", options,30,165);
        rotate.select(Config.rotate);
        Choice pause = addChoice("P", options,30,210);
        pause.select(Config.pause);
        JButton done = new JButton("Done");
        done.setBounds(150, 200, 100, 30);
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                options.dispose();
                saveChanges();

            }
        });
        options.add(done);
        options.setVisible(true);


    }

    public static void saveChanges(){
        Choice left = choices.get(0);
        Choice right = choices.get(1);
        Choice down = choices.get(2);
        Choice rotate = choices.get(3);
        Choice pause = choices.get(4);
        Config.left = left.getSelectedItem();
        Config.right = right.getSelectedItem();
        Config.down = down.getSelectedItem();
        Config.rotate = rotate.getSelectedItem();
        Config.pause = pause.getSelectedItem();
    }

    public static Choice addChoice(String name, JFrame options, int x, int y) {
        JLabel label = new JLabel(name);
        label.setBounds(x, y-20,100,20);
        Choice key = new Choice();
        for (String s: getKeyNames()){
            key.add(s);
        }
        key.setBounds(x,y,100,20);
        options.add(key);
        options.add(label);
        choices.add(key);
        return key;


    }

    public static ArrayList<String> getKeyNames(){
        ArrayList<String> result = new ArrayList<String>();
        for(String s: KeyGetter.keyNames){
            result.add(s);
            if(s.equalsIgnoreCase("F24")){
                break;

            }
        }
        return result;
    }
}
