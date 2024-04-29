package galaga;

import interfaces.IObject;

public class Contenedor {
	
	private final IObject interfacesObjetos;
	
	public Contenedor(IObject interfacesObjetos) {
		this.interfacesObjetos = interfacesObjetos;
	}
	
	public void drawObject() {
		interfacesObjetos.draw(null);
	
	}
	
	public void moveObject() {
		interfacesObjetos.move();
	}
	
	public void destroyObject() {
		interfacesObjetos.destroy();
	}
	
	
	
	

}
