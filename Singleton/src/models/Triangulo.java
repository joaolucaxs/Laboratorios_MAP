package models;

import java.util.Arrays;
import exceptions.ExceptionValorNegativoOuZero;

public class Triangulo implements FiguraGeometrica {

    private static Triangulo[] instances = {null, null, null};
    protected double a, b, c;

    public Triangulo(double a, double b, double c) throws ExceptionValorNegativoOuZero {
        if (a <=0 || b <=0 || c <=0 ) {
            throw new ExceptionValorNegativoOuZero();
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public static Triangulo getInstance(double a, double b, double c) throws ExceptionValorNegativoOuZero {
        
        if (!ehTriangulo(a, b, c)) {
            return null;
        }

        if (ehRetangulo(a, b, c)) {
            if (instances[2] == null) instances[2] = new Triangulo(a, b, c);
            return instances[2];
        }

        if (ehEquilatero(a, b, c)) {
            if (instances[1] == null) instances[1] = new Triangulo(a, b, c);
            return instances[1];
        }

        if (ehIsosceles(a, b, c)) {
            if (instances[0] == null) instances[0] = new Triangulo(a, b, c);
            return instances[0];
        }
        return null;
    }

    private static boolean ehTriangulo(double a, double b, double c) {
        if ((a < b + c) && (b < a + c) && (c < a + b)) {
            return true;
        }
        return false;
    }

    private static boolean ehRetangulo(double a, double b, double c) {
        double[] array = {a, b, c};
        Arrays.sort(array);
        a = array[0];
        b = array[1];
        c = array[2];
        if(Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)){
            return true;
        }
        return false;
    }

    private static boolean ehEquilatero(double a, double b, double c) {
        if (a == b && b == c) {
            return true;
        }
        return false;
    }

    private static boolean ehIsosceles(double a, double b, double c) {
        if (a == b || a == c || b == c) {
            return true;
        }
        return false;
    }

    @Override
    public double getArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

    @Override
    public double getPerimetro() {
        return a + b + c;
    }

    @Override
    public String toString() {
        return "O triangulo criado tem lados de tamanho: " + a +"," + b +"," + c;
    }
}
