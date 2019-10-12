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
        grid = new int[this.height][this.width];
        for (int y = 0; y< this.height; y++)
        {
            for (int x = 0; x< this.width; x++)
            {
                grid[y][x] = -1;
            }

        }

        grid[0][0] = 0;
        grid[0][1] = 1;
        grid[2][0] = 2;
        grid[2][1] = 3;
        grid[4][0] = 4;
        grid[4][1] = 5;
        grid[6][0] = 0;
        grid[6][1] = 0;

        for (int x = 0; x < this.width; x++)
        {
            grid[1][x] = 0;
            grid[3][x] = 1;
            grid[5][x] = 2;

        }
        int rowsRemoved = checkForRemove();
        System.out.println("Removed " + rowsRemoved + " rows");
        grid[0][0] = 2;
        tetrisBlocks = blocks;

    }

    public int checkForRemove()
    {
        int rowsRemoved = 0;
        for (int y = 0; y < height; y++)

            {
                boolean isRowFull = true;
                for (int x = 0; x < width; x++)
                {
                    if (grid[y][x] == -1) {
                        isRowFull = false;
                        break;
                    }
                }
                if (isRowFull)
                {
                    removeRow(y);
                    rowsRemoved++;
                }
            }

        return rowsRemoved;
    }

    private void removeRow(int row)
    {
        for (int y = row; y > 0; y--)
        {
            for (int x = 0; x < width; x++)
            {
                grid[y][x] = grid[y - 1][x];
            }
        }
        for (int x = 0; x < width; x++)
        {
            grid[0][x] = -1;
        }


    }


    public void drawGrid(Graphics2D g)
    {
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                if (grid[y][x] != -1)
                {
                     g.drawImage(tetrisBlocks[grid[y][x]], widthOff + x * SQUARE_SIZE, heightOff +  y *SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE, null); //change 1st [] 0-6 to change 1 block color
                }
            }

        }

    }

}
