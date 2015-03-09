import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void testIsIn() throws Exception {
        Rectangle rectangle = new Rectangle(0.0, 5.0, 5.0, 0.0);
        Point pointInside = new Point(2, 2);
        Point pointOutside = new Point(10, 10);
        assertTrue(pointInside.isIn(rectangle));
        assertFalse(pointOutside.isIn(rectangle));
    }
}