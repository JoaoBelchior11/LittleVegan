package org.academiadecodigo.bootcamp.fallingObjects;

public enum FoodType {

    APPLE(1,1),
    BANANA(2,3),
    STRAWBERRY(3,2),
    SUSHI(1,-1),
    BURGUER(2,-2);

    private int movingSpeed;
    private int gainPoints;

    FoodType(int speed, int gainPoints){

        this.movingSpeed = speed;
        this.gainPoints = gainPoints;
    }

    //GETTERS
    public int getSpeed(){

        return this.movingSpeed;
    }

    public int getGainPoints(){

        return this.gainPoints;
    }
}

