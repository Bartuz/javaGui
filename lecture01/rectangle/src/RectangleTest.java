import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleTest {

    @Test
    public void testConstructors() throws Exception {
        Rectangle rectangle1 = new Rectangle(0.0, 5.0, 5.0, 0.0);
        Rectangle rectangle2 = new Rectangle(0.0, 5.0, 5, 5);
        assertEquals(rectangle1.getBottomRight(), rectangle2.getBottomRight());
        assertEquals(rectangle1.getTopLeft(), rectangle2.getTopLeft());
    }

    @Test
    public void testContains() throws Exception {
        Rectangle rectangle = new Rectangle(0.0, 5.0, 5.0, 0.0);
        Point pointInside = new Point(2, 2);
        assertTrue(rectangle.contains(pointInside));
        Point pointOutside = new Point(10, 10);
        assertFalse(rectangle.contains(pointOutside));
    }

    @Test
    public void testIntersection() throws Exception {
        Rectangle rectangle1 = new Rectangle(0.0, 5.0, 5.0, 0.0);
        Rectangle rectangle2 = new Rectangle(3.0, 4.0, 10.0, 3.0);
        assertEquals(Rectangle.intersection(rectangle1, rectangle2), new Rectangle(3.0, 4.0, 5.0, 3.0));
    }
}