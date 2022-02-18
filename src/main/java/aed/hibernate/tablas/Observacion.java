package aed.hibernate.tablas;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "observaciones")
public class Observacion {
	
	@Id
	@Column(columnDefinition = "int(11)")
	private int codHabitacion;
	
	@Column(columnDefinition = "varchar(250)")
	private String Observaciones;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn(name = "observacion")
	private Habitacion habitacion;
	
	public Observacion() {
		
	}

	public String getObservaciones() {
		return Observaciones;
	}

	public void setObservaciones(String observaciones) {
		Observaciones = observaciones;
	}
}
