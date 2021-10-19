package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.PetItem;

public class ListPetHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JavaGroupProjectRepo");
	
	public void insertItem(PetItem pi) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(pi);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<PetItem> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		List<PetItem> allItems = em.createQuery("SELECT i from PetItem i").getResultList();
		return allItems;
		
	}

	public void deleteItem(PetItem toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PetItem> typedQuery = em.createQuery("select pi from PetItem pi where pi.name = :selectedName and pi.species = :selectedSpecies", PetItem.class);
		
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedSpecies", toDelete.getSpecies());
		
		typedQuery.setMaxResults(1);
		
		PetItem result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public PetItem searchForBreedById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		PetItem found = em.find(PetItem.class, idToEdit);
		em.close();
		return found;
	}

	public void updateItem(PetItem toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<PetItem> searchForBreedByPuppy(String petName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PetItem> typedQuery = em.createQuery("select pi from PetItem pi where pi.name = :selectedName", PetItem.class);
		
		typedQuery.setParameter("selectedName", petName);
		
		List<PetItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<PetItem> searchForBreedByBreed(String speciesName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PetItem> typedQuery = em.createQuery("select pi from PetItem pi where pi.breed = :selectedSpecies", PetItem.class);
		
		typedQuery.setParameter("selectedSpecies", speciesName);
		
		List<PetItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	
	
	public void cleanUp() {
		emfactory.close();
	}
	
}