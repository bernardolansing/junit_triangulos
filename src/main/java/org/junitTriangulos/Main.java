package org.junitTriangulos;

import java.util.Scanner;

public class Main {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Entre com três medidas de lado.");
		final int[] lados = receberInput();
		final int a = lados[0];
		final int b = lados[1];
		final int c = lados[2];

		Triangulo t = new Triangulo(a, b, c);
		t.log();
	}

	private static int[] receberInput() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();

		return new int[] {a, b, c};
	}

}