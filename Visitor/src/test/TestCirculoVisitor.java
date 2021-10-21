package src.test;

import src.models.Circulo;
import src.visitors.VisitorCalcularPerimetro;
import src.visitors.VisitorCalcularArea;
import src.visitors.VisitorMaximizar;
import src.visitors.VisitorDesenhar;
import src.visitors.Visitor;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestCirculoVisitor {
    
    static Circulo circulo;

    static Visitor calcularArea;
    static Visitor desenhar;
    static Visitor calcularPerimetro;
    static Visitor maximizar;


    @BeforeAll
    public static void setUp() {
        
        circulo = new Circulo(5);

        calcularArea = new VisitorCalcularArea();
        desenhar = new VisitorDesenhar();
        calcularPerimetro = new VisitorCalcularPerimetro();
        maximizar = new VisitorMaximizar();
    }

    @Test
    public void testArea() {
        assertEquals(78.5, circulo.aceitarVisita(calcularArea), 1);
    }

    @Test
    public void testPerimetro(){
        assertEquals(31.41, circulo.aceitarVisita(calcularPerimetro),1);
    }

    @Test
    public void testDesenhow(){
        assertEquals(0.0, desenhar.visitarCirculo(circulo));
    }

    @Test
    public void testMaximizar() {

        maximizar.visitarCirculo(circulo);
        assertEquals(10.0, circulo.getRaio()); 
    }
}