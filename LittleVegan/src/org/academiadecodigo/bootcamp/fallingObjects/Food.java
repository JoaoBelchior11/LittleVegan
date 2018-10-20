package org.academiadecodigo.bootcamp.fallingObjects;

import org.academiadecodigo.bootcamp.Direction;
import org.academiadecodigo.bootcamp.Position;

abstract public class Food {

    private Position pos;
    private int gainPoints;
    private int speed;
    private boolean eaten;
    private final Direction DIRECTION = Direction.DOWN;
    private boolean activated;
    private FoodType foodType;

    public Food(int speed, int gainPoints, Position pos){

        this.speed = speed;
        this.gainPoints = gainPoints;
        this.pos = pos;
    }

    //GETTERS
    public Position getPos() {

        return pos;
    }

    public int getGainPoints(){

        return gainPoints;
    }

    //JUST IN CASE
    /*public boolean isEaten() {

        return eaten;
    }*/

    public boolean getActivated(){

        return activated;
    }

    //SETTERS
    public void eat() {

        deactivate();
        this.eaten = true;
    }

    public void activate(){

        activated=true;
    }

    public void deactivate(){

        activated=false;
    }

    public void moveDirection(Direction direction, int distance){

        pos.moveDirection(DIRECTION, distance);
    }
}
