// This Program calculates the area,circumference, and radius of a random cirlce 
import java.util.Random;

public class CircleCalc {
    public static void main(String[] args) {
        double rad;
        Random rand= new Random();
        rad = rand.nextDouble();
        
        System.out.println("The Radius is = "+rad);
        System.out.println("The Circumference is = " + 2*Math.PI*rad);
        System.out.println("The Area is = " + Math.PI*rad*rad);
    }
}