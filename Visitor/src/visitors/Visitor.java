package src.visitors;

import src.models.Circulo;
import src.models.Retangulo;
import src.models.Trapezio;
import src.models.Triangulo;

public interface Visitor {

    double visitarCirculo(Circulo c);

    double visitarTriangulo(Triangulo t);

    double visitarRetangulo(Retangulo r);

    double visitarTrapezio(Trapezio t);
}
