package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import kanbandbnr.KBColumn;
import kanbandbnr.KBBoard;
import kanbandbnr.KBCard;
import kanbandbnr.KBUser;

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
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-example");
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
		int nb = manager.createQuery("select b from KBBoard b", KBBoard.class).getResultList().size();

		if (nb == 0) {

			KBBoard board = new KBBoard();
			board.setName("Board");

			KBColumn col1 = new KBColumn("TODO");
			KBColumn col2 = new KBColumn("DOING");
			KBColumn col3 = new KBColumn("DONE");

			board.addColumn(col1);
			board.addColumn(col2);
			board.addColumn(col3);

			KBUser user1 = new KBUser("Jean", "Bon", "beurre@mail.fr");
			KBUser user2 = new KBUser("Jean", "Aimarre", "tartine@mail.fr");

			KBCard card1 = new KBCard("ranger", "une maison rangée c'est bien", 30, "maison.com", "maison");
			card1.setAssignedUser(user1);
			KBCard card2 = new KBCard("faire à manger", "manger c'est bon des fois", 45, "cuisine.net", "cuisine");
			card2.setAssignedUser(user2);

			col1.addCard(card1);
			col1.addCard(card2);

			manager.persist(user1);
			manager.persist(user2);

			manager.persist(board);
		}
	}
	
	private void listCards() {
		List<KBCard> resultList = manager.createQuery("Select c From Card c", KBCard.class).getResultList();
		
		System.out.println("num of cards:" + resultList.size());
		for (KBCard next : resultList) {
			System.out.println("next card: " + next);
		}
	}

}
