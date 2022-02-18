package aed.hibernate.tablas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "habitaciones")
public class Habitacion {

	@Id
	@Column(name = "codHabitacion", columnDefinition = "int(11)")
	private int codHabitacion;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "codHotel")
	private Hotel codHotel;

	@Column(name = "numHabitacion", columnDefinition = "char(4)")
	private int numHabitacion;

	@Column(name = "capacidad", columnDefinition = "smallint(6)")
	private int capacidad;

	@Column(name = "preciodia", columnDefinition = "int(11)")
	private int preciodia;

	@Column(name = "activa", columnDefinition = "tinyint(1)")
	private int activa;

	@OneToMany(mappedBy = "habitacion", targetEntity = Estancia.class, cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
	private List<Estancia> estancias = new ArrayList<Estancia>();

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "habitacion")
	private Observacion observacion;

	public Habitacion() {
		this(0, new Hotel(), 0, 0, 0, 0, new Observacion());
	}

	public Habitacion(int codHabitacion, Hotel codHotel, int numHabitacion) {
		this(codHabitacion, codHotel, numHabitacion, 0, 0, 0, new Observacion());
	}

	private Habitacion(int codHabitacion, Hotel codHotel, int numHabitacion, int capacidad, int preciodia, int activa,
			Observacion observacion) {
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

	public Observacion getObservacion() {
		return observacion;
	}

	public void setObservacion(Observacion observacion) {
		this.observacion = observacion;
	}

	public List<Estancia> getEstancias() {
		return estancias;
	}

	public void setEstancias(List<Estancia> estancias) {
		this.estancias = estancias;
	}

	@Override
	public String toString() {
		return "Habitacion [codHabitacion=" + codHabitacion + ", codHotel=" + codHotel + ", numHabitacion="
				+ numHabitacion + ", capacidad=" + capacidad + ", preciodia=" + preciodia + ", activa=" + activa + ", " + (Objects.isNull(observacion) ? "" : "observaciones: "+observacion.getObservaciones()) + "]";
	}
}
