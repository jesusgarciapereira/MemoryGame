
package game;

import java.util.InputMismatchException;
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

		while (!Memory.finDeJuego()) { // empieza

			primeraPosicionSeleccionada = -1;
			segundaPosicionSeleccionada = -1;

			System.out.println("Pulsa intro para continuar");
			sc.nextLine();

			Memory.muestraTableroDeJuego();

			while (!Memory.numElegible(primeraPosicionSeleccionada)) {
				try {
					// Le pedimos al usuario la primera posición
					System.out.println("Elija una posición");
					// Y la asignamos
					primeraPosicionSeleccionada = sc.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Solo se admiten numeros");
				} finally {
					sc.nextLine();
				}

			}

			Memory.descubrirCasillaTablero(primeraPosicionSeleccionada);

			Memory.muestraTableroDeJuego();

			System.out.println(
					"FILA " + primeraPosicionSeleccionada / 10 + ", COLUMNA " + primeraPosicionSeleccionada % 10 + " = "
							+ tableroDejuego[primeraPosicionSeleccionada / 10][primeraPosicionSeleccionada % 10]);

			while (!Memory.numElegible(segundaPosicionSeleccionada)) {
				try {
					// Le pedimos al usuario la segunda posición
					System.out.println("Elija otra posición");
					// Y la asignamos
					segundaPosicionSeleccionada = sc.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Solo se admiten numeros");
				} finally {
					sc.nextLine();
				}
			}

			Memory.descubrirCasillaTablero(segundaPosicionSeleccionada);

			Memory.muestraTableroDeJuego();

			System.out.println(
					"FILA " + segundaPosicionSeleccionada / 10 + ", COLUMNA " + segundaPosicionSeleccionada % 10 + " = "
							+ tableroDejuego[segundaPosicionSeleccionada / 10][segundaPosicionSeleccionada % 10]);

			parejaIgual = Memory.comprobarPareja(primeraPosicionSeleccionada, segundaPosicionSeleccionada);

			System.out.println(parejaIgual ? "Genial, has encontrado una pareja" : "Fallo, son distintos");

			sc.nextLine();

		} // termina

		System.out.println("ENHORABUENA, has completado el juego");

		sc.close();
	}

}
