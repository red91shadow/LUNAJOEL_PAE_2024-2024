package figuras;

import interfaces.Figura;

public class DibujarFigura {

	// Esta clase permite permite dibujar cualquier tipo de
	// figura sin acoplarse a una implementación específica

	private final Figura interfacesfigura;

	public DibujarFigura(Figura interfacesfigura) {
		this.interfacesfigura = interfacesfigura;
	}

	public void dibujarFigura() {
		interfacesfigura.dibujar();

	}

}
