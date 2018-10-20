package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.fallingObjects.Food;
import org.academiadecodigo.bootcamp.fallingObjects.FoodFactory;
import org.academiadecodigo.bootcamp.gfx.simplegfx.Grid;
import org.academiadecodigo.bootcamp.player.Player;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class Game {

    private Grid grid;
    private Food[] fallingObjects;
    private Player player;
    private int delay;
    private int delaySum;
    private CollisionDetector collisionDetector;
    private int quantityFallingObjects = 500;
    private Text score;
    private int level=1;
    private Text levelText;
    private int fallingObjectCounter=0;

    public Game(int cols, int rows, int delay){

        delaySum = 0;
        grid = new Grid(cols, rows);
        this.delay = delay;
    }

    public void init(){

        grid.init();

        fallingObjects = new Food[quantityFallingObjects];

        collisionDetector = new CollisionDetector(fallingObjects);

        for (int i = 0; i < quantityFallingObjects; i++){

            fallingObjects[i] = FoodFactory.getNewFruit(grid);
        }

        player = new Player("Ninja",1,grid);
        player.setCollisionDetector(collisionDetector);
        player.getPos().firstPicPlayer("elf3.png", grid.getCols()/2, grid.getRows()-1);
    }

    public void drawScore(){
        score = new Text(40,625,player.toString());
        score.draw();
        score.grow(30,15);
        score.setColor(Color.BLACK);
    }

    public void drawLevel(){
        levelText = new Text(570,625,toString());
        levelText.draw();
        levelText.grow(30,15);
    }

    public void start() throws InterruptedException {

        while (true){
            drawScore();
            drawLevel();
            moveFood();
            delaySum++;

            if(collisionDetector.eaten(player)){

                player.getScore();
            }

            if(player.getScore()<0){

                Text text = new Text(grid.columnToX(grid.getCols()/2),grid.rowToY(grid.getRows()/2),"GAME OVER");
                text.grow(150,100);
                text.draw();
                break;

            }
            if(fallingObjectCounter==quantityFallingObjects){

                Text text = new Text(grid.columnToX(grid.getCols()/2),grid.rowToY(grid.getRows()/2),"YOU WIN!");
                text.grow(150,100);
                text.draw();
                break;

            }

            increaseLevel();
            activate(delaySum);
            Thread.sleep (delay);
            score.delete();
            levelText.delete();
        }
    }

    public void increaseLevel(){

        if(player.getScore()>level*5){
            level++;

        }

    }

    public void moveFood(){

        for (int i = 0; i < quantityFallingObjects; i++) {

            if(fallingObjects[i].getActivated()){

                if(fallingObjects[i].getPos().getRow()==grid.getRows()-1){

                    fallingObjects[i].deactivate();
                    fallingObjects[i].getPos().setPos(-3,-3);
                    fallingObjects[i].getPos().hideRect();

                    if(fallingObjects[i].getGainPoints() > 0){

                        player.setScore(-1);
                    }

                    System.out.println("Player Score: " + player.getScore());
                }
                fallingObjects[i].moveDirection(Direction.DOWN,1);
            }
        }
    }

    private void activate (int delaySum){

        for (int i = 0; i < fallingObjects.length ; i++) {

            if(delaySum==i*20/level+5){
                fallingObjects[i].activate();
                fallingObjectCounter++;

            }
        }
    }


    @Override
    public String toString() {

        return String.format("Level: %2d", level);
    }
}

