package game;

import java.util.Scanner;

public class Main {
	/**
	 * Scanner activado
	 */
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		//POR AHORA ESTO ES PARA PROBAR LO QUE ESTAMOS HACIENDO EN LA CLASE MEMORY
		int[][] solucion = Memory.solucion;
		
	 Memory.generaSolucion();
		
		for (int[] fila : solucion) {
			for (int numero : fila) {
				System.out.print(numero + " ");
			}
			System.out.println();
		}
		
		
		
}
}
