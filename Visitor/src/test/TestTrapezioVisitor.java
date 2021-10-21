package src.test;

import src.models.Trapezio;
import src.visitors.VisitorCalcularPerimetro;
import src.visitors.VisitorCalcularArea;
import src.visitors.VisitorMaximizar;
import src.visitors.VisitorDesenhar;
import src.visitors.Visitor;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestTrapezioVisitor {
    static Trapezio trapezio;

    static Visitor calcularArea;
    static Visitor desenhar;
    static Visitor calcularPerimetro;
    static Visitor maximizar;


    @BeforeAll
    public static void setUp() {
        
        trapezio = new Trapezio(20, 10, 15);

        calcularArea = new VisitorCalcularArea();
        desenhar = new VisitorDesenhar();
        calcularPerimetro = new VisitorCalcularPerimetro();
        maximizar = new VisitorMaximizar();
    }

    @Test
    public void testArea() {
        assertEquals(225, trapezio.aceitarVisita(calcularArea));
    }

    @Test
    public void testPerimetro(){
        assertEquals(60, trapezio.aceitarVisita(calcularPerimetro));
    }

    @Test
    public void testDesenho(){
        assertEquals(0.0, desenhar.visitarTrapezio(trapezio));
    }

    @Test
    public void testMaximizar() {
        maximizar.visitarTrapezio(trapezio);
        assertEquals(40.0, trapezio.getBaseMaior()); 
        assertEquals(20.0, trapezio.getBaseMenor());
        assertEquals(30.0, trapezio.getAltura()); 
    }
}