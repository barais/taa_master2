package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import kanbandbnr.Column;
import kanbandbnr.Board;
import kanbandbnr.Card;
import kanbandbnr.User;

/**
 * jdbc:hsqldb:hsql://localhost/
 * 
 * @author nrichard dbouillet
 *
 */
public class JpaEtienne {

	private EntityManager manager;

	public JpaEtienne(EntityManager manager) {
		super();
		this.manager = manager;
	}

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();

		JpaEtienne jpa = new JpaEtienne(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {

			jpa.populate();
//			jpa.listCards();

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		manager.close();
		factory.close();
	}

	private void populate() {
		int nb = manager.createQuery("select b from Board b", Board.class).getResultList().size();

		if (nb == 0) {

			Board board = new Board("Board");

			Column col1 = new Column("TODO");
			Column col2 = new Column("DOING");
			Column col3 = new Column("DONE");

			board.addColumn(col1);
			board.addColumn(col2);
			board.addColumn(col3);

			User user = new User("Jean", "Bon", "beurre@mail.fr");
			User user2 = new User("Jean", "Aimarre", "tartine@mail.fr");

			Card card1 = new Card("ranger", "une maison rangée c'est bien", 30, "maison.com", "maison");
			card1.setAssignedUser(user);
			Card card2 = new Card("faire à manger", "manger c'est bon des fois", 45, "cuisine.net", "cuisine");
			card2.setAssignedUser(user2);

			col1.addCard(card1);
			col1.addCard(card2);

			manager.persist(user);
			manager.persist(user2);

			manager.persist(board);
		}
	}
	
	private void listCards() {
		List<Card> resultList = manager.createQuery("Select c From Card c", Card.class).getResultList();
		
		System.out.println("num of cards:" + resultList.size());
		for (Card next : resultList) {
			System.out.println("next card: " + next);
		}
	}

}
