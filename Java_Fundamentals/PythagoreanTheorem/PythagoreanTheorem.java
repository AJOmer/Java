import java.lang.Math;
public class PythagoreanTheorem {
    public double calculateHypotenuse(int legA, int legB) {
        // the hypotenuse is the side across the right angle. 
        // calculate the value of c given legA and legB
        double A = (double) legA;
        double B = (double) legB;
        double squareLegA = A * A;
        double squareLegB = B * B;
        double squareLegC = squareLegA + squareLegB;
        double C = Math.sqrt(squareLegC);
        return C;
    }
}
