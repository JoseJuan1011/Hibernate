package aed.hibernate.tablas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="hoteles")
//Poner @Table(name="nombre_tabla") para poner el nombre de la tabla de la base de datos.
public class Hotel {
	
	
	//Poner @Column(name="nombreColumna") para el nombre de la columna en la base de datos.
	//Poner @Transient para variables las cuales no se van a guardar en la base de datos.
	@Id
	private String codHotel;
	private String nomHotel;
	
	//FetchType.Eager para mostrar lista de habitaciones mediante la sentencia sql
	@OneToMany(mappedBy="codHotel",fetch = FetchType.EAGER)
	private List<Habitacion> habitaciones = new ArrayList<>();

	public Hotel(String codHotel, int numHabitacion) {
		setCodHotel(codHotel);
		getHabitaciones().add(new Habitacion(codHotel,numHabitacion));
	}
	public String getCodHotel() {
		return codHotel;
	}
	public void setCodHotel(String codHotel) {
		this.codHotel = codHotel;
	}
	public String getNomHotel() {
		return nomHotel;
	}
	public void setNomHotel(String nomHotel) {
		this.nomHotel = nomHotel;
	}
	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}
	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}
	@Override
	public String toString() {
		return "Hotel [codHotel=" + codHotel + ", nomHotel=" + nomHotel + "]";
	}
}
