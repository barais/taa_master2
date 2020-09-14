package kanbandbnr;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Column {

	private Long id;

	private String title;

	private List<Card> cards = new ArrayList<Card>();
	
	private Board board;

	public Column() {
		super();
	}

	public Column(String title) {
		this.title = title;
	}

	public void addCard(Card card) {
		this.cards.add(card);
	}

	@ManyToOne
	public Board getBoard() {
		return board;
	}

	@OneToMany(mappedBy = "column", cascade = CascadeType.PERSIST)
	public List<Card> getCards() {
		return cards;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
