package org.academiadecodigo.bootcamp.fallingObjects;

import org.academiadecodigo.bootcamp.gfx.simplegfx.Grid;

public class FoodFactory {

    public static Food getNewFruit(Grid grid){

        Food food;
        int random = (int) (Math.random() * FoodType.values().length);
        FoodType foodType = FoodType.values()[random];

        int row = -1;
        int row_Pixel = row*Grid.CELL_SIZE;
        int col = (int) (Math.random() * grid.getCols());

        switch(foodType){

            case APPLE:
                food = new Apple(grid.makeGridPosition(col,row));
                food.getPos().firstPicFood("apple.gif", col, row_Pixel);
                break;

            case BANANA:
                food = new Banana(grid.makeGridPosition(col,row));
                food.getPos().firstPicFood("banana.png", col, row_Pixel);
                break;

            case STRAWBERRY:
                food = new Strawberry(grid.makeGridPosition(col,row));
                food.getPos().firstPicFood("strawberry.png", col, row_Pixel);
                break;

            case SUSHI:
                food = new Sushi(grid.makeGridPosition(col,row));
                food.getPos().firstPicFood("sushi.png", col, row_Pixel);
                break;

            case BURGUER:
                food = new Burguer(grid.makeGridPosition(col,row));
                food.getPos().firstPicFood("burger.png", col, row_Pixel);
                break;

            default:
                food = new Apple(grid.makeGridPosition(col,row));
                food.getPos().firstPicFood("poop.png", col, row_Pixel);
                break;
        }
        return food;
    }
}
