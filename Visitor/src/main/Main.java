package src.main;

import src.models.*;
import src.visitors.*;

public class Main {

    public static void main(String[] args) {
        Triangulo triangulo = new Triangulo(10, 10, 12);
        Retangulo retangulo = new Retangulo(40, 20);
        Circulo circulo = new Circulo(5);
        Trapezio trapezio = new Trapezio(20, 10, 15);

        Visitor calcularArea = new VisitorCalcularArea();
        Visitor desenhar = new VisitorDesenhar();
        Visitor calcularPerimetro = new VisitorCalcularPerimetro();
        Visitor maximizar = new VisitorMaximizar();

        System.out.println("\nFormas / Desenhos \n");

        circulo.aceitarVisita(desenhar);
        retangulo.aceitarVisita(desenhar);
        trapezio.aceitarVisita(desenhar);
        triangulo.aceitarVisita(desenhar);

        System.out.println("\nAreas\n");

        System.out.println("Circulo: " + circulo.aceitarVisita(calcularArea));
        System.out.println("Retangulo: " + retangulo.aceitarVisita(calcularArea));
        System.out.println("trapezio: " + trapezio.aceitarVisita(calcularArea));
        System.out.println("Triangulo: " + triangulo.aceitarVisita(calcularArea));

        System.out.println("\nPerimetros\n");

        System.out.println("Circulo: " + circulo.aceitarVisita(calcularPerimetro));
        System.out.println("Retangulo: " + retangulo.aceitarVisita(calcularPerimetro));
        System.out.println("trapezio: " + trapezio.aceitarVisita(calcularPerimetro));
        System.out.println("Triangulo: " + triangulo.aceitarVisita(calcularPerimetro));

        circulo.aceitarVisita(maximizar);
        retangulo.aceitarVisita(maximizar);
        trapezio.aceitarVisita(maximizar);
        triangulo.aceitarVisita(maximizar);

        System.out.println("\nMaximizado\n");

        circulo.aceitarVisita(desenhar);
        retangulo.aceitarVisita(desenhar);
        trapezio.aceitarVisita(desenhar);
        triangulo.aceitarVisita(desenhar);

    }
}
