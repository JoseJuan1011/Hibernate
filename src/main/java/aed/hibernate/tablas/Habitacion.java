package aed.hibernate.tablas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="habitaciones")
public class Habitacion implements Serializable {
	
	@Id
	private int codHabitacion;
	
	@ManyToOne
	@JoinColumn(name="codHotel")
	private Hotel codHotel;
	
	private int numHabitacion;
	
	private int capacidad;
	
	private int preciodia;
	
	@Column(length = 1)
	private int activa;
	
	@OneToMany(mappedBy = "habitacion", targetEntity = Estancia.class)
	private List<Estancia> estancias = new ArrayList<Estancia>();
	
	@OneToOne(mappedBy = "observacionPK.habitacion")
	private Observacion observacion;
	
	public Habitacion() {
		this(0,new Hotel(),0,0,0,0,new Observacion());
	}
	
	public Habitacion(int codHabitacion, Hotel codHotel, int numHabitacion) {
		this(codHabitacion,codHotel,numHabitacion,0,0,0,new Observacion());
	}
	
	private Habitacion(int codHabitacion, Hotel codHotel, int numHabitacion, int capacidad, int preciodia, int activa, Observacion observacion) {
		this.codHabitacion = codHabitacion;
		this.codHotel = codHotel;
		this.numHabitacion = numHabitacion;
		this.capacidad = capacidad;
		this.preciodia = preciodia;
		this.activa = activa;
		this.observacion = observacion;
	}
	
	public int getCodHabitacion() {
		return codHabitacion;
	}

	public void setCodHabitacion(int codHabitacion) {
		this.codHabitacion = codHabitacion;
	}

	public Hotel getCodHotel() {
		return codHotel;
	}

	public void setCodHotel(Hotel codHotel) {
		this.codHotel = codHotel;
	}

	public int getNumHabitacion() {
		return numHabitacion;
	}

	public void setNumHabitacion(int numHabitacion) {
		this.numHabitacion = numHabitacion;
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
		return "Habitacion [codHabitacion=" + codHabitacion + ", codHotel=" + codHotel + ", numHabitacion="
				+ numHabitacion + ", capacidad=" + capacidad + ", preciodia=" + preciodia + ", activa=" + activa
				+ ", observacion=" + observacion + "]";
	}
}
