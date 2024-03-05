package game;

import java.util.Random;

/**
 * Clase con las funciones del juego
 */
public class Memory {

	static Random rand = new Random();

	/**
	 * Constante con el tamannio del tablero
	 */
	static final int TAM_TABLERO = 4;

	/**
	 * Tabla con la solucion completa
	 */
	static int[][] solucion = new int[TAM_TABLERO][TAM_TABLERO];

	/**
	 * Tabla que se muestra en el tablero de juego
	 */
	static int[][] tableroDeJuego = new int[TAM_TABLERO][TAM_TABLERO];

	/**
	 * Funcion que modifica el atributo solucion la solucion, las posciones en las
	 * que iran todos los numeros, pero no sera visible
	 */
	public static void generaSolucion() {
		// Numero que ocupará un lugar en la tabla, inicializado en 1
		int numParaRellenar = 1;

		// Posición correspondiente a la fila generada aleatoriamente
		int posFila;
		// Posición correspondiente a la columna generada aleatoriamente
		int posColumna;

		// Valor auxiliar para hacer los intercambios
		int aux;

		// Rellenamos la tabla solución
		// Recorremos cada fila de la tabla solucion
		for (int i = 0; i < solucion.length; i++) {
			// Recorremos cada columna de la tabla solucion
			for (int j = 0; j < solucion[i].length; j++) {

				// Si el numero para rellenar supera el límite máximo
				if (numParaRellenar > Math.pow(TAM_TABLERO, 2) / 2)
					// Se le asigna el 1
					numParaRellenar = 1;

				// Asignamos el número a la posición correspondiente
				solucion[i][j] = numParaRellenar;
				// Incrementamos el número a rellenar
				numParaRellenar++;
			}
		}

		// Desordenamos la tabla
		// Recorremos cada fila de la tabla solucion
		for (int i = 0; i < solucion.length; i++) {
			// Recorremos cada columna de la tabla solucion
			for (int j = 0; j < solucion[i].length; j++) {
				// Asignamos a posFila un número aleatorio entre 0 y la longitud de la fila
				posFila = rand.nextInt(0, solucion.length);
				// Asignamos a posColumna un número aleatorio entre 0 y la longitud de la
				// columna
				posColumna = rand.nextInt(0, solucion[i].length);

				// Asignamos aux como una copia del elemento de la tabla en el que nos
				// encontramos
				aux = solucion[i][j];
				// Intercambiamos los valores de la posición en la que nos encontramos y la
				// posición generada aleatoriamente
				solucion[i][j] = solucion[posFila][posColumna];
				solucion[posFila][posColumna] = aux;

			}
		}

	}

	/**
	 * Función que muestra el tablero de juego
	 */
	public static void muestraTableroDeJuego() {
		System.out.println("\t\t\t COLUMNA");
		System.out.print("\t\t");
		for (int j = 0; j < tableroDeJuego[0].length; j++) {
			System.out.print(j + "\t");
		}

		System.out.println();
		System.out.println("\t\t-------------------------");

		for (int i = 0; i < tableroDeJuego.length; i++) {
			System.out.print((i == 0 ? "FILA" : "") + "\t");
			for (int j = 0; j < tableroDeJuego[i].length; j++) {
				if (j == 0) {
					System.out.print(i + "|\t");
				}
				// Lo muestra sólo si es distinto de 0
				System.out.print(tableroDeJuego[i][j] != 0 ? tableroDeJuego[i][j] : " " + "\t");
			}
			System.out.println();
		}

	}

}
