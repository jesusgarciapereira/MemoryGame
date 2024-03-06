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
		int primeraPosicionSeleccionada;
		// Segunda posición seleccionada por el jugador
		int segundaPosicionSeleccionada;

		int izquierdaPrimero;
		int derechaPrimero;
		int izquierdaSegundo;
		int derechaSegundo;

		// Activamos el Scanner
		Scanner sc = new Scanner(System.in);

		// Llamamos a la función generaSolucion() para asignar los valores aleatorios de
		// la tabla solucion
		Memory.generaSolucion();

		while (!Memory.finDeJuego()) {
			Memory.muestraTableroDeJuego();

			// Le pedimos al usuario la primera posición
			System.out.println("Elija una posición");
			// Y la asignamos
			primeraPosicionSeleccionada = sc.nextInt();
			izquierdaPrimero = primeraPosicionSeleccionada / 10;
			derechaPrimero = primeraPosicionSeleccionada % 10;

			Memory.descubrirCasillaTablero(primeraPosicionSeleccionada);

			Memory.muestraTableroDeJuego();

			// Le pedimos al usuario la segunda posición
			System.out.println("Elija otra posición");
			// Y la asignamos
			segundaPosicionSeleccionada = sc.nextInt();
			izquierdaSegundo = segundaPosicionSeleccionada / 10;
			derechaSegundo = segundaPosicionSeleccionada % 10;

			Memory.descubrirCasillaTablero(segundaPosicionSeleccionada);

			Memory.muestraTableroDeJuego();

			if (tableroDejuego[izquierdaPrimero][derechaPrimero] != tableroDejuego[izquierdaSegundo][derechaSegundo]) {
				tableroDejuego[izquierdaPrimero][derechaPrimero] = 0;
				tableroDejuego[izquierdaSegundo][derechaSegundo] = 0;
				System.out.println("Fallo, son distintas");
			}else
				System.out.println("Genial, has encontrado una pareja");
			
			sc.nextLine();
			System.out.println("Pulsa intro para continuar");
			sc.nextLine();
		}
	}
}
