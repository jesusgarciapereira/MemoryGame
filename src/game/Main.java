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
		int primeraPosicionSeleccionada = -1;
		// Segunda posición seleccionada por el jugador
		int segundaPosicionSeleccionada;

		boolean parejaIgual;

		// Activamos el Scanner
		Scanner sc = new Scanner(System.in);

		// Llamamos a la función generaSolucion() para asignar los valores aleatorios de
		// la tabla solucion
		Memory.generaSolucion();

		while (!Memory.finDeJuego()) {
			Memory.muestraTableroDeJuego();
//
//			while (primeraPosicionSeleccionada == -1
//					|| Memory.getTableroDeJuego()[primeraPosicionSeleccionada / 10][primeraPosicionSeleccionada
//							% 10] != 0) {
				// Le pedimos al usuario la primera posición
				System.out.println("Elija una posición");
			// Y la asignamos
			primeraPosicionSeleccionada = sc.nextInt();
			//}
			Memory.descubrirCasillaTablero(primeraPosicionSeleccionada);

			Memory.muestraTableroDeJuego();

			// Le pedimos al usuario la segunda posición
			System.out.println("Elija otra posición");
			// Y la asignamos
			segundaPosicionSeleccionada = sc.nextInt();

			Memory.descubrirCasillaTablero(segundaPosicionSeleccionada);

			Memory.muestraTableroDeJuego();

			parejaIgual = Memory.comprobarPareja(primeraPosicionSeleccionada, segundaPosicionSeleccionada);

			System.out.println(parejaIgual ? "Genial, has encontrado una pareja" : "Fallo, son distintas");

			sc.nextLine();
			System.out.println("Pulsa intro para continuar");
			sc.nextLine();
		}

		sc.close();
	}
}
