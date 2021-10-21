package tests;

import models.FiguraGeometrica;
import controller.FabricaFiguraGeometrica;
import exceptions.ExceptionValorNegativoOuZero;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Testes {
    
    static FiguraGeometrica circulo;
    static FiguraGeometrica quadrado;
    static FiguraGeometrica triangulo;
    static FiguraGeometrica circuloException;
    static FiguraGeometrica quadradoException;
    static FiguraGeometrica trianguloException;

    @BeforeAll
    public static void setUp() throws ExceptionValorNegativoOuZero {
        circulo = FabricaFiguraGeometrica.getCirculo(3);
        quadrado = FabricaFiguraGeometrica.getQuadrado(2);
        triangulo = FabricaFiguraGeometrica.getTriangulo(18, 24, 30);
    }

    @Test
    public void testException() {
        assertThrows(ExceptionValorNegativoOuZero.class, () -> {
            circuloException = FabricaFiguraGeometrica.getCirculo(-2);
            quadradoException = FabricaFiguraGeometrica.getQuadrado(-1);
            trianguloException = FabricaFiguraGeometrica.getTriangulo(0, -4, 30);

        });
    }

    @Test
    public void testGetAreaCirculo() {
        assertEquals(28.27, circulo.getArea(), 1);
    }

    @Test
    public void testGetPerimetroCirculo() {
        assertEquals(18.85, circulo.getPerimetro(), 1);
    }

    @Test
    public void testGetAreaQuadrado() {
        assertEquals(4.0, quadrado.getArea(), 1);
    }

    @Test
    public void testGetPerimetroQuadrado() {
        assertEquals(8.0, quadrado.getPerimetro(), 1);
    }

    @Test
    public void testGetAreaTriangulo() {
        assertEquals(216.0, triangulo.getArea(), 1);
    }

    @Test
    public void testGetPerimetroTriangulo() {
        assertEquals(72, triangulo.getPerimetro(), 1);
    }

    @Test
    public void testEhEquilatero() throws ExceptionValorNegativoOuZero {
        assertNotNull(FabricaFiguraGeometrica.getTriangulo(7, 7, 7));
    }

    @Test
    public void testEhIsosceles() throws ExceptionValorNegativoOuZero {
        assertNotNull(FabricaFiguraGeometrica.getTriangulo(4, 3, 4));
        
    }

    @Test
    public void testEhRetangulo() throws ExceptionValorNegativoOuZero {
        assertNotNull(FabricaFiguraGeometrica.getTriangulo(18, 24, 30));
    }

    @Test
    public void testEhTriangulo() throws ExceptionValorNegativoOuZero {
        assertNotNull(FabricaFiguraGeometrica.getTriangulo(4, 3, 4));
    }

}
