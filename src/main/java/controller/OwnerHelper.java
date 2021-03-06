package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Owner;

public class OwnerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JavaGroupProjectRepo");
	public void insertOwner(Owner o) {
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	em.persist(o);
	em.getTransaction().commit();
	em.close();
	}

public List<Owner> showAllOwners() {
EntityManager em = emfactory.createEntityManager();
List<Owner> allOwners = em.createQuery("SELECT s FROM Owner s").getResultList();
return allOwners;
}
}

