package org.academiadecodigo.bootcamp.gfx.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.bootcamp.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    public static final int PADDING = 10;
    public static final int CELL_SIZE = 40;

    private int cols;
    private int rows;
    private Picture picture;

    private Rectangle field;

    public Grid(int cols, int rows){

        this.cols = cols;
        this.rows = rows;
        picture = new Picture(PADDING,PADDING,"forest.jpg");
        picture.draw();

    }

    public void init() {

        this.field = new Rectangle(PADDING,PADDING, cols * CELL_SIZE, rows * CELL_SIZE);
        this.field.draw();
    }

    public int getCellSize() {

        return CELL_SIZE;
    }

    public int getCols() {

        return this.cols;
    }

    public int getRows() {

        return this.rows;
    }

    public int getWidth() {

        return this.field.getWidth();
    }

    public int getHeight() {

        return this.field.getHeight();
    }

    public int getX() {

        return this.field.getX();
    }

    public int getY() {

        return this.field.getY();
    }

    public Position makeGridPosition(int col, int row) {

        return new Position(col, row, this);
    }

    public int rowToY(int row) {

        return PADDING + CELL_SIZE * row;
    }

    public int columnToX(int column) {

        return PADDING + CELL_SIZE * column;
    }
}
