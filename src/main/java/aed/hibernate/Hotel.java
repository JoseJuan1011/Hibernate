package aed.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="hoteles")
//Poner @Table(name="nombre_tabla") para poner el nombre de la tabla de la base de datos.
public class Hotel {
	
	@Id
	//Poner @Column(name="nombreColumna") para el nombre de la columna en la base de datos.
	//Poner @Transient para variables las cuales no se van a guardar en la base de datos.
	private String codHotel;
	private String nomHotel;

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
	@Override
	public String toString() {
		return "Hotel [codHotel=" + codHotel + ", nomHotel=" + nomHotel + "]";
	}
}
