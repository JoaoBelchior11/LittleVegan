package org.academiadecodigo.bootcamp.fallingObjects;

import org.academiadecodigo.bootcamp.Position;

public class Strawberry extends Food {

    public Strawberry(Position pos){

        super(FoodType.STRAWBERRY.getSpeed(), FoodType.STRAWBERRY.getGainPoints(), pos);
    }
}
