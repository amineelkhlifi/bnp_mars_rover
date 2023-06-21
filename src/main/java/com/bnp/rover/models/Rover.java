package com.bnp.rover.models;

public class Rover {
    private int x;
    private int y;
    private char direction;


    public Rover(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;

    }





    public String getPosition() {
        return x + " " + y + " " + direction;
    }

    public int getX() {
        return x;
    }

    public void incrementX(){
        x++;
    }

    public void decrementX(){
        x--;
    }


    public int getY() {
        return y;
    }

    public void incrementY(){
        y++;
    }

    public void decrementY(){
        y--;
    }
    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction){
        this.direction = direction;
    }
}
