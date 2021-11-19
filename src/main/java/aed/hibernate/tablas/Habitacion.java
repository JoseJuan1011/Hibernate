package aed.hibernate.tablas;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity(name="habitaciones")
public class Habitacion implements Serializable {
	
	@EmbeddedId
	HabitacionPK habitacionPK = new HabitacionPK();
	
	@MapsId(value = "habitacionPK.codHotel")
	@ManyToOne
	private Hotel codHotel;
	
	private int capacidad;
	
	private int preciodia;
	
	private int activa;
	
	public Habitacion() {
		
	}

	public Habitacion(String codHotel, int numHabitacion) {
		getHabitacionPK().setCodHotel(codHotel);
		getHabitacionPK().setNumHabitacion(numHabitacion);
	}

	public HabitacionPK getHabitacionPK() {
		return habitacionPK;
	}

	public void setHabitacionPK(HabitacionPK habitacionPK) {
		this.habitacionPK = habitacionPK;
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

	@Override
	public String toString() {
		return "Habitacion [habitacionPK=" + habitacionPK + ", codHotel=" + codHotel + ", capacidad=" + capacidad
				+ ", preciodia=" + preciodia + ", activa=" + activa + "]";
	}
}
