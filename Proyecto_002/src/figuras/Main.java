package figuras;

public class Main {
	/**
	 * 
	 * @author Joel Luna
	 * @category Principio de inversion de Dependencias
	 */
	public static void main(String[] args) {

		DibujarFigura figura1 = new DibujarFigura(new Circulo());
		DibujarFigura figura2 = new DibujarFigura(new Cuadrado());
		DibujarFigura figura3 = new DibujarFigura(new Triangulo());

		figura1.dibujarFigura();
		figura2.dibujarFigura();
		figura3.dibujarFigura();

	}

}
