/*
 * Copyright (c) 2015. Filip Bartuzi
 */

import java.util.ArrayList;

class Polynomial {
    public ArrayList<Double> getCoefficients() {
        return coefficients;
    }

    private ArrayList<Double> coefficients = new ArrayList<Double>();

    public Polynomial() {
        coefficients.add(0.0);
    }

    public Polynomial(double[] givenCoefficients) {
        for (double givenCoefficient : givenCoefficients) {
            coefficients.add(givenCoefficient);
        }
    }

    public Polynomial(ArrayList<Double> givenCoefficients) {
        for (double coefficient : givenCoefficients)
            coefficients.add(coefficient);
    }

    public String toString() {
        String readablePolynomial = "";
        readablePolynomial += coefficients.get(0);
        for (int i = 1; i < coefficients.size(); i++) {
            double coefficient = coefficients.get(i);
            if (coefficient == 0.0)
                continue;
            readablePolynomial += " + " + (coefficients.get(i) + (i > 1 ? "x^"+ (i) : "x") );
        }
        return readablePolynomial;
    }

    public Polynomial add(Polynomial component) {
        for (int i = 0; i < component.coefficients.size(); i++) {
            if (i < coefficients.size())
                coefficients.set(i, coefficients.get(i) + component.coefficients.get(i));
            else
                coefficients.add(component.coefficients.get(i));
        }
        return this;
    }

    public Polynomial subtract(Polynomial subtrahend) {
        for (int i = 0; i < subtrahend.coefficients.size(); i++) {
            if (i < coefficients.size())
                coefficients.set(i, coefficients.get(i) - subtrahend.coefficients.get(i));
            else
                coefficients.add(subtrahend.coefficients.get(i) * -1);
        }
        return this;
    }

//    public Polynomial subtractAlternative(Polynomial subtrahend) {
//      NEGATE ALL subtrahend.coefficients and send them to Polynomial.add ???
//    }

    public static Polynomial add(Polynomial p1, Polynomial p2) {
        return (new Polynomial(p1.coefficients)).add(p2);
    }

    public static Polynomial subtract(Polynomial p1, Polynomial p2) {
        return (new Polynomial(p1.coefficients)).subtract(p2);
    }

//    public Polynomial multiply(Polynomial factor) {
//
//    }

    public static void main(String[] args) {
        Polynomial p0 = new Polynomial();
        double[] polynomialArgs = {1, 2};
        Polynomial p2 = new Polynomial(polynomialArgs);
        Polynomial p3 = new Polynomial(polynomialArgs);
        System.out.println("p0: " + p0);
        System.out.println("p2: " + p2);
        System.out.println("p3: " + p3);
        System.out.println("p3 + p2: " + p3.add(p2));
        System.out.println("p3 - p2: " + p3.subtract(p2));
        System.out.println(Polynomial.add(p2, p2));
        System.out.println("p2: " + p2);
        p2.add(p2);
        System.out.println("p2: " + p2);
        System.out.println("doing p3 - p2: " + p3 + " - (" + p2 + ")");
        Polynomial p4  = Polynomial.subtract(p3, p2);
        System.out.println("p4 = " + p4);
    }
}