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
// 3. How to test static methods of add / subtract / multiply

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

    @Test
    public void testMaxCoefficientPower() throws Exception {
        Polynomial p2 = new Polynomial(new double[] {2, 0, 0, 4});
        assertEquals(3, p2.maxCoefficientPower());
    }

    @Test
    public void testMultiply() throws Exception {
        Polynomial p1 = new Polynomial(new double[] {1, 2});
        Polynomial p2 = new Polynomial(new double[] {2, 3, 4});
        assertEquals((new Polynomial(new double[]{2, 7, 10, 8})).getCoefficients(), p1.multiply(p2).getCoefficients());

        // IS IT OK???? Testing inversion of multiplication
        p1 = new Polynomial(new double[] {1, 2});
        assertEquals((new Polynomial(new double[]{2, 7, 10, 8})).getCoefficients(), p2.multiply(p1).getCoefficients());

        p2 = new Polynomial(new double[] {2, 0, 0, 4});
        assertEquals((new Polynomial(new double[]{2, 4, 0, 4, 8})).getCoefficients(), p2.multiply(p1).getCoefficients());
    }


    @Test
    public void testMultiplyStatic() throws Exception {
        Polynomial p1 = new Polynomial(new double[] {1, 2});
        Polynomial p2 = new Polynomial(new double[] {2, 3, 4});
        assertEquals((new Polynomial(new double[]{2, 7, 10, 8})).getCoefficients(), Polynomial.multiply(p2, p1).getCoefficients());
        assertEquals((new Polynomial(new double[]{2, 7, 10, 8})).getCoefficients(), Polynomial.multiply(p1, p2).getCoefficients());
        assertEquals((new Polynomial(new double[]{1, 2})).getCoefficients(), p1.getCoefficients());
        assertEquals((new Polynomial(new double[]{2, 3, 4})).getCoefficients(), p2.getCoefficients());
    }

    @Test
    public void testAddStatic() throws Exception {
        Polynomial p1 = new Polynomial(new double[] {1, 2});
        Polynomial p2 = new Polynomial(new double[] {2, 3, 4});
        assertEquals((new Polynomial(new double[]{3, 5, 4})).getCoefficients(), Polynomial.add(p2, p1).getCoefficients());
        assertEquals((new Polynomial(new double[]{3, 5, 4})).getCoefficients(), Polynomial.add(p1, p2).getCoefficients());
        assertEquals((new Polynomial(new double[]{1, 2})).getCoefficients(), p1.getCoefficients());
        assertEquals((new Polynomial(new double[]{2, 3, 4})).getCoefficients(), p2.getCoefficients());
    }

    @Test
    public void testSubtractStatic() throws Exception {
        Polynomial p1 = new Polynomial(new double[] {1, 2});
        Polynomial p2 = new Polynomial(new double[] {2, 3, 4});
        assertEquals((new Polynomial(new double[]{1, 1, 4})).getCoefficients(), Polynomial.subtract(p2, p1).getCoefficients());
        assertEquals((new Polynomial(new double[]{-1, -1, -4})).getCoefficients(), Polynomial.subtract(p1, p2).getCoefficients());
        assertEquals((new Polynomial(new double[]{1, 2})).getCoefficients(), p1.getCoefficients());
        assertEquals((new Polynomial(new double[]{2, 3, 4})).getCoefficients(), p2.getCoefficients());
    }

    @Test
    public void testMultiplyByNumber() throws Exception {
        Polynomial p1 = new Polynomial(new double[] {1, 2});
        int number = 4;
        assertEquals((new Polynomial(new double[]{4, 8})).getCoefficients(), p1.multiply(number).getCoefficients());
    }

    @Test
    public void testMultiplyByNumberStatic() throws Exception {
        Polynomial p1 = new Polynomial(new double[] {1, 2});
        int number = 4;
        assertEquals((new Polynomial(new double[]{4, 8})).getCoefficients(), Polynomial.multiply(p1, number).getCoefficients());
        assertEquals((new Polynomial(new double[]{1, 2})).getCoefficients(), p1.getCoefficients());
    }

    @Test
    public void testCalculate() throws Exception {
        Polynomial p1 = new Polynomial(new double[] {1, 2, 3});
        int x = 4;
        assertEquals(new Double(57), p1.calculate(x));
    }
}