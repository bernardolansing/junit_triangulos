package org.junitTriangulos;

import static org.junitTriangulos.Tipos.*;

public class Triangulo {
	private int a, b, c;
	private char tipo;

	public Triangulo(int lado1, int lado2, int lado3) {
		a = lado1; b = lado2; c = lado3;
		atualizarTipo();
	}

	private void atualizarTipo() {
		// este programa não aceitará lados de medida nula ou negativa
		if (a <= 0 && b <= 0 && c <= 0) {
			tipo = INVALIDO;
			return;
		}

		// nenhum lado pode ser maior que os outros dois somados
		if (a >= b + c || b >= a + c || c >= a + b) {
			tipo = INVALIDO;
			return;
		}

		// todos os lados devem ter a mesma medida
		if (a == b && b == c) {
			tipo = EQUILATERO;
			return;
		}

		// todos os lados devem ter medidas diferentes
		if (a != b && a != c && b != c) {
			tipo = ESCALENO;
			return;
		}

		// apenas dois lados podem ter medidas iguais, o terceiro deve ser diferente
		tipo = ISOSCELES;
	}

	public void alterarLado(char lado, int medida) throws IllegalArgumentException {
		if (lado < 1 || lado > 3)
			throw new IllegalArgumentException("O lado especificado é inválido.");

		switch (lado) {
			case 1 -> a = medida;
			case 2 -> b = medida;
			case 3 -> c = medida;
		}

		atualizarTipo();
	}

	public boolean isInvalido() {
		return (tipo == INVALIDO);
	}

	public boolean isEquilatero() {
		return (tipo == EQUILATERO);
	}

	public boolean isIsosceles() {
		return (tipo == ISOSCELES);
	}

	public boolean isEscaleno() {
		return (tipo == ESCALENO);
	}

	public char tipo() {
		return tipo;
	}

	private String nomeDoTipo() {
		return switch (tipo) {
			case INVALIDO -> "Inválido";
			case EQUILATERO -> "equilátero";
			case ISOSCELES -> "isósceles";
			case ESCALENO -> "escaleno";
			default -> throw new RuntimeException("Erro interno de gerenciamento de tipos.");
		};
	}

	public void log() {
		if (tipo == INVALIDO) {
			System.out.printf("Triângulo inválido. Os lados %d, %d e %d não formam um triângulo.\n",a, b, c);
			return;
		}

		System.out.printf("Triângulo %s de lados %d, %d e %d.\n", nomeDoTipo(), a, b, c);
	}
}
