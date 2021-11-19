package aed.hibernate.tablas;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class HabitacionPK implements Serializable {
	private String codHotel;
	
	private int numHabitacion;
	
	public HabitacionPK () {
		
	}

	public String getCodHotel() {
		return codHotel;
	}

	public void setCodHotel(String codHotel) {
		this.codHotel = codHotel;
	}

	public int getNumHabitacion() {
		return numHabitacion;
	}

	public void setNumHabitacion(int numHabitacion) {
		this.numHabitacion = numHabitacion;
	}
}
