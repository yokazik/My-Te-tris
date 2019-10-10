package com.company;

import java.awt.*;

public class TetrisGrid {

   private int width, height, widthOff, heightOff;
   // -1 means empty, choose 0-6  to draw a block
   private int[][] grid;


   private int  SQUARE_SIZE = 25;
   private Image[] tetrisBlocks;

    public TetrisGrid(int width, int height, int wOff, int hOff, Image[] blocks){

        widthOff = wOff;
        heightOff = hOff;

        this.width = (width - widthOff) / SQUARE_SIZE;
        this.height = (height - heightOff) / SQUARE_SIZE;
        grid = new int[this.width][this.height];
        for (int x = 0; x< this.width; x++)
        {
            for (int y = 0; y< this.height; y++)
            {
                grid[x][y] = -1;
            }

        }

        grid[0][0] = 0;
        grid[1][0] = 2;
        grid[1][1] = 3;
        grid[0][1] = 1;
        tetrisBlocks = blocks;

    }

    public void drawGrid(Graphics2D g)
    {
        for(int x = 0; x < width; x++)
        {
            for(int y = 0; y < height; y++)
            {
                if (grid[x][y] != -1)
                {
                     g.drawImage(tetrisBlocks[grid[x][y]], widthOff + x * SQUARE_SIZE, heightOff +  y *SQUARE_SIZE, 25, 25, null); //change 1st [] 0-6 to change 1 block color
                }
            }

        }

    }

}
