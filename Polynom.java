import java.util.ArrayList;

public class Polynom {
  private ArrayList<Double> coeffs = new ArrayList();
  
  public Polynom(){
    coeffs.add(0.0);
  }

  public Polynom(double[] givenCoeffs){
    for (int i = 0; i < givenCoeffs.length; i++) {
      coeffs.add(givenCoeffs[i]);
    }
  }

  public Polynom(ArrayList<Double> givenCoeffs){
    for(double coeff : givenCoeffs)
      coeffs.add(coeff);
  }

  public String toString(){
    String readablePolynom = "";
    readablePolynom += coeffs.get(0);
    for (int i = 1; i < coeffs.size(); i++) {
      double coeff = coeffs.get(i);
      if (coeff == 0.0)
        continue;
      readablePolynom += " + " + (coeffs.get(i) + "x^" + (i+1));
    }
    return readablePolynom;
  } 

  // TO FIX!!!!! ADD & SUBSTRACT

  public Polynom add(Polynom component){
    int lowerPower = lowerPower(this, component);
    for (int i = 0; i < lowerPower; i++) {
      coeffs.set(i, new Double(coeffs.get(i) + component.coeffs.get(i)));
    }
    if (lowerPower == maxPower()) {
      for (int i = lowerPower + 1; i < component.maxPower(); i++) {
        coeffs.add(component.coeffs.get(i));
      }
    }
    return this;
  }

  public Polynom substract(Polynom subtrahend){
    int lowerPower = lowerPower(this, subtrahend);
    for (int i = 0; i < lowerPower; i++) {
      coeffs.set(i, new Double(coeffs.get(i) - subtrahend.coeffs.get(i)));
    }
    return this;
  }

  public static int lowerPower(Polynom p1, Polynom p2){
    return p1.maxPower() > p2.maxPower() ? p2.maxPower() : p1.maxPower();
  }

  public static Polynom add(Polynom p1, Polynom p2){
    return (new Polynom(p1.coeffs)).add(p2);
  }

  public static Polynom substract(Polynom p1, Polynom p2){
    return (new Polynom(p1.coeffs)).substract(p2);
  }

  public int maxPower(){
    return coeffs.size();
  }


  public Polynom multiply(Polynom factor){

  }

  public static void main(String[] args){
    Polynom p0 = new Polynom();
    double[] polynomArgs = { 1, 2};
    Polynom p2 = new Polynom(polynomArgs);
    Polynom p3 = new Polynom(polynomArgs);
    System.out.println("p0: " + p0);
    System.out.println("p2: " + p2);
    System.out.println("p3: " + p3);
    System.out.println("p3 + p2: " + p3.add(p2));
    System.out.println("p3 - p2: " + p3.substract(p2));
    System.out.println(Polynom.add(p2,p2));
    System.out.println("p2: " + p2);

  }
}