package aed.hibernate;

import javax.persistence.Embeddable;

@Embeddable 
//En este caso es para guardar en las columnas nombre, primerApellido y SegundoApellido,
//dentro de la base de datos, pero usando un objeto desde el lado de java
public class NomHotel {

	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	
	public NomHotel() {
		this(null,null,null);
	}
	
	private NomHotel(String nombre, String primerApellido, String segundoApellido) {
		setNombre(nombre);
		setPrimerApellido(primerApellido);
		setSegundoApellido(segundoApellido);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	@Override
	public String toString() {
		return "NomHotel [nombre=" + nombre + ", primerApellido=" + primerApellido + ", segundoApellido="
				+ segundoApellido + "]";
	}
}
