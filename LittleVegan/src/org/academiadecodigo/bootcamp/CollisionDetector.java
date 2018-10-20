package org.academiadecodigo.bootcamp;


import org.academiadecodigo.bootcamp.fallingObjects.Food;
import org.academiadecodigo.bootcamp.fallingObjects.Strawberry;
import org.academiadecodigo.bootcamp.player.Player;

public class CollisionDetector {

    private Food[] fallingObjects;

    public CollisionDetector(Food[] fallingObjects){

        this.fallingObjects = fallingObjects;
    }

    public boolean eaten (Player player){

        for (int i = 0; i < fallingObjects.length; i++){

            if(fallingObjects[i].getPos().equals(player.getPos())){

                player.setScore(fallingObjects[i].getGainPoints());

                fallingObjects[i].eat();
                fallingObjects[i].getPos().setPos(-3,-3);
                fallingObjects[i].getPos().hideRect();
                return true;
            }
        }
        return false;
    }


}
