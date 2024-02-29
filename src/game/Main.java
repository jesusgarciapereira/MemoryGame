package game;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
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
