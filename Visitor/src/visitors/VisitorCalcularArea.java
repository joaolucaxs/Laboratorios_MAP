package src.visitors;

import src.models.Circulo;
import src.models.Retangulo;
import src.models.Trapezio;
import src.models.Triangulo;

public class VisitorCalcularArea implements Visitor {

    @Override
    public double visitarCirculo(Circulo c) {
        return Math.PI * Math.pow(c.getRaio(), 2);
    }

    @Override
    public double visitarTriangulo(Triangulo t) {
        double a = t.getA();
        double b = t.getB();
        double c = t.getC();

        double p = (a + b + c) / 2.0;

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double visitarRetangulo(Retangulo r) {
        return 2.0 * (r.getBase() + r.getAltura());
    }

    @Override
    public double visitarTrapezio(Trapezio t) {
        return ((t.getBaseMaior() + t.getBaseMenor()) * t.getAltura()) / 2.0;
    }
}
