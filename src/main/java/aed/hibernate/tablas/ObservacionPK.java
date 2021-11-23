package aed.hibernate.tablas;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
public class ObservacionPK implements Serializable {

	@OneToOne
	@JoinColumn(name = "codHabitacion")
	private Habitacion habitacion;

	public ObservacionPK() {
		// TODO Auto-generated constructor stub
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
}
