/*
 *   Author: Rachael Silverwood
 *   Date: 10/25/2016
 */
public class TriangleClassifier{

    /*
     *   The Classify method determines whether 3 integers can from a valid triangle.
     *   It also classifies the triangle as equilateral, isosceles, or right, if applicable.
     *
     *   @param a side of triangle
     *   @param b side of triangle
     *   @param c side of triangle
     *   @return String of the type of triangle and whether its valid
     */
    public String classify(int a, int b, int c){

        if(a+b>c && a+c>b && b+c>a){

            if(a==b && b==c){

                return "These side lengths produce a valid equilateral triangle.";

            }else if(a==b || b==c || a==c){

                return "These side lengths produce a valid isosceles triangle";

            }else if(a*a + b*b == c*c || a*a + c*c == b*b || b*b + c*c == a*a){

                return "These side lengths produce a valid right triangle";

            }
            else{

                return "These side lengths produce a valid triangle";

            }
        }
        else{
            return "Invalid Triangle";
        }
    }
}

