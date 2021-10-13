package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="housepet")
public class HousePetItem {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="SPECIES")
	private String species;

	public HousePetItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public HousePetItem(String name, String species) {
		super();
		this.name = name;
		this.species = species;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	@Override
	public String toString() {
		return "HousePetItem [id=" + id + ", name=" + name + ", species=" + species + "]";
	}

	public String returnItemDetails() {
		return this.name + ": " + this.species;
	}
}
