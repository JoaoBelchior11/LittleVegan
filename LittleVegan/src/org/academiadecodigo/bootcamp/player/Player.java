package org.academiadecodigo.bootcamp.player;

import org.academiadecodigo.bootcamp.CollisionDetector;
import org.academiadecodigo.bootcamp.Direction;
import org.academiadecodigo.bootcamp.Position;
import org.academiadecodigo.bootcamp.gfx.simplegfx.Grid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player implements KeyboardHandler {

    //PROPERTIES
    private String name;
    private Position pos;
    private int score;
    private int distance;
    private Grid grid;
    private Keyboard keyboard;
    private CollisionDetector collisionDetector;

    public Player(String name, int distance, Grid grid) {

        keyboard = new Keyboard(this);

        score = 0;
        this.name = name;
        this.distance = distance;
        this.grid = grid;
        this.pos = new Position((grid.getCols()/2),grid.getRows()-1,grid);

        init();
    }

    public void init(){

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);
    }

    //GETTERS
    public Position getPos() {

        return pos;
    }

    public int getScore() {

        return score;
    }

    //SETTERS
    public void setScore(int scoreToAdd) {

        this.score += scoreToAdd;
    }

    public void setCollisionDetector(CollisionDetector collisionDetector){

        this.collisionDetector = collisionDetector;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch(keyboardEvent.getKey()){

            case KeyboardEvent.KEY_LEFT:
                pos.moveDirection(Direction.LEFT, distance);
                break;

            case KeyboardEvent.KEY_RIGHT:
                pos.moveDirection(Direction.RIGHT, distance);
                break;

            default :
                System.out.println("Keyboard oops!\n");
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    @Override
    public String toString() {

        return String.format("Score: %2d", score);
    }
}
