package src.models;

import src.visitors.Visitor;

import java.util.Objects;

public class Triangulo implements Forma {
    private double a, b, c;

    public Triangulo(double a, double b, double c) {
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

    @Override
    public double aceitarVisita(Visitor v) {
        return v.visitarTriangulo(this);
    }

    @Override
    public String toString() {
        return String.format("Triangulo{ a = %s, b = %s, c = %s }", a, b, c);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangulo triangulo = (Triangulo) o;
        return Double.compare(triangulo.a, a) == 0 &&
                Double.compare(triangulo.b, b) == 0 &&
                Double.compare(triangulo.c, c) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }
}
