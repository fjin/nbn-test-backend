package nbn.rover;

import nbn.rover.exception.OutOfPlateauException;

/**
 * Created by jinf on 20/04/2016.
 */
public class Rover {
    private Position position;
    private Direction direction;

    private Rover(Direction direction, Position position) {
        this.direction = direction;
        this.position = position;
    }

    public static Rover rover(Direction direction, Position position) {
        return new Rover(direction, position);
    }

    public Direction getDirection() {
        return this.direction;
    }

    public Position getPosition() {
        return this.position;
    }

    public void turnLeft() {
        this.direction = Direction.left(this.direction);
    }

    public void turnRight() {
        this.direction = Direction.right(this.direction);
    }

    public void move() {

        switch (this.direction){
            case EAST:
                this.position.add(1, 0);
                break;
            case SOUTH:
                this.position.sub(0, 1);
                break;
            case WEST:
                this.position.sub(1, 0);
                break;
            case NORTH:
                this.position.add(0, 1);
                break;
        }
    }

    private void executeCommand(char commandLetter) {

        if (commandLetter == 'L') {
            turnLeft();
        }

        if (commandLetter == 'R') {
            turnRight();
        }

        if (commandLetter == 'M') {
            move();
        }

    }

    public Rover run(String commands, Plateau plateau) throws OutOfPlateauException{
        for(char command : commands.toCharArray())
        {
            executeCommand(command);
            if(plateau.isOut(getPosition()))
            {
                throw new OutOfPlateauException("You are out of the plateau! Current position: " + this.getPosition().getX() + " " + this.getPosition().getY());
            }
        }
        return this;
    }

    @Override
    public String toString() {
        return "position: " + getPosition().getX() + " " + getPosition().getY() + " direction: " + getDirection();
    }
}
