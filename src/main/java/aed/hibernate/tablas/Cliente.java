package aed.hibernate.tablas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "clientes")
public class Cliente {

	@Id
	@Column(name = "coddnionie", columnDefinition = "char(9)")
	private String coddnionie;

	@Column(name = "nombre", columnDefinition = "varchar(50)")
	private String nombre;

	@Column(name = "nacionalidad", columnDefinition = "varchar(40)")
	private String nacionalidad;

	@OneToMany(mappedBy = "coddnionie", cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
	private List<Estancia> estancias = new ArrayList<>();

	public String getCoddnionie() {
		return coddnionie;
	}

	public void setCoddnionie(String coddnionie) {
		this.coddnionie = coddnionie;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public List<Estancia> getEstancias() {
		return estancias;
	}

	public void setEstancias(List<Estancia> estancias) {
		this.estancias = estancias;
	}

	@Override
	public String toString() {
		return "Cliente [coddnionie=" + coddnionie + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad
				+ "]";
	}
}
