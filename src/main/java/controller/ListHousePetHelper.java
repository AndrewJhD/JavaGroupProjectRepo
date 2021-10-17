package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.HousePetItem;

public class ListHousePetHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("HousePetList");
	
	public void insertItem(HousePetItem pi) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(pi);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<HousePetItem> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		List<HousePetItem> allItems = em.createQuery("SELECT i from HousePetList i").getResultList();
		return allItems;
		
	}

	public void deleteItem(HousePetItem toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<HousePetItem> typedQuery = em.createQuery("select pi from HousePetList pi where pi.name = :selectedHousePet and pi.species = :selectedHousePet", HousePetItem.class);
		
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedSpecies", toDelete.getSpecies());
		
		typedQuery.setMaxResults(1);
		
		HousePetItem result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public HousePetItem searchForSpeciesById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		HousePetItem found = em.find(HousePetItem.class, idToEdit);
		em.close();
		return found;
	}

	public void updateItem(HousePetItem toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<HousePetItem> searchForBreedByPuppy(String puppyName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<HousePetItem> typedQuery = em.createQuery("select pi from HousePetItem pi where pi.name = :selectedHousePet", HousePetItem.class);
		
		typedQuery.setParameter("selectedHousePet", puppyName);
		
		List<HousePetItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<HousePetItem> searchForBreedByBreed(String nameName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<HousePetItem> typedQuery = em.createQuery("select pi from PuppyItem pi where pi.breed = :selectedSpecies", HousePetItem.class);
		
		typedQuery.setParameter("selectedSpecies", nameName);
		
		List<HousePetItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	
	
	public void cleanUp() {
		emfactory.close();
	}
	
}