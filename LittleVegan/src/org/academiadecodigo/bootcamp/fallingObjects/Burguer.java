package org.academiadecodigo.bootcamp.fallingObjects;

import org.academiadecodigo.bootcamp.Position;

public class Burguer extends Food {

    public Burguer(Position pos){

        super(FoodType.BURGUER.getSpeed(), FoodType.BURGUER.getGainPoints(), pos);
    }




}
