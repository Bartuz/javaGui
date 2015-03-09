/**
 * Created by filip on 08/03/15….
 * Copyright (c) 2015. Filip Bartuzi
 */
public class Rectangle {

    private Point topLeft;
    private Point bottomRight;

    public Rectangle(double topLeftX1, double topLeftY1, double bottomLeftX2, double bottomRightY2) {
        this.topLeft        = new Point(topLeftX1, topLeftY1);
        this.bottomRight    = new Point(bottomLeftX2, bottomRightY2);
    }
//    HOW TO DEAL WITH AMBIGUOUS CONSTRUCTORS ?
//    GET ALL FIELDS BT GETTERS OR BY THIS. ? -> http://stackoverflow.com/a/23696563/2047418
    public Rectangle(double topLeftX1, double topLeftY1, int width, int height) {
        this.topLeft        = new Point(topLeftX1, topLeftY1);
        this.bottomRight    = new Point(topLeftX1 + width, topLeftY1 - height);
    }

    public Rectangle(Point topLeft, Point bottomRight) {
//        HOW TO DEAL WITH COPY HERE?
//        this.topLeft = topLeft;
        this.topLeft        = new Point(topLeft);
        this.bottomRight    = new Point(bottomRight);
    }

    public boolean equals(Rectangle rectangle) {
        return topLeft.equals(rectangle.topLeft) && bottomRight.equals(rectangle.bottomRight);
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

//    public static Rectangle intersection(Rectangle r1, Rectangle r2) {
//        double newTopLeftX, newTopLeftY, newBottomRightX, newBottomRightY;
//        if (r1.isOverlapping(r2)) {
//            newTopLeftX     = Math.max(r1.topLeft.getX(), r2.topLeft.getX());
//            newTopLeftY     = Math.max(r1.topLeft.getY(), r2.topLeft.getY());
//            newBottomRightX = Math.max(r1.bottomRight.getX(), r2.getBottomRight().getX());
//            newBottomRightY = Math.max(r1.bottomRight.getY(), r2.getBottomRight().getY());
//        }
//
//    }
//
//    public boolean isOverlapping(Rectangle rectangle) {
//        return isTopLeftCornerOverLapping(rectangle) || isBottomRightCornerOverLapping(rectangle);
//    }
//
//    private boolean isTopLeftCornerOverLapping(Rectangle rectangle) {
//        return ((topLeft.isIn(rectangle) && !topLeft.equals(rectangle.bottomRight) ) || ( rectangle.topLeft.isIn(this)) && !rectangle.topLeft.equals(bottomRight) );
//    }
//
//    private boolean isBottomRightCornerOverLapping(Rectangle rectangle) {
//        return ((bottomRight.isIn(rectangle) && !bottomRight.equals(rectangle.topLeft) ) || ( rectangle.bottomRight.isIn(this)) && !rectangle.bottomRight.equals(topLeft));
//    }

    public boolean contains(Point point) {
        double givenX = point.getX();
        double givenY = point.getY();
        return givenX >= topLeft.getX() && givenX <= bottomRight.getX() && givenY <= topLeft.getY() && givenY >= bottomRight.getY();
    }
}
