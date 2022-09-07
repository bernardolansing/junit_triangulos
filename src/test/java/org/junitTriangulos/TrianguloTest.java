package org.junitTriangulos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class TrianguloTest {
	Triangulo tEquilatero = new Triangulo(5, 5, 5);
	Triangulo tIsosceles = new Triangulo(7, 7, 11);
	Triangulo tEscaleno = new Triangulo(3, 4, 5);

	@Test
	@DisplayName("Triângulo escaleno válido")
	public void testarTrianguloEscalenoValido() {
		assertTrue(tEscaleno.isEscaleno());
		assertFalse(tEquilatero.isEscaleno());
		assertFalse(tIsosceles.isEscaleno());
	}

	@Test
	@DisplayName("Triângulo isósceles válido")
	public void testarTrianguloIsoscelesValido() {
		assertTrue(tIsosceles.isIsosceles());
		assertFalse(tEquilatero.isIsosceles());
		assertFalse(tEscaleno.isIsosceles());
	}

	@Test
	@DisplayName("Triângulo equilátero válido")
	public void testarTrianguloEquilateroValido() {
		assertTrue(tEquilatero.isEquilatero());
		assertFalse(tIsosceles.isEquilatero());
		assertFalse(tEscaleno.isEquilatero());
	}

	@Test
	@DisplayName("Triângulo isósceles não importando a ordem das medidas")
	public void testarTrianguloIsoscelesComVariasOrdens() {
		Triangulo t1 = new Triangulo(12, 12, 15);
		Triangulo t2 = new Triangulo(12, 15, 12);
		Triangulo t3 = new Triangulo(15, 12, 12);

		assertTrue(t1.isIsosceles());
		assertTrue(t2.isIsosceles());
		assertTrue(t3.isIsosceles());
	}

	@Test
	@DisplayName("Triângulo com lados nulos")
	public void testarTrianguloLadosNulos() {
		Triangulo tTodoNulo = new Triangulo(0, 0, 0);
		assertTrue(tTodoNulo.isInvalido());

		Triangulo tUmLadoNulo = new Triangulo(3, 4, 0);
		assertTrue(tUmLadoNulo.isInvalido());
	}

	@Test
	@DisplayName("Triângulo com lados negativos")
	public void testarTrianguloLadosNegativos() {
		Triangulo tNeg1 = new Triangulo(-7, -5, -6);
		Triangulo tNeg2 = new Triangulo(11, 16, -20);

		assertTrue(tNeg1.isInvalido());
		assertTrue(tNeg2.isInvalido());
	}

	@Test
	@DisplayName("Triângulo cuja soma dos menores lados dá igual ao maior lado")
	public void testarTrianguloComSomaMenoresLadosIgualMaiorLado() {
		Triangulo t1 = new Triangulo(7, 7, 14);
		Triangulo t2 = new Triangulo(7, 14, 7);
		Triangulo t3 = new Triangulo(14, 7, 7);

		assertTrue(t1.isInvalido());
		assertTrue(t2.isInvalido());
		assertTrue(t3.isInvalido());
	}

	@Test
	@DisplayName("Triângulo cuja soma dos menores lados dá menos do que o maior lado")
	public void testarTrianguloComSomaMenoresLadosMenorQueMaiorLado() {
		Triangulo t1 = new Triangulo(7, 7, 21);
		Triangulo t2 = new Triangulo(7, 21, 7);
		Triangulo t3 = new Triangulo(21, 7, 7);

		assertTrue(t1.isInvalido());
		assertTrue(t2.isInvalido());
		assertTrue(t3.isInvalido());
	}
}