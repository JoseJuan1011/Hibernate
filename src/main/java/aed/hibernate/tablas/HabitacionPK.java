package aed.hibernate.tablas;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Embeddable
public class HabitacionPK implements Serializable {

	private int codHabitacion;
	
	@ManyToOne
	@JoinColumn(name="codHotel")
	private Hotel codHotel;
	
	private int numHabitacion;
	
	public HabitacionPK() {
		setCodHotel(null);
		setNumHabitacion(0);
	}
	
	public HabitacionPK(Hotel codHotel, int numHabitacion) {
		this.codHotel = codHotel;
		this.numHabitacion = numHabitacion;
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
}
