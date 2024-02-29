package game;

import java.util.Scanner;

public class Main {
	/**
	 * Scanner activado
	 */
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// POR AHORA ESTO ES PARA PROBAR LO QUE ESTAMOS HACIENDO EN LA CLASE MEMORY
		int[][] solucion = Memory.solucion;

		Memory.generaSolucion();

		for (int[] fila : solucion) {
			for (int numero : fila) {
				System.out.print(numero + " ");
			}
			System.out.println();
		}

		int numEncontrar = 5;

		int posX = -1;
		int posY = -1;
		int i = 0;

		while (i < solucion.length && posX == -1) {
			int j = 0;
			while (j < solucion[i].length && posY == -1) {
				if (solucion[i][j] == numEncontrar) {
					posX = i;
					posY = j;
				}
				j++;

			}
			i++;
		}
		
		System.out.println(posX + " " + posY);

	}
}
