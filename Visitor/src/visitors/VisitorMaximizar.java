package src.visitors;

import src.models.Circulo;
import src.models.Retangulo;
import src.models.Trapezio;
import src.models.Triangulo;

public class VisitorMaximizar implements Visitor {
    private static final double MAXIMIZA = 2.0;

    @Override
    public double visitarCirculo(Circulo c) {
        c.setRaio(MAXIMIZA * c.getRaio());

        return 0;
    }

    @Override
    public double visitarTriangulo(Triangulo t) {
        t.setA(MAXIMIZA * t.getA());
        t.setB(MAXIMIZA * t.getB());
        t.setC(MAXIMIZA * t.getC());

        return 0;
    }

    @Override
    public double visitarRetangulo(Retangulo r) {
        r.setAltura(MAXIMIZA * r.getAltura());
        r.setBase(MAXIMIZA * r.getBase());

        return 0;
    }

    @Override
    public double visitarTrapezio(Trapezio t) {
        t.setAltura(MAXIMIZA * t.getAltura());
        t.setBaseMenor(MAXIMIZA * t.getBaseMenor());
        t.setBaseMaior(MAXIMIZA * t.getBaseMaior());

        return 0;
    }
}
