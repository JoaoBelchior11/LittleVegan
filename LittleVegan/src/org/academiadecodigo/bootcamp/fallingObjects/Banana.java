package org.academiadecodigo.bootcamp.fallingObjects;

import org.academiadecodigo.bootcamp.Position;

public class Banana extends Food {

    public Banana(Position pos){

        super(FoodType.BANANA.getSpeed(), FoodType.BANANA.getGainPoints(), pos);
    }


}
