package aed.hibernate.tablas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="regimenes")
public class Regimen {

	@Id
	private int codRegimen;
	
	@ManyToOne
	@JoinColumn(name="codHotel")
	private Hotel codHotel;
	
	private String tipo;
	
	private int precio;
	
	@OneToMany(mappedBy = "codRegimen")
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

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public List<Estancia> getEstancias() {
		return estancias;
	}

	public void setEstancias(List<Estancia> estancias) {
		this.estancias = estancias;
	}
}
