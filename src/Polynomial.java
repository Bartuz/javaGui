/*
 * Copyright (c) 2015. Filip Bartuzi
 */

import java.util.ArrayList;
import java.util.ListIterator;

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

    public int maxCoefficientPower() {
        return coefficients.size() - 1;
    }

    public Polynomial(ArrayList<Double> givenCoefficients) {
        for (double coefficient : givenCoefficients)
            coefficients.add(coefficient);
    }

    @Override
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

    public Polynomial multiply(Polynomial factor) {
        int newCoefficientsSize =  maxCoefficientPower() + factor.maxCoefficientPower() + 1;
        ArrayList<Double> newCoefficients = new ArrayList<Double>(newCoefficientsSize);
        ensureSize(newCoefficients, newCoefficientsSize);
        for (int i = 0; i < factor.coefficients.size(); i++) {
            Double factorsCoefficient = factor.coefficients.get(i);
            if (factorsCoefficient != 0.0)
                for (int j = 0; j < coefficients.size(); j++) {
                    Double coefficient = coefficients.get(j);
                    if (coefficient != 0.0) {
                        int newCoefficientPower = i+j;
                        double valueAlreadyAssignedAtNewPowerIndex = newCoefficients.get(newCoefficientPower);
                        newCoefficients.set(newCoefficientPower, factorsCoefficient * coefficient + valueAlreadyAssignedAtNewPowerIndex);
                    }
                }
        }
        this.coefficients = newCoefficients;
        return this;
    }

    public static Polynomial multiply(Polynomial p1, Polynomial p2) {
        return (new Polynomial(p1.coefficients)).multiply(p2);
    }

    public Polynomial multiply(double factor) {
        return multiply(new Polynomial(new double[]{factor}));
    }

    public static Polynomial multiply(Polynomial polynomial, double factor) {
        return (new Polynomial(polynomial.coefficients)).multiply(factor);
    }

    private static void ensureSize(ArrayList<Double> list, int size) {
        list.ensureCapacity(size);
        while (list.size() < size) {
            list.add(0.0);
        }
    }

    public Double calculate(double x) {
        ListIterator<Double> coefficientsIterator = coefficients.listIterator(coefficients.size());
        double result = 0.0;
        while(coefficientsIterator.hasPrevious()) {
            double coefficient = coefficientsIterator.previous();
            result = result * x + coefficient;
        }
        return result;
    }

    public Polynomial setCoefficient(int power, double value) {
        if (power > maxCoefficientPower())
            ensureSize(coefficients, power + 1);
        coefficients.set(power, value);
        return this;
    }
}