import java.awt.geom.Point2D;

/**
 * Created by filip on 09/03/15.
 * Copyright (c) 2015. Filip Bartuzi
 */
public class Point extends Point2D {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(Point point){
        this.x = point.x;
        this.y = point.y;
    }

    public boolean equals(Point point){
        return x == point.x && y == point.y;
    }

    public boolean isIn(Rectangle rectangle) {
        return rectangle.contains(this);
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
