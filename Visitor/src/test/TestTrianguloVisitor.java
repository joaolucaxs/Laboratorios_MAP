package src.test;

import src.models.Triangulo;
import src.visitors.VisitorCalcularPerimetro;
import src.visitors.VisitorCalcularArea;
import src.visitors.VisitorMaximizar;
import src.visitors.VisitorDesenhar;
import src.visitors.Visitor;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestTrianguloVisitor {
    static Triangulo triangulo;

    static Visitor calcularArea;
    static Visitor desenhar;
    static Visitor calcularPerimetro;
    static Visitor maximizar;


    @BeforeAll
    public static void setUp() {
        
        triangulo = new Triangulo(10, 10, 12);

        calcularArea = new VisitorCalcularArea();
        desenhar = new VisitorDesenhar();
        calcularPerimetro = new VisitorCalcularPerimetro();
        maximizar = new VisitorMaximizar();
    }

    @Test
    public void testArea() {
        assertEquals(48, triangulo.aceitarVisita(calcularArea));
    }

    @Test
    public void testPerimetro(){
        assertEquals(32, triangulo.aceitarVisita(calcularPerimetro));
    }

    @Test
    public void testDesenho(){
        assertEquals(0.0, desenhar.visitarTriangulo(triangulo));
    }

    @Test
    public void testMaximizar() {
        maximizar.visitarTriangulo(triangulo);
        assertEquals(20.0, triangulo.getA()); 
        assertEquals(20.0, triangulo.getB());
        assertEquals(24.0, triangulo.getC()); 
    }
}