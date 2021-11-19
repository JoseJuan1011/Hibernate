package aed.hibernate.tablas.trials;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity(name="Students")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Student {

	@Id
	private int rollid;
	
	@Column(name="nameStudent")
	private String name;
	
	@OneToMany(mappedBy = "student",fetch = FetchType.LAZY)
	private List<Laptop> laptops = new ArrayList<>();
	
	public Student() {
		
	}

	public int getRollid() {
		return rollid;
	}

	public void setRollid(int rollid) {
		this.rollid = rollid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Laptop> getLaptops() {
		return laptops;
	}

	public void setLaptops(List<Laptop> laptops) {
		this.laptops = laptops;
	}

	@Override
	public String toString() {
		return "Student [rollid=" + rollid + ", name=" + name + "]";
	}
}
