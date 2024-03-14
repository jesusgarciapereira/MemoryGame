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
	private static final int TAM_TABLERO = 4;

	/**
	 * Tabla con la solucion completa
	 */
	private static int[][] solucion = new int[TAM_TABLERO][TAM_TABLERO];

	/**
	 * Tabla que se muestra en el tablero de juego
	 */
	private static int[][] tableroDeJuego = new int[TAM_TABLERO][TAM_TABLERO];

	/**
	 * Funcion que devuelve el valor del atributo tableroDeJuego
	 * 
	 * @return Valor de tableroDeJuego
	 */
	public static int[][] getTableroDeJuego() {
		return tableroDeJuego;
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
				System.out.print((tableroDeJuego[i][j] != 0 ? tableroDeJuego[i][j] : "X") + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static boolean numElegible(int posicionSeleccionada) {
		
		int[][] tableroDejuego = tableroDeJuego;
		
		boolean elegible = true;
				if(posicionSeleccionada < 0
						|| posicionSeleccionada / 10 >= tableroDejuego.length
						|| posicionSeleccionada % 10 >= tableroDejuego[0].length
						|| tableroDejuego[posicionSeleccionada / 10][posicionSeleccionada
								% 10] != 0)
					elegible = false;
		return elegible;
	}
	
	/**
	 * Funcion que modifica el tablero de juego, mostrando la posicion marcada en el
	 * parametro
	 * 
	 * @param posicion Posicion de la tabla que sera visible
	 */
	public static void descubrirCasillaTablero(int posicion) {
		// Número correspondiente a la fila
		int izquierda;
		// Número correspondiente a la columna
		int derecha;

		// Le asignamos la cifra de la izquierda con / 10
		izquierda = posicion / 10;
		// Le asignamos la cifra de la derecha con % 10
		derecha = posicion % 10;

		// El elemento del tablero de juego será igual al elemento que esté en la misma
		// posición en la tabla solución
		tableroDeJuego[izquierda][derecha] = solucion[izquierda][derecha];

	}

	public static boolean comprobarPareja(int posicion1, int posicion2) {
		boolean sonIguales = true;

		int izq1 = posicion1 / 10;
		int der1 = posicion1 % 10;
		int izq2 = posicion2 / 10;
		int der2 = posicion2 % 10;

		if (tableroDeJuego[izq1][der1] != tableroDeJuego[izq2][der2]) {
			tableroDeJuego[izq1][der1] = 0;
			tableroDeJuego[izq2][der2] = 0;
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
