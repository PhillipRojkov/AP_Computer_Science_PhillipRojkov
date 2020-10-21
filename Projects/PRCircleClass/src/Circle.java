/*
* Class Name: Circle
* Date Created: October 10, 2020
* Author: Phillip Rojkov
* Details: Circle class, takes radius as constructor parameter, methods to return area, circumference, diameter and mutator setRadius
* Methods: setRadius(r), getRadius(), diameter(), circumference(), area()
* Static variables: none
 */

public class Circle {
    private double radius;

    public Circle (double r) {
        radius = r;
    }

    public void setRadius (double r) { //radius mutator
        radius = r;
    }

    public double getRadius () { //radius accessor
        return radius;
    }

    public double diameter () { //diameter accessor
        double diameter = 2 * radius;
        return diameter;
    }

    public double circumference () { //circumference accessor
        double circumference = 2 * Math.PI * radius;
        return circumference;
    }

    public double area () { //area accessor
        double area = Math.PI * Math.pow(radius, 2);
        return area;
    }
}
