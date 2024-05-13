
package game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	/**
	 * Scanner activado
	 */
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

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
		Pruebaclase.inicializar(dificultad.toLowerCase());
		// Asignamos los valores de la propiedad del tablero solución
		Pruebaclase.generaSolucion();
		// Asignamos el valor del tableroDeJuego
		tableroDejuego = Pruebaclase.getTableroDeJuego();

		// Mientras el juego no haya terminado
		while (!Pruebaclase.finDeJuego()) {

			System.out.println("Pulsa intro para continuar");
			sc.nextLine();

			// Mostramos el tablero de juego
			Pruebaclase.muestraTableroDeJuego();

			do {
				// Pedimos la primera fila
				primeraFila = pideNumero("Elija una fila");
				// Pedimos la primera columna
				primeraColumna = pideNumero("Elija una columna");

				// Si la posición elegida corresponde a un número distinto de 0
				if (tableroDejuego[primeraFila][primeraColumna] != 0) {
					// Es porque dicha posición ya está descubierta, lo indicará
					System.out.println("Esa posición ya está descubierta");
				}

				// Mientras la posición indicada no sea distinto de 0, pedirá de nuevo la fila y
				// la columna
			} while (tableroDejuego[primeraFila][primeraColumna] != 0);

			// Una vez elegidos los valores correctos, descubrimos el número oculto
			Pruebaclase.descubrirCasillaTablero(primeraFila, primeraColumna);

			// Mostramos de nuevo el tablero de juego con el número que se acaba de
			// descubrir
			Pruebaclase.muestraTableroDeJuego();

			// Mostramos un mensaje indicando la opción elegida
			System.out.println("FILA " + primeraFila + ", COLUMNA " + primeraColumna + " = "
					+ tableroDejuego[primeraFila][primeraColumna]);

			do {
				// Pedimos la segunda fila
				segundaFila = pideNumero("Elija una fila");
				// Pedimos la primera columna
				segundaColumna = pideNumero("Elija una columna");

				// Si la posición elegida corresponde a un número distinto de 0
				if (tableroDejuego[segundaFila][segundaColumna] != 0) {
					// Es porque dicha posición ya está descubierta, lo indicará
					System.out.println("Esa posición ya está descubierta");
				}

				// Mientras la posición indicada no sea distinto de 0, pedirá de nuevo la fila y
				// la columna
			} while (tableroDejuego[segundaFila][segundaColumna] != 0);

			// Una vez elegidos los valores correctos, descubrimos el número oculto
			Pruebaclase.descubrirCasillaTablero(segundaFila, segundaColumna);

			// Mostramos de nuevo el tablero de juego con el número que se acaba de
			// descubrir
			Pruebaclase.muestraTableroDeJuego();

			// Mostramos un mensaje indicando la opción elegida
			System.out.println("FILA " + segundaFila + ", COLUMNA " + segundaColumna + " = "
					+ tableroDejuego[segundaFila][segundaColumna]);

			// Comprobamos la pareja y asignamos true o false a parejaIgual
			parejaIgual = Pruebaclase.comprobarPareja(primeraFila, primeraColumna, segundaFila, segundaColumna);
			// Según su valor, indicará si son iguales o no
			System.out.println(parejaIgual ? "Genial, has encontrado una pareja" : "Fallo, son distintos");

		}

		// Mensaje de finalización del juego
		System.out.println("ENHORABUENA, has completado el juego");

		// Cerramos el Scanner
		sc.close();
	}

	/**
	 * Metodo para pedir un numero al usuario
	 * 
	 * @param peticion Mensaje de la peticion
	 * @return Devolvera el valor del numero que pedimos
	 */
	private static int pideNumero(String peticion) {

		// Número que devolverá la función
		int numero = -1;

		do {
			try {
				// Mensaje de la petición correspondiente
				System.out.println(peticion);
				// Asignamos el número introducido por el usuario
				numero = sc.nextInt();
				// Si no se escribe un número entero
			} catch (InputMismatchException e) {
				// Muestra este mensaje
				System.out.println("Sólo se admiten números enteros");
			} finally {
				// Siempre limpiamos el buffer
				sc.nextLine();
			}
			// Mientras el número no esté dentro de los posibles índices del tablero se
			// repetiran las instrucciones del do
		} while (numero < 0 || numero >= Pruebaclase.getTamTablero());

		// Devolverá el número asignado
		return numero;
	}
}
