package org.academiadecodigo.bootcamp;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        final int maxCols = 16;

        Game g = new Game(maxCols,15,200);

        g.init();
        g.start();

    }
}
