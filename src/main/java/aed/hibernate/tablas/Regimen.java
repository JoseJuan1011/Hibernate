package aed.hibernate.tablas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="regimenes")
public class Regimen {

	@Id
	@Column(name="codRegimen", columnDefinition = "int(11)")
	private int codRegimen;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name="codHotel")
	private Hotel codHotel;
	
	@Column(name = "tipo", columnDefinition = "char(2)")
	private String tipo;
	
	@Column(name = "preciodia", columnDefinition = "int(11)")
	private int preciodia;
	
	@OneToMany(mappedBy = "codRegimen", cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
	private List<Estancia> estancias = new ArrayList<>();
	
	public Regimen() {
		
	}

	public int getCodRegimen() {
		return codRegimen;
	}

	public void setCodRegimen(int codRegimen) {
		this.codRegimen = codRegimen;
	}

	public Hotel getCodHotel() {
		return codHotel;
	}

	public void setCodHotel(Hotel codHotel) {
		this.codHotel = codHotel;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getPreciodia() {
		return preciodia;
	}

	public void setPreciodia(int preciodia) {
		this.preciodia = preciodia;
	}

	public List<Estancia> getEstancias() {
		return estancias;
	}

	public void setEstancias(List<Estancia> estancias) {
		this.estancias = estancias;
	}

	@Override
	public String toString() {
		return "Regimen [codRegimen=" + codRegimen + ", codHotel=" + codHotel + ", tipo=" + tipo + ", preciodia=" + preciodia
				+ "]";
	}
}
