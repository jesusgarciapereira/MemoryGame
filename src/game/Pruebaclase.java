package game;

import java.util.Random;

/**
 * Class with the game features
 */
public class Pruebaclase {

	

//	public static void setTamTablero(int tamTablero) {
//		Memory.tamTablero = tamTablero;
//	}

	/**
	 * Fuction thats return the value of the atribute called TableroDeJuego
	 * @return value of the TableroDeJuego
	 */
	public static int[][] getTableroDeJuego() {
		return tableroDeJuego;
	}

	/**
	 * Function thats initializate all the atributes, assigning the correspondent values
	 * accordint to the choosen difficulty
	 * @param dificultad Difficulty choosen by the User
	 */
	public static void inicializar(String dificultad) {
		// Accordint to the Difficulty's value
		switch (dificultad) {
		// if the value is "easy"
		case "easy":
			// The size of the board will be 4
			tamTablero = 4;
			break;
		// if the value is "medium"
		case "medium":
			// The size of the board will be 6
			tamTablero = 6;
			break;
		// if the value is "hard"
		case "hard":
			// The size of the board will be 8
			tamTablero = 8;
			break;

		}

		// Inicializate the two boards with the size of the assigned board
		solucion = new int[tamTablero][tamTablero];
		tableroDeJuego = new int[tamTablero][tamTablero];

	}

	/**
	 * Funcion que modifica el atributo solucion, generando las parejas de numeros
	 * en posiciones aleatorias, pero no sera visible
	 * 
	 * Function thats modificates the atribute "solucion", generating the couple of numbers
	 * in aleatories positions, but it will not visible
	 */
	public static void generaSolucion() {

		// Creates a objets with the class random
		Random rand = new Random();

		// Numero que ocupará un lugar en la tabla, inicializado en 1
		//Number thats will ocupated the place on the board, inicializate in 1
		int numParaRellenar = 1;

		// Posición correspondiente a la fila generada aleatoriamente
		//Corresponding position to the row inicializated aleatory
		int fila;
		// Posición correspondiente a la columna generada aleatoriamente
		//Corresponding position to the column inicializated aleatory
		int columna;

		// Valor auxiliar para hacer los intercambios
		//value auxiliar to do the exchanges
		int aux;

		// we fill the board solucion
		//We go throught each row to the board solucion
		for (int i = 0; i < solucion.length; i++) {
			// We go thought each column to the board solucion
			for (int j = 0; j < solucion[i].length; j++) {

				//If the number to fill beats the maximun limit
				if (numParaRellenar > Math.pow(tamTablero, 2) / 2) {
					//assings 1
					numParaRellenar = 1;
				}

				// Asignamos el número a la posición correspondiente
				//We assigned the number to the correspondent position
				solucion[i][j] = numParaRellenar;
				// We increase the number to fill
				numParaRellenar++;
			}
		}

		// Desordenamos la tabla
		// Recorremos cada fila de la tabla solucion
		for (int i = 0; i < solucion.length; i++) {
			// Recorremos cada columna de la tabla solucion
			for (int j = 0; j < solucion[i].length; j++) {
				// Asignamos a posFila un número aleatorio entre 0 y la longitud de la fila
				fila = rand.nextInt(0, solucion.length);
				// Asignamos a posColumna un número aleatorio entre 0 y la longitud de la
				// columna
				columna = rand.nextInt(0, solucion[i].length);

				// Asignamos aux como una copia del elemento de la tabla en el que nos
				// encontramos
				aux = solucion[i][j];
				// Intercambiamos los valores de la posición en la que nos encontramos y la
				// posición generada aleatoriamente
				solucion[i][j] = solucion[fila][columna];
				solucion[fila][columna] = aux;

			}
		}

	}
	//Hasta aca traduce juan (abajo)
	/**
	 * Función que muestra el tablero de juego
	 */
	public static void muestraTableroDeJuego() {
		System.out.println("\t\tCOLUMN");
		System.out.print("\t\t");

		// Números que representan a las posiciones de las columnas
		for (int j = 0; j < tableroDeJuego[0].length; j++) {
			System.out.print(j + "\t");
		}

		System.out.println();

		// Línea de guiones según el tamaño del tablero
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

		// Mostramos el tablero de juego
		// Bucle for que recorre cada fila
		for (int i = 0; i < tableroDeJuego.length; i++) {
			// Si estamos en la primera fila, muestra la palabra ROW
			System.out.print((i == 0 ? "ROW" : "") + "\t");
			// Bucle for que recorre cada columna
			for (int j = 0; j < tableroDeJuego[i].length; j++) {
				// Si estamos en la primera columna
				if (j == 0) {
					// Muestra antes el número de fila en que nos encontramos
					System.out.print(i + "|\t");
				}
				// Muestra el número sólo si es distinto de 0, en caso contrario muestra un
				// cuadrado
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

	/**
	 * Funcion que indica si la pareja de numeros que hemos descubierto son iguales.
	 * Si no lo son, los vuelve a "ocultar" asignandoles 0
	 * 
	 * @param primeraFila    Fila del primer numero
	 * @param primeraColumna Columna del primer numero
	 * @param segundaFila    Fila del segundo numero
	 * @param segundaColumna Columna del segundo numero
	 * @return True o false segun si la pareja de numeros son iguales o no
	 */
	public static boolean comprobarPareja(int primeraFila, int primeraColumna, int segundaFila, int segundaColumna) {
		// Variable que indica si los números son iguales
		boolean sonIguales = true;

		// Si ambos números descubiertos son diferentes
		if (tableroDeJuego[primeraFila][primeraColumna] != tableroDeJuego[segundaFila][segundaColumna]) {
			// Asignamos 0 a ambos números
			tableroDeJuego[primeraFila][primeraColumna] = 0;
			tableroDeJuego[segundaFila][segundaColumna] = 0;
			// Y el boolean como false
			sonIguales = false;
		}

		// Devolverá el valor del boolean
		return sonIguales;

	}

	/**
	 * Funcion que indica si hemos terminado el juego, lo determina buscando un 0 en
	 * el tablero de juego
	 * 
	 * @return True o false segun si el juego se ha terminado o no
	 */
	public static boolean finDeJuego() {
		// Variable que determina si el juego ha terminado, por ahora verdadero
		boolean juegoTerminado = true;

		// Número a encontrar en el tablero: el 0
		int numEncontrar = 0;

		// Contador de las filas
		int i = 0;
		// Mientras el contador de filas sea menor al número de filas del
		// tableroDeJuego y el boolean sea true
		while (i < tableroDeJuego.length && juegoTerminado) {
			// Contador de las columnas
			int j = 0;
			// Mientras el contador de columnas sea menor al número de columnas del
			// tableroDeJuego y el boolean sea true
			while (j < tableroDeJuego[i].length && juegoTerminado) {
				// Si el número que buscamos está presente en el tableroDeJuego
				if (tableroDeJuego[i][j] == numEncontrar) {
					// Asignamos el boolean como false
					juegoTerminado = false;
				}
				// Incrementamos el contador de las columnas
				j++;
			}
			// Incrementamos el contador de las filas
			i++;
		}

		// Devolverá el valor de juegoTerminado
		return juegoTerminado;

	}

}
