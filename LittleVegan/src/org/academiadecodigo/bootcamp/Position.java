package org.academiadecodigo.bootcamp;

import javafx.geometry.Pos;
import org.academiadecodigo.bootcamp.fallingObjects.Food;
import org.academiadecodigo.bootcamp.gfx.simplegfx.Grid;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Position {

    private int row;
    private int col;
    private Grid grid;
    private Picture pic;

    public Position(int cols, int rows, Grid grid){

        this.col = cols;
        this.row = rows;
        this.grid = grid;
        this.pic = new Picture();
    }

    //METHODS
    public void moveDirection(Direction direction, int distance){

        switch (direction){

            case UP :
                moveUp(distance);
                break;

            case DOWN :
                moveDown(distance);
                break;

            case LEFT :
                moveLeft(distance);
                break;

            case RIGHT :
                moveRight(distance);
                break;
        }
    }

    private void moveUp(int dist) {

        int maxRowsUp = Math.min(dist,getRow());
        setPos(getCol(), getRow() - maxRowsUp);
    }

    private void moveDown(int dist) {

        if (row < grid.getRows()-1){

            if (dist > grid.getRows() - (getRow()+1)){

                setPos(getCol(), getRow() + (grid.getRows() - (getRow() + 1)));

            } else {

                setPos(getCol(), getRow() + dist);
            }

            pic.translate(0,dist*Grid.CELL_SIZE);
            //pic.draw();
        }
    }

    private void moveLeft(int dist) {

        if (col > 0){

            if (col-dist < 0){

                setPos(0, getRow());

            } else {

                setPos(getCol() - dist, getRow());
            }

            pic.translate(-dist*Grid.CELL_SIZE,0);
        }
    }

    private void moveRight(int dist) {

        if (col < grid.getCols()-1){

            if (dist > grid.getCols() - (getCol()+1)){

                setPos(getCol() + (grid.getCols() - (getCol() + 1)), getRow());

            } else {

                setPos(getCol() + dist, getRow());
            }

            pic.translate(dist*Grid.CELL_SIZE,0);
        }
    }

    public void hideRect(){

        pic.delete();
    }

    public boolean equals (Position toCompare){

        return this.col == toCompare.getCol() && this.row == toCompare.getRow();
    }

    public void firstPicFood(String url, int col, int row){

        pic.translate(grid.columnToX(col), row);
        pic.load(url);
        pic.draw();
    }

    public void firstPicPlayer(String url, int col, int row){

        pic.translate(grid.columnToX(col), grid.rowToY(row));
        pic.load(url);
        pic.draw();
    }

    //GETTERS

    public int getCol() {

        return col;
    }

    public int getRow() {

        return row;
    }

    public Grid getGrid() {

        return grid;
    }

    //SETTER
    public void setPos(int col, int row){

        this.col = col;
        this.row = row;
    }

}
