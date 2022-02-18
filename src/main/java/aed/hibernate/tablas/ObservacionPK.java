package aed.hibernate.tablas;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Embeddable
public class ObservacionPK implements Serializable {

	@OneToOne
	@JoinColumn(name = "codHabitacion")
	private Habitacion habitacion;

	public ObservacionPK() {
		
	}
	
	public ObservacionPK(Habitacion habitacion) {
		setHabitacion(habitacion);
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
}
