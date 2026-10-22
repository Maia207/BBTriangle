package triangle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    @Test
    @DisplayName("TC_001: Triangulo valido nao deve ser impossivel")
    void testValidTriangleIsNotImpossible() {

        Triangle t = new Triangle(3,4,5);
        assertFalse(t.isImpossible());
    }

    @Test
    @DisplayName("TC_002, TC_003, TC_004: Lado com valor 0 deve ser impossivel")
    void testZeroSideIsImpossible() {

        assertTrue(new Triangle(0,4,5).isImpossible());
        assertTrue(new Triangle(4,0,5).isImpossible());
        assertTrue(new Triangle(4,5,0).isImpossible());
    }

    @Test
    @DisplayName("TC_005: Lado negativo torna triangulo impossivel")
    void testNegativeSideIsImpossible() {

        assertTrue(new Triangle(-1,2,3).isImpossible());
    }

    @Test
    @DisplayName("TC_006, TC_007, TC_008: Soma de dois lados igual terceiro deve ser impossivel")
    void testSumEqualsThirdSideIsImpossible() {

        assertTrue(new Triangle(3, 4, 7).isImpossible(), "a + b == c");
        assertTrue(new Triangle(3, 7, 4).isImpossible(), "a + c == b");
        assertTrue(new Triangle(7, 3, 4).isImpossible(), "b + c == a");
    }

    @Test
    @DisplayName("TC_009, TC_010, TC_011: Soma de dois lados menor que terceiro deve ser impossivel")
    void testSumLessThanThirdSideIsImpossible() {

        assertTrue(new Triangle(3, 4, 8).isImpossible(), "a + b < c");
        assertTrue(new Triangle(3, 8, 4).isImpossible(), "a + c < b");
        assertTrue(new Triangle(8, 3, 4).isImpossible(), "b + c < a");
    }

    @Test
    @DisplayName("TC_012, TC_013, TC_014: Soma de dois lados maior que terceiro NAO deve ser impossivel")
    void testSumMoreThanThirdSideIsImpossible() {

        assertFalse(new Triangle(3, 4, 6).isImpossible(), "a + b > c");
        assertFalse(new Triangle(3, 6, 4).isImpossible(), "a + c > b");
        assertFalse(new Triangle(6, 3, 4).isImpossible(), "b + c > a");
    }

    @Test
    @DisplayName("TC_015: Triangulo equilatero com 3 lados iguais")
    void testClassifyEquilateral() {

        Triangle t = new Triangle(3,3,3);
        assertEquals("Equilateral", t.classify());
    }

    @Test
    @DisplayName("TC_016, TC_017, TC_18: Triangulo isosceles com 2 lados iguais")
    void testClassifyIsosceles() {

        assertEquals("Isosceles", new Triangle(2, 2, 1).classify(), "s1 == s2");
        assertEquals("Isosceles", new Triangle(5, 3, 5).classify(), "s1 == s3");
        assertEquals("Isosceles", new Triangle(3, 5, 5).classify(), "s2 == s3");
    }

    @Test
    @DisplayName("TC_019, TC_020, TC_021: Triangulo retangulo com um angulo reto")
    void testClassifyRightAngled() {

        assertEquals("right-angled", new Triangle(3, 4, 5).classify(), "Hipotenusa em s3");
        assertEquals("right-angled", new Triangle(3, 5, 4).classify(), "Hipotenusa em s2");
        assertEquals("right-angled", new Triangle(5, 3, 4).classify(), "Hipotenusa em s1");
    }

    @Test
    @DisplayName("TC_022: Triangulo escaleno com todos os lados diferentes e sem angulo reto")
    void testClassifyScalene() {

        Triangle t = new Triangle(3, 4, 6);
        assertEquals("scalene", t.classify());
    }

    @Test
    @DisplayName("TC_023 ate TC_030: Lados nulos ou negativos devem retornar impossible")
    void testClassifyZeroOrNegativeSides() {

        assertEquals("impossible", new Triangle(0, 4, 6).classify());
        assertEquals("impossible", new Triangle(4, 0, 6).classify());
        assertEquals("impossible", new Triangle(6, 4, 0).classify());

        assertEquals("impossible", new Triangle(-1, 4, 6).classify());
        assertEquals("impossible", new Triangle(3, 4, -1).classify());
        assertEquals("impossible", new Triangle(3, -1, 6).classify());

        assertEquals("impossible", new Triangle(0, 0, 0).classify());
        assertEquals("impossible", new Triangle(-1, -1, -1).classify());
    }

    @Test
    @DisplayName("TC_031 ate TC_036: Desigualdade triangular violada")
    void testClassifyViolatesTriangleInequality() {

        assertEquals("impossible", new Triangle(3, 4, 7).classify(), "a + b = c");
        assertEquals("impossible", new Triangle(3, 7, 4).classify(), "a + c = b");
        assertEquals("impossible", new Triangle(7, 4, 3).classify(), "c + b = a");

        assertEquals("impossible", new Triangle(3, 4, 8).classify(),"a + b < c");
        assertEquals("impossible", new Triangle(3, 8, 4).classify(),"a + c < b");
        assertEquals("impossible", new Triangle(8, 4, 3).classify(),"c + b < a");

    }




}
