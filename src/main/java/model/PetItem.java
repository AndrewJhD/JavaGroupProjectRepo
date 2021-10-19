package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="housepet")
public class PetItem {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="SPECIES")
	private String species;

	public PetItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public PetItem(String puppy, String breed) {
		super();
		this.name = puppy;
		this.species = breed;
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

	public void setName(String puppy) {
		this.name = puppy;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String breed) {
		this.species = breed;
	}

	@Override
	public String toString() {
		return "PetItem [id=" + id + ", name=" + name + ", species=" + species + "]";
	}

	public String returnItemDetails() {
		return this.name + ": " + this.species;
	}
}