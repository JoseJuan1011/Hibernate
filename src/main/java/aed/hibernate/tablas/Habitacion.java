package aed.hibernate.tablas;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="habitaciones")
public class Habitacion implements Serializable {
	
	@Id
	@ManyToOne
	private Hotel codHotel;
	
	@Id
	@Column(name="numHabitacion")
	private int numeroHabitacion;
	
	private int capacidad;
	
	private int preciodia;
	
	private int activa;
	
	public Habitacion() {
		
	}

	public Hotel getCodHotel() {
		return codHotel;
	}

	public void setCodHotel(Hotel codHotel) {
		this.codHotel = codHotel;
	}

	public int getNumeroHabitacion() {
		return numeroHabitacion;
	}

	public void setNumeroHabitacion(int numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getPreciodia() {
		return preciodia;
	}

	public void setPreciodia(int preciodia) {
		this.preciodia = preciodia;
	}

	public int getActiva() {
		return activa;
	}

	public void setActiva(int activa) {
		this.activa = activa;
	}
}
