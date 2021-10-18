/**
 * @author alexanderpontier - ampontier1
 * CIS175 - Spring 2021
 * Oct 13, 2021
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.HousePetItem;

/**
 * @author alexanderpontier
 *
 */
public class HousePetItemHelper {
	
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JavaGroupProjectRepo");
	
	public void insertItems(HousePetItem hpi) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(hpi);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<HousePetItem> showAllItems() {
		EntityManager em = emfactory.createEntityManager();
		List<HousePetItem> allHousePets = em.createQuery("SELECT i FROM HousePetItem i").getResultList();
		return allHousePets;
	}
	
	public void deleteItems(HousePetItem toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<HousePetItem> typedQuery = em.createQuery("select hpi from HousePetItem hpi where hpi.species = :selectedSpecies and hpi.name = :selectedName", HousePetItem.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedSpecies", toDelete.getSpecies());
		typedQuery.setParameter("selectedName",toDelete.getName());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		HousePetItem result = typedQuery.getSingleResult();
		
		//remove it
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

	public List<HousePetItem> searchForSpeciesByName(String speciesName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<HousePetItem> typedQuery = em.createQuery("select hpi from HousePetItem hpi where hpi.name = :selectedName", HousePetItem.class);
		typedQuery.setParameter("selectedName", speciesName);
		
		List<HousePetItem> foundPets = typedQuery.getResultList();
		em.close();
		
		return foundPets;
	}

	public List<HousePetItem> searchForPetByName(String speciesName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<HousePetItem> typedQuery = em.createQuery("select hpi from HousePetItem hpi where hpi.species = :selectedName", HousePetItem.class);
		typedQuery.setParameter("selectedSpecies", speciesName);
		
		List<HousePetItem> foundPets = typedQuery.getResultList();
		em.close();
		
		return foundPets;
	}
	
	public void cleanUp() {
		emfactory.close();
	}

}
