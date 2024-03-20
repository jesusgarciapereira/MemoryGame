package game;

import java.util.Random;

/**
 * Clase con las funciones del juego
 */
public class Memory {

	static Random rand = new Random();

	/**
	 * Tamannio del tablero
	 */
	private static int tamTablero;

	/**
	 * Tabla con la solucion completa
	 */
	private static int[][] solucion;

	/**
	 * Tabla que se muestra en el tablero de juego
	 */
	private static int[][] tableroDeJuego;

	public static int getTamTablero() {
		return tamTablero;
	}

//	public static void setTamTablero(int tamTablero) {
//		Memory.tamTablero = tamTablero;
//	}

	/**
	 * Funcion que devuelve el valor del atributo tableroDeJuego
	 * 
	 * @return Valor de tableroDeJuego
	 */
	public static int[][] getTableroDeJuego() {
		return tableroDeJuego;
	}

	public static void asignarDificultad(String dificultad) {
		switch (dificultad) {
		case "easy":
			tamTablero = 4;
			break;
		case "medium":
			tamTablero = 6;
			break;
		case "hard":
			tamTablero = 8;
			break;

		}

		solucion = new int[tamTablero][tamTablero];
		tableroDeJuego = new int[tamTablero][tamTablero];

	}

	/**
	 * Funcion que modifica el atributo solucion, generando las parejas de numeros
	 * en posiciones aleatorias, pero no sera visible
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
				if (numParaRellenar > Math.pow(tamTablero, 2) / 2) {
					// Se le asigna el 1
					numParaRellenar = 1;
				}

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
		System.out.println("\t\tCOLUMN");
		System.out.print("\t\t");
		for (int j = 0; j < tableroDeJuego[0].length; j++) {
			System.out.print(j + "\t");
		}

		System.out.println();

		switch (tamTablero) {
		case 4:
			System.out.println("\t\t-------------------------");
			break;
		case 6:
			System.out.println("\t\t-----------------------------------------");
			break;
		case 8:
			System.out.println("\t\t---------------------------------------------------------");
			break;
		}

		for (int i = 0; i < tableroDeJuego.length; i++) {
			System.out.print((i == 0 ? "ROW" : "") + "\t");
			for (int j = 0; j < tableroDeJuego[i].length; j++) {
				if (j == 0) {
					System.out.print(i + "|\t");
				}
				// Lo muestra sólo si es distinto de 0
				System.out.print((tableroDeJuego[i][j] != 0 ? tableroDeJuego[i][j] : "\u25A0") + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

//	public static boolean numDescubierto(int fila, int columna) {
//
//		int[][] tableroDejuego = tableroDeJuego;
//
//		boolean descubierto = false;
//		
//		if (fila >= 0 && columna >= 0 && tableroDejuego[fila][columna] != 0) {
//			descubierto = true;
//		}
//		return descubierto;
//	}

	/**
	 * Funcion que modifica el tablero de juego, mostrando la posicion marcada en el
	 * parametro
	 * 
	 * @param posicion Posicion de la tabla que sera visible
	 */
	public static void descubrirCasillaTablero(int fila, int columna) {

		// El elemento del tablero de juego será igual al elemento que esté en la misma
		// posición en la tabla solución
		tableroDeJuego[fila][columna] = solucion[fila][columna];

	}

	public static boolean comprobarPareja(int primeraFila, int primeraColumna, int segundaFila, int segundaColumna) {
		boolean sonIguales = true;

		if (tableroDeJuego[primeraFila][primeraColumna] != tableroDeJuego[segundaFila][segundaColumna]) {
			tableroDeJuego[primeraFila][primeraColumna] = 0;
			tableroDeJuego[segundaFila][segundaColumna] = 0;
			sonIguales = false;
		}

		return sonIguales;

	}

	/**
	 * Funcion que indica si hemos terminado el juego
	 * 
	 * @return True o false segun si el juego se ha terminado o no
	 */
	public static boolean finDeJuego() {
		// Variable que determina si el juego ha terminado, por ahora falso
		boolean juegoTerminado = false;

		// Número a encontrar en el tablero: el 0
		int numEncontrar = 0;

		// Posiciones de la tabla tableroDeJuego (inicializadas en -1)
		int posX = -1;
		int posY = -1;

		// Contador de las filas
		int i = 0;
		// Mientras el contador de filas sea menor al número de filas del tableroDeJuego
		// y posX sea -1
		while (i < tableroDeJuego.length && posX == -1) {
			// Contador de las columnas
			int j = 0;
			// Mientras el contador de columnas sea menor al número de columnas del
			// tableroDeJuego y posY sea -1
			while (j < tableroDeJuego[i].length && posY == -1) {
				// Si el número que buscamos está presente en el tableroDeJuego
				if (tableroDeJuego[i][j] == numEncontrar) {
					// Le asignamos las posiciones en donde ha sido encontrado
					posX = i;
					posY = j;
				}
				// Incrementamos el contador de las columnas
				j++;
			}
			// Incrementamos el contador de las filas
			i++;
		}

		// Si el número no ha sido encontrado
		if (posX == -1 && posY == -1)
			// El juego habrá terminado
			juegoTerminado = true;

		// Devolverá el valor de juegoTerminado
		return juegoTerminado;

	}

}
