package src.visitors;

import src.models.Circulo;
import src.models.Retangulo;
import src.models.Trapezio;
import src.models.Triangulo;

public class VisitorCalcularPerimetro implements Visitor {
    @Override
    public double visitarCirculo(Circulo c) {
        return 2.0 * Math.PI * c.getRaio();
    }

    @Override
    public double visitarTriangulo(Triangulo t) {
        return t.getA() + t.getB() + t.getC();
    }

    @Override
    public double visitarRetangulo(Retangulo r) {
        return 2.0 * (r.getBase() + r.getAltura());
    }

    @Override
    public double visitarTrapezio(Trapezio t) {
        return t.getBaseMaior() + t.getBaseMenor() + 2.0 * t.getAltura();
    }
}
