package aed.hibernate.tablas;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "observaciones")
public class Observacion {
	
	@EmbeddedId
	private ObservacionPK observacionPK;

	private String Observaciones;

	public Observacion() {
		
	}
	
	public ObservacionPK getObservacionPK() {
		return observacionPK;
	}

	public void setObservacionPK(ObservacionPK observacionPK) {
		this.observacionPK = observacionPK;
	}

	public String getObservaciones() {
		return Observaciones;
	}

	public void setObservaciones(String observaciones) {
		Observaciones = observaciones;
	}
}
