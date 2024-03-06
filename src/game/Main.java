package game;

import java.util.Scanner;

public class Main {
	/**
	 * Scanner activado
	 */
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int[][] tableroDejuego = Memory.getTableroDeJuego();

		// Primera posición seleccionada por el jugador
		int primeraPosicionSeleccionada;
		// Segunda posición seleccionada por el jugador
		int segundaPosicionSeleccionada;

		boolean parejaIgual;

		// Activamos el Scanner
		Scanner sc = new Scanner(System.in);

		// Llamamos a la función generaSolucion() para asignar los valores aleatorios de
		// la tabla solucion
		Memory.generaSolucion();

		while (!Memory.finDeJuego()) {
			
			primeraPosicionSeleccionada = -1;
			segundaPosicionSeleccionada = -1;
			
			Memory.muestraTableroDeJuego();

			while (primeraPosicionSeleccionada < 0
					|| primeraPosicionSeleccionada / 10 >= Memory.getTableroDeJuego().length
					|| primeraPosicionSeleccionada % 10 >= Memory.getTableroDeJuego()[0].length
					|| Memory.getTableroDeJuego()[primeraPosicionSeleccionada / 10][primeraPosicionSeleccionada
							% 10] != 0) {
				// Le pedimos al usuario la primera posición
				System.out.println("Elija una posición");
				// Y la asignamos
				primeraPosicionSeleccionada = sc.nextInt();
			}
			
			Memory.descubrirCasillaTablero(primeraPosicionSeleccionada);
			
			Memory.muestraTableroDeJuego();
			
			System.out.println("FILA " + primeraPosicionSeleccionada / 10 + ", COLUMNA "
					+ primeraPosicionSeleccionada % 10 + " = "
					+ Memory.getTableroDeJuego()[primeraPosicionSeleccionada / 10][primeraPosicionSeleccionada % 10]);

		
			while (segundaPosicionSeleccionada < 0
					|| segundaPosicionSeleccionada / 10 >= Memory.getTableroDeJuego().length
					|| segundaPosicionSeleccionada % 10 >= Memory.getTableroDeJuego()[0].length
					|| Memory.getTableroDeJuego()[segundaPosicionSeleccionada / 10][segundaPosicionSeleccionada
							% 10] != 0) {
				// Le pedimos al usuario la segunda posición
				System.out.println("Elija otra posición");
				// Y la asignamos
				segundaPosicionSeleccionada = sc.nextInt();
			}
			
			Memory.descubrirCasillaTablero(segundaPosicionSeleccionada);

			Memory.muestraTableroDeJuego();
			
			System.out.println("FILA " + segundaPosicionSeleccionada / 10 + ", COLUMNA "
					+ segundaPosicionSeleccionada % 10 + " = "
					+ Memory.getTableroDeJuego()[segundaPosicionSeleccionada / 10][segundaPosicionSeleccionada % 10]);

			parejaIgual = Memory.comprobarPareja(primeraPosicionSeleccionada, segundaPosicionSeleccionada);

			System.out.println(parejaIgual ? "Genial, has encontrado una pareja" : "Fallo, son distintos");

			sc.nextLine();
			System.out.println("Pulsa intro para continuar");
			sc.nextLine();
		}

		sc.close();
	}
}
