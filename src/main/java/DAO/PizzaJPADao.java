package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Pizza;


public class PizzaJPADao implements IPizzaDao{
	
	//private ArrayList<Pizza> pizzas;
	
	
	@Override
	public List<Pizza> findAllPizzas() {
		// Etape 1 - Créer une instance d'EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa");
				
		// Début d'une unité de travail
		EntityManager em1 = emf.createEntityManager();
		// création d'une requête
		boolean answer =false;
		TypedQuery<Pizza> requete = em1.createQuery("SELECT p from Pizza p", Pizza.class);
		
		List<Pizza> pizzas = requete.getResultList();
		if (requete != null)
			answer = true;
		em1.close();
		emf.close();
		System.out.println(answer);
		return pizzas; 
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa");
		EntityManager em1 = emf.createEntityManager();
		EntityTransaction et = em1.getTransaction();
		et.begin();
		em1.persist(pizza);
		et.commit();
		em1.close();
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		/*
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa");
		EntityManager em1 = emf.createEntityManager();
		TypedQuery<Pizza> requete = em1.createQuery("SELECT p from Pizza p where p.code = codePizza", Pizza.class);
		Pizza pi = requete.getSingleResult();
		pi.setCode(pizza.getCode());
		pi.setLibelle(pizza.getLibelle());
		pi.setPrix(pizza.getPrix());
		
		EntityTransaction et = em1.getTransaction();
		et.begin();
		em1.merge(pi);
		et.commit();
		em1.close();
		*/
	}

	@Override
	public void deletePizza(String codePizza) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa");
		EntityManager em1 = emf.createEntityManager();
		TypedQuery<Pizza> requete = em1.createQuery("SELECT p from Pizza p where p.code = codePizza", Pizza.class);
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}

	
}