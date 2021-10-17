package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private LocalDate adoptionDate;
	@ManyToOne(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private Owner owner;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<HousePetItem> listOfItems;
	
	public ListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ListDetails(int id, String listName, LocalDate tripDate, Owner owner, List<HousePetItem> listOfItems) {
		super();
		this.id = id;
		this.listName = listName;
		this.adoptionDate = tripDate;
		this.owner = owner;
		this.listOfItems = listOfItems;
	}
	public ListDetails(String listName, LocalDate tripDate, Owner owner, List<HousePetItem> listOfItems) {
		super();
		this.listName = listName;
		this.adoptionDate = tripDate;
		this.owner = owner;
		this.listOfItems = listOfItems;
	}
	public ListDetails(String listName, LocalDate tripDate, Owner owner) {
		super();
		this.listName = listName;
		this.adoptionDate = tripDate;
		this.owner = owner;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public LocalDate getTripDate() {
		return adoptionDate;
	}
	public void setTripDate(LocalDate tripDate) {
		this.adoptionDate = tripDate;
	}
	public Owner getShopper() {
		return owner;
	}
	public void setShopper(Owner owner) {
		this.owner = owner;
	}
	public List<HousePetItem> getListOfItems() {
		return listOfItems;
	}
	public void setListOfItems(List<HousePetItem> listOfItems) {
		this.listOfItems = listOfItems;
	}
	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", adoptionDate=" + adoptionDate + ", owner=" + owner
				+ ", listOfItems=" + listOfItems + "]";
	}
}
