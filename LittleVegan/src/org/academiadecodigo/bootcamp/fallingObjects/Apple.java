package org.academiadecodigo.bootcamp.fallingObjects;

import org.academiadecodigo.bootcamp.Position;

public class Apple extends Food {

    public Apple(Position pos){

        super(FoodType.APPLE.getSpeed(), FoodType.APPLE.getGainPoints(), pos);
    }


}
