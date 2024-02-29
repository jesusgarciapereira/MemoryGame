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
	int[][] tablero = new int[TAM_TABLERO][TAM_TABLERO];

	/**
	 * Funcion que modifica el atributo solucion la solucion, las posciones en las
	 * que iran todos los numeros, pero no sera visible
	 */
	public static void generaSolucion() {
		// Numero que ocupará un lugar en la tabla, inicializado en 1
		int numParaRellenar = 1;
		
		int posX;
		int posY;
		int aux;
		
		//Rellenamos la tabla solución
		//Recorremos cada fila de la tabla solucion
		for (int i = 0; i < solucion.length; i++) {
			//Recorremos cada columna de la tabla solucion
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
		
		// NOS FALTA DESORDENARLA - He aquí
		for (int i = 0; i < solucion.length; i++) {
			for (int j = 0; j < solucion.length; j++) {
				posX = rand.nextInt(1, solucion.length);
				posY = rand.nextInt(1, solucion.length);
				
				aux = solucion[i][j];
				
				solucion[i][j] = solucion[posX][posY];
				
				solucion[posX][posY] = aux;
				
			}
		}
		

	}

}
