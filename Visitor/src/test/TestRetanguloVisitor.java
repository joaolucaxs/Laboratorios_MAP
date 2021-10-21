package src.test;

import src.models.Retangulo;
import src.visitors.VisitorCalcularPerimetro;
import src.visitors.VisitorCalcularArea;
import src.visitors.VisitorMaximizar;
import src.visitors.VisitorDesenhar;
import src.visitors.Visitor;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestRetanguloVisitor {
    static Retangulo retangulo;

    static Visitor calcularArea;
    static Visitor desenhar;
    static Visitor calcularPerimetro;
    static Visitor maximizar;


    @BeforeAll
    public static void setUp() {
        
        retangulo = new Retangulo(40, 20);

        calcularArea = new VisitorCalcularArea();
        desenhar = new VisitorDesenhar();
        calcularPerimetro = new VisitorCalcularPerimetro();
        maximizar = new VisitorMaximizar();
    }

    @Test
    public void testArea() {
        assertEquals(120, retangulo.aceitarVisita(calcularArea));
    }

    @Test
    public void testPerimetro(){
        assertEquals(120, retangulo.aceitarVisita(calcularPerimetro),1);
    }

    @Test
    public void testDesenhow(){
        assertEquals(0.0, desenhar.visitarRetangulo(retangulo));
    }

    @Test
    public void testMaximizar() {
        maximizar.visitarRetangulo(retangulo);
        assertEquals(80.0, retangulo.getBase()); 
        assertEquals(40.0, retangulo.getAltura()); 
    }
}