package org.academiadecodigo.bootcamp.fallingObjects;

import org.academiadecodigo.bootcamp.Position;

public class Sushi extends Food {

    public Sushi(Position pos){

        super(FoodType.SUSHI.getSpeed(), FoodType.SUSHI.getGainPoints(), pos);
    }
}
