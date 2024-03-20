
package game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	/**
	 * Scanner activado
	 */
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// Tamaño del tablero
		int tamTablero;
		// Tablero de juego que se muestra en pantalla
		int[][] tableroDejuego;
		// Dificultad seleccionada por el usuario
		String dificultad = "";
		// Variable que determina si una pareja de números son iguales
		boolean parejaIgual;

		// Primera fila seleccionada por el jugador
		int primeraFila;
		// Primera columna seleccionada por el jugador
		int primeraColumna;
		// Segunda fila seleccionada por el jugador
		int segundaFila;
		// Segunda columna seleccionada por el jugador
		int segundaColumna;

		// Mientras la dificultad no sea ni easy, ni medium ni hard
		while (!dificultad.toLowerCase().equals("easy") && !dificultad.toLowerCase().equals("medium")
				&& !dificultad.toLowerCase().equals("hard")) {
			// Le pedimos al usuario una dificultad
			System.out.println("Elija dificultad: easy, medium or hard");
			// Y la asignamos
			dificultad = sc.nextLine();
		}
		
		// Una vez seleccionada la dificultad, inicializamos las propiedades
		Memory.inicializar(dificultad.toLowerCase());
	
		// Asignamos los valores elegidos a las variables tamTablero y tableroDeJuego
		tamTablero = Memory.getTamTablero();
		tableroDejuego = Memory.getTableroDeJuego();

		// Asignamos los valores de la propiedad del tablero solución
		Memory.generaSolucion();

		// Mientras el juego no haya terminado
		while (!Memory.finDeJuego()) { 

			System.out.println("Pulsa intro para continuar");
			sc.nextLine();

			// Mostramos el tablero de juego
			Memory.muestraTableroDeJuego();

			do {
				// Inicializamos la fila y la columna del primer número
				primeraFila = -1;
				primeraColumna = -1;
				
				// Mientras la primera fila no esté entre los números elegibles
				while (primeraFila < 0 || primeraFila >= tamTablero) {
					try {
						// Le pedimos al usuario la primera fila
						System.out.println("Elija una fila");
						// Y la asignamos
						primeraFila = sc.nextInt();
						// Si no se escribe un número entero
					} catch (InputMismatchException e) {
						// Muestra este mensaje
						System.out.println("Sólo se admiten números enteros");
					} finally {
						// Siempre limpiamos el buffer
						sc.nextLine();
					}

				}

				// Mientras la primera columna no esté entre los números elegibles
				while (primeraColumna < 0 || primeraColumna >= tamTablero) {
					try {
						// Le pedimos al usuario la primera columna
						System.out.println("Elija una columna");
						// Y la asignamos
						primeraColumna = sc.nextInt();
						// Si no se escribe un número entero
					} catch (InputMismatchException e) {
						// Muestra este mensaje
						System.out.println("Solo se admiten números enteros");
					} finally {
						// Siempre limpiamos el buffer
						sc.nextLine();
					}

				}

				// Si la posición elegida corresponde a un número distinto de 0
				if (tableroDejuego[primeraFila][primeraColumna] != 0) {
					// Es porque dicha posición ya está descubierta, lo indicará
					System.out.println("Esa posición ya está descubierta");
				}

				// Mientras la posición indicada no sea distinto de 0, pedirá de nuevo la fila y la columna
			} while (tableroDejuego[primeraFila][primeraColumna] != 0);

			// Una vez elegidos los valores correctos, descubrimos el número oculto
			Memory.descubrirCasillaTablero(primeraFila, primeraColumna);

			// Mostramos de nuevo el tablero de juego con el número que se acaba de descubrir
			Memory.muestraTableroDeJuego();

			// Mostramos un mensaje indicando la opción elegida
			System.out.println("FILA " + primeraFila + ", COLUMNA " + primeraColumna + " = "
					+ tableroDejuego[primeraFila][primeraColumna]);

			do {
				// Inicializamos la fila y la columna del segundo número
				segundaFila = -1;
				segundaColumna = -1;
				
				// Mientras la segunda fila no esté entre los números elegibles
				while (segundaFila < 0 || segundaFila >= tamTablero) {
					try {
						// Le pedimos al usuario la segunda fila
						System.out.println("Elija una fila");
						// Y la asignamos
						segundaFila = sc.nextInt();
						// Si no se escribe un número entero
					} catch (InputMismatchException e) {
						// Muestra este mensaje
						System.out.println("Sólo se admiten números enteros");
					} finally {
						// Siempre limpiamos el buffer
						sc.nextLine();
					}
				}

				// Mientras la segunda columna no esté entre los números elegibles
				while (segundaColumna < 0 || segundaColumna >= tamTablero) {
					try {
						// Le pedimos al usuario la primera columna
						System.out.println("Elija una columna");
						// Y la asignamos
						segundaColumna = sc.nextInt();
						// Si no se escribe un número entero
					} catch (InputMismatchException e) {
						// Muestra este mensaje
						System.out.println("Solo se admiten números enteros");
					} finally {
						// Siempre limpiamos el buffer
						sc.nextLine();
					}

				}
				
				// Si la posición elegida corresponde a un número distinto de 0
				if (tableroDejuego[segundaFila][segundaColumna] != 0) {
					// Es porque dicha posición ya está descubierta, lo indicará
					System.out.println("Esa posición ya está descubierta");
				}
				
				// Mientras la posición indicada no sea distinto de 0, pedirá de nuevo la fila y la columna
			} while (tableroDejuego[segundaFila][segundaColumna] != 0);

			// Una vez elegidos los valores correctos, descubrimos el número oculto
			Memory.descubrirCasillaTablero(segundaFila, segundaColumna);

			// Mostramos de nuevo el tablero de juego con el número que se acaba de descubrir
			Memory.muestraTableroDeJuego();

			// Mostramos un mensaje indicando la opción elegida
			System.out.println("FILA " + segundaFila + ", COLUMNA " + segundaColumna + " = "
					+ tableroDejuego[segundaFila][segundaColumna]);

			// Comprobamos la pareja y asignamos true o false a parejaIgual
			parejaIgual = Memory.comprobarPareja(primeraFila, primeraColumna, segundaFila, segundaColumna);
			// Según su valor, indicará si son iguales o no
			System.out.println(parejaIgual ? "Genial, has encontrado una pareja" : "Fallo, son distintos");

		} 

		// Mensaje de finalización del juego
		System.out.println("ENHORABUENA, has completado el juego");

		// Cerramos el Scanner
		sc.close();
	}

}
