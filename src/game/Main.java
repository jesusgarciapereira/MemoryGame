
package game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	/**
	 * Scanner activado
	 */
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int[][] tableroDejuego;

		// Primera fila seleccionada por el jugador
		int primeraFila;
		// Primera columna seleccionada por el jugador
		int primeraColumna;
		// Segunda fila seleccionada por el jugador
		int segundaFila;
		// Segunda columna seleccionada por el jugador
		int segundaColumna;

		String dificultad = "";
		boolean parejaIgual;

		while (!dificultad.toLowerCase().equals("easy") && !dificultad.toLowerCase().equals("medium")
				&& !dificultad.toLowerCase().equals("hard")) {
			System.out.println("Elija dificultad: easy, medium or hard");
			dificultad = sc.nextLine();
		}

		Memory.asignarDificultad(dificultad.toLowerCase());
		
		tableroDejuego = Memory.getTableroDeJuego();

		// Llamamos a la función generaSolucion() para asignar los valores aleatorios de
		// la tabla solucion
		Memory.generaSolucion();

		while (!Memory.finDeJuego()) { // empieza

			System.out.println("Pulsa intro para continuar");
			sc.nextLine();

			Memory.muestraTableroDeJuego();

			do {
				primeraFila = -1;
				primeraColumna = -1;
				while (primeraFila < 0 || primeraFila >= Memory.getTamTablero()) {
					try {
						// Le pedimos al usuario la primera posición
						System.out.println("Elija una fila");
						// Y la asignamos
						primeraFila = sc.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("Sólo se admiten números enteros");
					} finally {
						sc.nextLine();
					}

				}

				while (primeraColumna < 0 || primeraColumna >= Memory.getTamTablero()) {
					try {
						// Le pedimos al usuario la primera posición
						System.out.println("Elija una columna");
						// Y la asignamos
						primeraColumna = sc.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("Solo se admiten números enteros");
					} finally {
						sc.nextLine();
					}

				}

				if (Memory.getTableroDeJuego()[primeraFila][primeraColumna] != 0) {
					System.out.println("Esa posición ya está descubierta");
				}

			} while (Memory.getTableroDeJuego()[primeraFila][primeraColumna] != 0);

			Memory.descubrirCasillaTablero(primeraFila, primeraColumna);

			Memory.muestraTableroDeJuego();

			System.out.println("FILA " + primeraFila + ", COLUMNA " + primeraColumna + " = "
					+ tableroDejuego[primeraFila][primeraColumna]);

			do {
				segundaFila = -1;
				segundaColumna = -1;
				while (segundaFila < 0 || segundaFila >= Memory.getTamTablero()) {
					try {
						// Le pedimos al usuario la segunda posición
						System.out.println("Elija una fila");
						// Y la asignamos
						segundaFila = sc.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("Sólo se admiten números enteros");
					} finally {
						sc.nextLine();
					}
				}

				while (segundaColumna < 0 || segundaColumna >= Memory.getTamTablero()) {
					try {
						// Le pedimos al usuario la primera posición
						System.out.println("Elija una columna");
						// Y la asignamos
						segundaColumna = sc.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("Solo se admiten números enteros");
					} finally {
						sc.nextLine();
					}

				}
				if (Memory.getTableroDeJuego()[segundaFila][segundaColumna] != 0) {
					System.out.println("Esa posición ya está descubierta");
				}
			} while (Memory.getTableroDeJuego()[segundaFila][segundaColumna] != 0);

			Memory.descubrirCasillaTablero(segundaFila, segundaColumna);

			Memory.muestraTableroDeJuego();

			System.out.println("FILA " + segundaFila + ", COLUMNA " + segundaColumna + " = "
					+ tableroDejuego[segundaFila][segundaColumna]);

			parejaIgual = Memory.comprobarPareja(primeraFila, primeraColumna, segundaFila, segundaColumna);

			System.out.println(parejaIgual ? "Genial, has encontrado una pareja" : "Fallo, son distintos");

		} // termina

		System.out.println("ENHORABUENA, has completado el juego");

		sc.close();
	}

}
