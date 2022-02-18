package aed.hibernate.tablas;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "estancias")
public class Estancia {

	@Id
	@Column(name = "codEstancia", columnDefinition = "int(11)")
	private int codEstancia;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name="coddnionie", referencedColumnName = "coddnionie")
	private Cliente coddnionie;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "codHabitacion", referencedColumnName = "codHabitacion")
	private Habitacion habitacion;
	
	@Column(name = "fechaInicio", columnDefinition = "date")
	private Date fechaInicio;
	
	@Column(name = "fechaFin", columnDefinition = "date")
	private Date fechaFin;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name="codRegimen")
	private Regimen codRegimen;
	
	@Column(name = "ocupantes", columnDefinition = "smallint(6)")
	private int ocupantes;
	
	@Column(name = "precioestancia", columnDefinition = "int(11)")
	private int precioestancia;
	
	@Column(name = "pagado", columnDefinition = "tinyint(1)")
	private int pagado;
	
	public Estancia() {
		
	}

	public int getCodEstancia() {
		return codEstancia;
	}

	public void setCodEstancia(int codEstancia) {
		this.codEstancia = codEstancia;
	}

	public Cliente getDni() {
		return coddnionie;
	}

	public void setDni(Cliente dni) {
		this.coddnionie = dni;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Regimen getCodRegimen() {
		return codRegimen;
	}

	public void setCodRegimen(Regimen codRegimen) {
		this.codRegimen = codRegimen;
	}

	public int getOcupantes() {
		return ocupantes;
	}

	public void setOcupantes(int ocupantes) {
		this.ocupantes = ocupantes;
	}

	public int getPrecioestancia() {
		return precioestancia;
	}

	public void setPrecioestancia(int precioestancia) {
		this.precioestancia = precioestancia;
	}

	public int getPagado() {
		return pagado;
	}

	public void setPagado(int pagado) {
		this.pagado = pagado;
	}

	@Override
	public String toString() {
		return "Estancia [codEstancia=" + codEstancia + ", coddnionie=" + coddnionie + ", habitacion=" + habitacion
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", codRegimen=" + codRegimen
				+ ", ocupantes=" + ocupantes + ", precioestancia=" + precioestancia + ", pagado=" + pagado + "]";
	}
}
