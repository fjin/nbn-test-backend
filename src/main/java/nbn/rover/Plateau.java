package nbn.rover;

/**
 * Created by jinf on 20/04/2016.
 */
public class Plateau {
    private int width;
    private int height;

    private Plateau(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private Plateau(String params)
    {
        String[] size = params.split(" ");
        this.width = Integer.parseInt(size[0]);
        this.height = Integer.parseInt(size[1]);
    }

    public static Plateau plateau(int width, int height) {return new Plateau(width, height);}

    public static Plateau plateau(String params) {return new Plateau(params);}

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int length) {
        this.height = length;
    }

    public boolean isOut(Position position)
    {
        return position.getX() > width || position.getY() > height || position.getX() < 0 || position.getY() < 0;
    }
}
