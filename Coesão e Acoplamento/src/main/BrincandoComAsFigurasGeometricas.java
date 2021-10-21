package main;

import exceptions.ExceptionValorNegativoOuZero;
import model.Circulo;
import model.FiguraGeometrica;
import model.Quadrado;
import model.Retangulo;

public class BrincandoComAsFigurasGeometricas {
    public static void main(String[] args) {
        try {

            FiguraGeometrica circulo = new Circulo(3);
            FiguraGeometrica quadrado = new Quadrado(4);
            FiguraGeometrica retangulo = new Retangulo(3, 4);

            FiguraGeometrica quadrado2 = new Quadrado(2.2);
            FiguraGeometrica retangulo2 = new Retangulo(2.2, 3.1);

            // Área das figuras geométricas
            System.out.println("Área das figuras geométricas: \n");
            System.out.printf("Área do círculo: %.2f\n", circulo.getArea());
            System.out.printf("Área do quadrado: %.2f\n", quadrado.getArea());
            System.out.printf("Área do retângulo: %.2f\n", retangulo.getArea());
            System.out.printf("Área do quadrado2: %.2f\n", quadrado2.getArea());
            System.out.printf("Área do retângulo2: %.2f\n\n\n", retangulo2.getArea());

            // Perímetro das figuras geométricas
            System.out.println("Perímetro das figuras geométricas: \n");
            System.out.printf("Perímetro do círculo: %.2f\n", circulo.getPerimetro());
            System.out.printf("Perímetro do quadrado: %.2f\n", quadrado.getPerimetro());
            System.out.printf("Perímetro do retângulo: %.2f\n", retangulo.getPerimetro());
            System.out.printf("Perímetro do quadrado2: %.2f\n", quadrado2.getPerimetro());
            System.out.printf("Perímetro do retângulo2: %.2f\n\n\n", retangulo2.getPerimetro());

            // toString das figuras geométricas
            System.out.println("toString das figuras geométricas: \n");
            System.out.println(circulo.toString());
            System.out.println(quadrado.toString());
            System.out.println(retangulo.toString());
            System.out.println(quadrado2.toString());
            System.out.println(retangulo2.toString());

            /*
            FiguraGeometrica circuloFail = new Circulo(-2);
            System.out.printf("Área do círculoFail: %.2f\n", circuloFail.getArea());
            System.out.printf("Perímetro do círculo: %.2f\n",
            circuloFail.getPerimetro()); System.out.println(circuloFail.toString());
             */

        } catch (ExceptionValorNegativoOuZero exceptionValorNegativo) {
            exceptionValorNegativo.printStackTrace();
        }

    }
}
