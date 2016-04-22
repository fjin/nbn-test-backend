package nbn.rover;

/**
 * Created by jinf on 20/04/2016.
 */
public class Position {
    private int x;
    private int y;

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static Position position(int x, int y) {
        return new Position(x, y);
    }

    public void add(int x, int y){
        this.x += x;
        this.y += y;
    }

    public void sub(int x, int y) {
        this.x -= x;
        this.y -= y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Position)) {
            return false;
        }
        Position position = (Position)obj;
        return position.x == this.x && position.y == this.y;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
