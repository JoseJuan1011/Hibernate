package aed.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="hoteles")
public class Hotel {
	
	@Id
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
}
