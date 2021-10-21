package example;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TriangleTest {

    // Triângulo equilátero: Todos os lados e ângulos são iguais.
    @Test
    public void equilateralTriangleHaveEqualSidesTest() throws Exception { // EQUILÁTERO TESTE
        Triangle triangle = new Triangle(2, 2, 2);
        assertEquals(TriangleKind.EQUILATERAL, triangle.getKind()); // Assert that expected and actual are equal.
    }

    @Test
    public void equilateralTriangleHaveEqualSidesTest2() throws Exception { // EQUILÁTERO TESTE
        Triangle triangle = new Triangle(2, 2, 2);
        assertEquals(TriangleKind.EQUILATERAL, triangle.getKind());
        assertNotEquals(TriangleKind.ISOSCELES, triangle.getKind()); // Assert that expected and actual are not equal.
        assertNotEquals(TriangleKind.SCALENE, triangle.getKind());
        assertDoesNotThrow(() -> { // Assert that execution of the supplied executable does not throw any kind of
                                   // exception.
            triangle.getKind();
        });
    }

    // Triângulo isósceles: Dois lados iguais e dois ângulos iguais.
    @Test
    public void isoscelesTriangleHaveTwoEqualSidesTest() throws Exception { // ISOSCELES TESTE 1
        Triangle triangle = new Triangle(2, 2, 3);
        assertEquals(TriangleKind.ISOSCELES, triangle.getKind());
    }

    @Test
    public void isoscelesTriangleHaveTwoEqualSidesTest2() throws Exception { // ISOSCELES TESTE 3
        Triangle triangle = new Triangle(3, 2, 2);
        assertEquals(TriangleKind.ISOSCELES, triangle.getKind());
        assertDoesNotThrow(() -> {
            triangle.getKind();
        });
    }

    @Test
    public void isoscelesTriangleHaveTwoEqualSidesTest3() throws Exception { // ISOSCELES TESTE 4
        Triangle triangle = new Triangle(2, 3, 2);
        assertEquals(TriangleKind.ISOSCELES, triangle.getKind());
        assertNotEquals(TriangleKind.EQUILATERAL, triangle.getKind());
        assertNotEquals(TriangleKind.SCALENE, triangle.getKind());
    }

    // Triângulo escaleno: Todos os lados e ângulos são diferentes.
    @Test
    public void scaleneTriangleHasNoEqualSidesTest() throws Exception { // ESCALENO TESTE
        Triangle triangle = new Triangle(2, 9, 10);
        assertEquals(TriangleKind.SCALENE, triangle.getKind());
    }

    @Test
    public void scaleneTriangleHasNoEqualSidesTest2() throws Exception { // ESCALENO TESTE 2
        Triangle triangle = new Triangle(7, 8, 5);

        assertEquals(TriangleKind.SCALENE, triangle.getKind());
        assertNotEquals(TriangleKind.EQUILATERAL, triangle.getKind());
        assertNotEquals(TriangleKind.EQUILATERAL, triangle.getKind());
    }

    @Test
    public void scaleneTriangleHasNoEqualSidesTest3() throws Exception { // ESCALENO TESTE 3
        Triangle triangle = new Triangle(11, 4, 8);
        assertEquals(TriangleKind.SCALENE, triangle.getKind());
        assertDoesNotThrow(() -> {
            triangle.getKind();
        });
    }

    // JUnit 4 : @TEST (EXPECTED = EXCEPTION.CLASS) (expected = TriangleException.class)
    // JUnit 5 : Assertions.assertThrows(Exception.class, () -> ....... );
    // Assert that execution of the supplied executable throws an exception
    // of the expectedType and return the exception
    
    @Test
    public void zeroSideTest() throws Exception { // Há um numero zero
        assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(0, 2, 10);
            triangle.getKind();
        });
    }

    @Test
    public void allZeroSideTest() throws Exception { // Numeros todos são zeros
        assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(0, 0, 0);
            triangle.getKind();
        });
    }

    @Test
    public void negativeSideTest() throws Exception { // Há um numero negativo
        assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(3, -2, 9);
            triangle.getKind();
        });
    }

    @Test
    public void allNegativeSideTest() throws Exception { // Numeros todos são negativos
        assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(-2, -2, -2);
            triangle.getKind();
        });
    }

    @Test
    public void violatesTriangleInequalityTest1() throws Exception { // Soma dos dois lados igual a terceiro
        assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(5, 11, 6);
            triangle.getKind();
        });
    }

    @Test
    public void violatesTriangleInequalityTest2() throws Exception { // Soma dos dois lados menor que a terceiro
        assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(5, 13, 6);
            triangle.getKind();
        });
    }

}