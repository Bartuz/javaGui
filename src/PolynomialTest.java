/*
 * Copyright (c) 2015. Filip Bartuzi
 */

//import org.junit.After;
//import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

// QUESTIONS:
// 1. How to to setup (before?) to DRY p0, p1, p2 variables.
// 2. How to check if returned object is new one.

public class PolynomialTest {

    @Test
    public void testToString() throws Exception {
        Polynomial p0 = new Polynomial();
        Polynomial p1 = new Polynomial(new double[] {1, 2});
        Polynomial p2 = new Polynomial(new double[] {2, 3, 4});

        assertEquals("0.0", p0.toString());
        assertEquals("1.0 + 2.0x", p1.toString());
        assertEquals("2.0 + 3.0x + 4.0x^2", p2.toString());
    }

    @Test
    public void testAdd() throws Exception {
        Polynomial p1 = new Polynomial(new double[] {1, 2});
        Polynomial p2 = new Polynomial(new double[] {2, 3, 4});

        assertEquals((new Polynomial(new double[]{2, 4})).getCoefficients(), p1.add(p1).getCoefficients());
        assertEquals((new Polynomial(new double[]{4, 7, 4})).getCoefficients(), p2.add(p1).getCoefficients());
    }

    @Test
    public void testSubtract() throws Exception {
        Polynomial p1 = new Polynomial(new double[] {1, 2});
        Polynomial p2 = new Polynomial(new double[] {2, 3, 4});

        assertEquals((new Polynomial(new double[]{1, 1, 4})).getCoefficients(), p2.subtract(p1).getCoefficients());
        assertEquals((new Polynomial(new double[]{0, 1, -4})).getCoefficients(), p1.subtract(p2).getCoefficients());
    }
}